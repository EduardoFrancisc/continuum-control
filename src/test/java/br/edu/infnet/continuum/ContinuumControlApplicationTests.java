package br.edu.infnet.continuum;

import br.edu.infnet.continuum.domain.enums.*;
import br.edu.infnet.continuum.domain.model.*;
import br.edu.infnet.continuum.dtos.AtribuirMissaoDTO;
import br.edu.infnet.continuum.dtos.MudarEstadoMissaoDTO;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.*;
import br.edu.infnet.continuum.service.MissaoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ContinuumControlApplicationTests {

	@Autowired
	private MissaoService missaoService;
	@Autowired
	private MissaoRepository missaoRepository;
	@Autowired
	private AgenteRepository agenteRepository;
	@Autowired
	private AnomaliaRepository anomaliaRepository;
	@Autowired
	private EHRepository ehRepository;
	@Autowired
	private AORepository aoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

//	@Test
//	void contextLoads() {
//	}

	@Test
	public void carregamentoAgentes(){
		assertFalse(agenteRepository.findAll().isEmpty(), "A lista de agentes não deveria estar vazia.");
	}

	@Test
	@DisplayName("Deve lançar EntidadeNaoLocalizada ao consultar agente com ID inexistente")
	public void testConsultaDetalhadaAgenteInexistente() {
		Long idInexistente = 999999L;
		EntidadeNaoLocalizada exception = assertThrows(
				EntidadeNaoLocalizada.class,
				() -> missaoService.getById(idInexistente),
				"Deveria lançar EntidadeNaoLocalizada para um ID que não existe."
		);
		// Verifica se a mensagem contém a indicação correta (flexível e seguro)
		assertTrue(exception.getMessage().contains("não encontrado"));
	}

	@Test
	@DisplayName("Deve impedir a criação de missão quando a anomalia for IRREVERSÍVEL")
	void impedirCriacaoDeMissaoEmAnomaliaIrreversivel() {

		EventoHistorico evento = new EventoHistorico();
		evento.setNome("Queda do Império Romano");
		evento.setDescricao("Evento histórico de grande impacto");
		evento.setDataInicio(LocalDate.of(476, 9, 4));
		evento.setDataFim(LocalDate.of(476, 9, 4));
		evento.setImportancia(ImportanciaEH.CRÍTICA);
		EventoHistorico eventoSalvo = ehRepository.save(evento);

		Anomalia anomalia = new Anomalia();
		anomalia.setNome("Distorção Temporal #01");
		anomalia.setEvento(eventoSalvo);
		anomalia.setDivergencia("Divergência detectada");
		anomalia.setDataDeteccao(LocalDateTime.now());
		anomalia.setEstado(EstadoAnomalia.IRREVERSÍVEL);
		anomalia.setRisco(RiscoAnomalia.ALTO);
		anomalia.setOrigem("Registro Civil");
		anomalia.setObservacoes("Análise necessária");
		Anomalia anomaliaSalva = anomaliaRepository.save(anomalia);

		Missao novaMissao = new Missao();
		novaMissao.setAnomalia(anomaliaSalva);
		novaMissao.setObjetivo("Tentar corrigir o incorrigível");
		novaMissao.setDestino_temporal("Ano 2050");
		novaMissao.setPrioridade(PrioridadeMissao.NORMAL);
		novaMissao.setEstado(EstadoMissao.PLANEJADA);
		novaMissao.setAgentes(new HashSet<>());

		try {
			missaoService.create(novaMissao);
			fail("Era pra ter lançado IllegalArgumentException");
		} catch (IllegalArgumentException ex) {
			if (ex.getMessage() == null || !ex.getMessage().contains("IRREVERSÍVEL")) {
				fail("Lançou a exceção, mas com mensagem incorreta: " + ex.getMessage());
			}
		}
	}

	@Test
	@DisplayName("Deve impedir a designação de agente com situação diferente de DISPONÍVEL")
	void impedirAtribuicaoDeAgenteNaoDisponivel() {

		EventoHistorico evento = new EventoHistorico();
		evento.setNome("Queda do Império Romano");
		evento.setDescricao("Evento histórico de grande impacto");
		evento.setDataInicio(LocalDate.of(476, 9, 4));
		evento.setDataFim(LocalDate.of(476, 9, 4));
		evento.setImportancia(ImportanciaEH.CRÍTICA);
		EventoHistorico eventoSalvo =  ehRepository.save(evento);

		Anomalia anomalia = new Anomalia();
		anomalia.setNome("Distorção Temporal #01");
		anomalia.setEvento(eventoSalvo);
		anomalia.setDivergencia("Divergência detectada");
		anomalia.setDataDeteccao(LocalDateTime.now());
		anomalia.setEstado(EstadoAnomalia.DETECTADA);
		anomalia.setRisco(RiscoAnomalia.MODERADO);
		anomalia.setOrigem("Registro Civil");
		anomalia.setObservacoes("Análise necessária");
		Anomalia anomaliaSalva = anomaliaRepository.save(anomalia);

		Missao missao = new Missao();
		missao.setAnomalia(anomaliaSalva);
		missao.setObjetivo("Tentar corrigir o incorrigível");
		missao.setDestino_temporal("Ano 2050");
		missao.setPrioridade(PrioridadeMissao.NORMAL);
		missao.setEstado(EstadoMissao.PLANEJADA);
		missao.setDataInicio(LocalDate.now());
		missao.setAgentes(new HashSet<>());
		Missao novaMissao = missaoRepository.save(missao);

		Agente agenteOcupado = new Agente();
		agenteOcupado.setNome("Agente Teste");
		agenteOcupado.setEspecialidade(EspecialidadeAgente.INVESTIGACAO);
		agenteOcupado.setSituacao(SituacaoAgente.EM_MISSÃO);
		agenteRepository.save(agenteOcupado);

		AtribuirMissaoDTO dto = new AtribuirMissaoDTO(
				novaMissao.getId(),
				List.of(agenteOcupado.getId()));

		try {
			missaoService.assignMission(dto);
			fail("Deveria ter lançado IllegalArgumentException ao atribuir agente que não esteja DISPONÍVEL.");
		} catch (IllegalArgumentException ex) {
			if (ex.getMessage() == null || !ex.getMessage().contains("DISPONÍVEL")) {
				fail("Falha: Deveria ter bloqueado a designação de um agente que não esteja DISPONÍVEL.");
			}
		}

	}

	@Test
	@DisplayName("Deve autorizar missão de emergência com sucesso quando a autorização existir")
	void deveAutorizarMissaoComSucessoQuandoPossuiAutorizacao() {
		EventoHistorico evento = new EventoHistorico();
		evento.setNome("Queda do Império Romano");
		evento.setDescricao("Evento histórico de grande impacto");
		evento.setDataInicio(LocalDate.of(476, 9, 4));
		evento.setDataFim(LocalDate.of(476, 9, 4));
		evento.setImportancia(ImportanciaEH.CRÍTICA);
		EventoHistorico eventoSalvo =  ehRepository.save(evento);

		Anomalia anomalia = new Anomalia();
		anomalia.setNome("Distorção Temporal #01");
		anomalia.setEvento(eventoSalvo);
		anomalia.setDivergencia("Divergência detectada");
		anomalia.setDataDeteccao(LocalDateTime.now());
		anomalia.setEstado(EstadoAnomalia.DETECTADA);
		anomalia.setRisco(RiscoAnomalia.MODERADO);
		anomalia.setOrigem("Registro Civil");
		anomalia.setObservacoes("Análise necessária");
		Anomalia anomaliaSalva = anomaliaRepository.save(anomalia);

		Missao missao = new Missao();
		missao.setAnomalia(anomaliaSalva);
		missao.setObjetivo("Tentar corrigir o incorrigível");
		missao.setDestino_temporal("Ano 2050");
		missao.setPrioridade(PrioridadeMissao.EMERGÊNCIA);
		missao.setEstado(EstadoMissao.PLANEJADA);
		missao.setDataInicio(LocalDate.now());
		missao.setAgentes(new HashSet<>());
		Missao novaMissao = missaoRepository.save(missao);

		// Busca um usuário cadastrado ou cria um responsável pela autorização
		Usuario supervisor = usuarioRepository.findAll().stream().findFirst().orElseGet(() -> {
			Usuario u = new Usuario("supervisor_teste", "123456", PerfilUsuario.SUPERVISOR);
			return usuarioRepository.save(u);
		});

		AutorizacaoOperacao autorizacao = new AutorizacaoOperacao();
		autorizacao.setMissao(novaMissao);
		autorizacao.setResponsavel(supervisor);
		autorizacao.setInstante(LocalDateTime.now());
		autorizacao.setObservacao("Autorização emitida pelo supervisor.");
		aoRepository.save(autorizacao);

		MudarEstadoMissaoDTO dto = new MudarEstadoMissaoDTO(missao.getId(), EstadoMissao.AUTORIZADA);

		missaoService.alterState(dto);
		Missao missaoAtualizada = missaoService.getById(missao.getId());

		if (missaoAtualizada.getEstado() != EstadoMissao.AUTORIZADA) {
			fail("Falha: O estado da missão deveria ter mudado para AUTORIZADA.");
		}
	}

	@Test
	@DisplayName("Deve liberar os agentes de volta para DISPONÍVEL ao concluir a missão")
	void deveLiberarAgentesAoConcluirMissao() {
		EventoHistorico evento = new EventoHistorico();
		evento.setNome("Queda do Império Romano");
		evento.setDescricao("Evento histórico de grande impacto");
		evento.setDataInicio(LocalDate.of(476, 9, 4));
		evento.setDataFim(LocalDate.of(476, 9, 4));
		evento.setImportancia(ImportanciaEH.CRÍTICA);
		EventoHistorico eventoSalvo =  ehRepository.save(evento);

		Anomalia anomalia = new Anomalia();
		anomalia.setNome("Distorção Temporal #01");
		anomalia.setEvento(eventoSalvo);
		anomalia.setDivergencia("Divergência detectada");
		anomalia.setDataDeteccao(LocalDateTime.now());
		anomalia.setEstado(EstadoAnomalia.CONFIRMADA);
		anomalia.setRisco(RiscoAnomalia.BAIXO);
		anomalia.setOrigem("Registro Civil");
		anomalia.setObservacoes("Análise necessária");
		Anomalia anomaliaSalva = anomaliaRepository.save(anomalia);

		Missao missao = new Missao();
		missao.setAnomalia(anomaliaSalva);
		missao.setObjetivo("Tentar corrigir o incorrigível");
		missao.setDestino_temporal("Ano 2050");
		missao.setPrioridade(PrioridadeMissao.NORMAL);
		missao.setEstado(EstadoMissao.EM_EXECUÇÃO);
		missao.setDataInicio(LocalDate.now());
		missao.setAgentes(new HashSet<>());
		Missao novaMissao = missaoRepository.save(missao);

		Agente agenteOcupado = new Agente();
		agenteOcupado.setNome("Agente Teste");
		agenteOcupado.setEspecialidade(EspecialidadeAgente.INVESTIGACAO);
		agenteOcupado.setSituacao(SituacaoAgente.EM_MISSÃO);
		Agente agenteEmMissao = agenteRepository.save(agenteOcupado);


		novaMissao.getAgentes().add(agenteEmMissao);
		missaoRepository.save(novaMissao);

		MudarEstadoMissaoDTO dto = new MudarEstadoMissaoDTO(novaMissao.getId(), EstadoMissao.CONCLUÍDA);
		missaoService.alterState(dto);

		Agente agenteVerificado = agenteRepository.findById(agenteEmMissao.getId()).orElseThrow();
		if (agenteVerificado.getSituacao() != SituacaoAgente.DISPONÍVEL) {
			fail("Falha: O agente deveria ter voltado para a situação DISPONÍVEL após a conclusão da missão.");
		}
		Missao missaoVerificada = missaoService.getById(novaMissao.getId());
		if (missaoVerificada.getEstado() != EstadoMissao.CONCLUÍDA) {
			fail("Falha: A missão deveria estar com o estado CONCLUÍDA.");
		}
	}



}

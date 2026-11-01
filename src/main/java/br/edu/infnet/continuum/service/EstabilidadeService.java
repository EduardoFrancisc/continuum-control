package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.EstadoMissao;
import br.edu.infnet.continuum.domain.enums.ImpactoObservado;
import br.edu.infnet.continuum.domain.enums.RiscoAnomalia;
import br.edu.infnet.continuum.domain.enums.SituacaoAgente;
import br.edu.infnet.continuum.dtos.EstadoOperacionalDTO;
import br.edu.infnet.continuum.repository.AgenteRepository;
import br.edu.infnet.continuum.repository.AnomaliaRepository;
import br.edu.infnet.continuum.repository.IntervencaoRepository;
import br.edu.infnet.continuum.repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EstabilidadeService {
    private final IntervencaoRepository intervencaoRepository;
    private final AnomaliaRepository anomaliaRepository;
    private final MissaoRepository missaoRepository;

    private final AgenteRepository agenteRepository;


    public EstabilidadeService(IntervencaoRepository intervencaoRepository,
                               AnomaliaRepository anomaliaRepository,
                               MissaoRepository missaoRepository,
                               AgenteRepository agenteRepository) {
        this.intervencaoRepository = intervencaoRepository;
        this.anomaliaRepository = anomaliaRepository;
        this.missaoRepository = missaoRepository;
        this.agenteRepository = agenteRepository;
    }

    public Map<Integer, String> getEstabilidadeTemporal() {
        Integer indice = 100;

        Integer intervencoesSeveras = intervencaoRepository.countAllByImpactoEstimado(ImpactoObservado.SEVERO);
        Integer anomaliasCriticas = anomaliaRepository.countAnomaliaByRisco(RiscoAnomalia.CRÍTICO);
        Integer missoesFalhas = missaoRepository.countMissaoByEstado(EstadoMissao.FALHOU);
        Integer anomaliasAtivas = anomaliaRepository.countAnomaliaByIsActiveTrueAndIsDeletedFalse();
        Integer missoesEmExecucao = missaoRepository.countMissaoByEstado(EstadoMissao.EM_EXECUÇÃO);

        Integer num_estabilidade = indice - (
                (intervencoesSeveras * 10) +
                        (anomaliasCriticas * 7) +
                        (missoesFalhas * 5) +
                        (anomaliasAtivas * 2) +
                        (missoesEmExecucao * 1)
        );

        Integer resultado = Math.max(0, num_estabilidade);

        String estabilidade_qualitativa;

        if (resultado >= 80) {
            estabilidade_qualitativa = "ESTÁVEL";
        } else if (resultado >= 60) {
            estabilidade_qualitativa = "ATENÇÃO";
        } else if (resultado >= 40) {
            estabilidade_qualitativa = "INSTÁVEL";
        } else if (resultado >= 20) {
            estabilidade_qualitativa = "CRÍTICO";
        } else {
            estabilidade_qualitativa = "COLAPSO TEMPORAL";
        }

        return Map.of(resultado, estabilidade_qualitativa);
    }


    public EstadoOperacionalDTO getEstadoOperacional() {
        Integer agentesDisponiveis = agenteRepository.getAgentesBySituacaoAndIsDeletedFalse(SituacaoAgente.DISPONÍVEL).size();
        Integer agentesEmMissao = agenteRepository.getAgentesBySituacaoAndIsDeletedFalse(SituacaoAgente.EM_MISSÃO).size();
        Integer missaoEmExecucao = missaoRepository.getMissaoByEstado(EstadoMissao.EM_EXECUÇÃO).size();
        Integer anomaliasAtivas = anomaliaRepository.countAnomaliaByIsActiveTrueAndIsDeletedFalse();
        Integer anomaliasCriticas = anomaliaRepository.countAnomaliaByRisco(RiscoAnomalia.CRÍTICO);
        String estadoLinhaTemporal = getEstabilidadeTemporal().values().iterator().next();

        return new EstadoOperacionalDTO(
                agentesDisponiveis,
                agentesEmMissao,
                missaoEmExecucao,
                anomaliasAtivas,
                anomaliasCriticas,
                estadoLinhaTemporal
        );
    }
}

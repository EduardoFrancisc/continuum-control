package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.*;
import br.edu.infnet.continuum.domain.model.Agente;
import br.edu.infnet.continuum.domain.model.Anomalia;
import br.edu.infnet.continuum.domain.model.Missao;
import br.edu.infnet.continuum.dtos.AtribuirMissaoDTO;
import br.edu.infnet.continuum.dtos.MudarEstadoMissaoDTO;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.MissaoRepository;
import jakarta.validation.Valid;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MissaoService {
    private final MissaoRepository missaoRepository;
    private final AgenteService agenteService;
    private final AOService aoService;
    private final AnomaliaService anomaliaService;

    public MissaoService(MissaoRepository missaoRepository,
                         AgenteService agenteService,
                         AOService aoService,
                         AnomaliaService anomaliaService
    ){
        this.missaoRepository = missaoRepository;
        this.agenteService = agenteService;
        this.aoService = aoService;
        this.anomaliaService = anomaliaService;
    }

    public List<Missao> getAll() {
        return missaoRepository.findAll();
    }

    public Missao getById(Long id) {
        return missaoRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Missão " + id + " não encontrado(a).")
        );
    }

    public List<Missao> getByInProgress(){
        return missaoRepository.getMissaoByEstadoAndIsDeletedFalse(EstadoMissao.EM_EXECUÇÃO);
    }

    public List<Missao> getByState(EstadoMissao estado) {
        return missaoRepository.getMissaoByEstadoAndIsDeletedFalse(estado);
    }

    public List<Missao> getByAnomaly(Long id) {

        List<Missao> missoes = missaoRepository.getByAnomalia_Id(id);

        if(missoes.isEmpty()){
            throw new EntidadeNaoLocalizada("Anomalia " + id + " não encontrada em nenhuma missão.");
        }
        else {
            return missoes;
        }
    }

    public List<Missao> getByAgent(Long id) {

        List<Missao> missoes = missaoRepository.getByAgent(id);

        if(missoes.isEmpty()){
            throw new EntidadeNaoLocalizada("Agente " + id + " não encontrada em nenhuma missão.");
        }
        else {
            return missoes;
        }
    }

    //Atualiza o cache quando uma missão é criada
    @CacheEvict(value = {"estabilidadeTemporal", "estadoOperacional"}, allEntries = true)
    public Missao create(Missao missao) {

        Anomalia a = anomaliaService.getById(missao.getAnomalia().getId());

        Set<Agente> ids = new HashSet<>(missao.getAgentes());

        if (ids.size() != missao.getAgentes().size()) {
            throw new IllegalArgumentException("Existem IDs de agentes repetidos.");
        }

        if (a.getEstado() == EstadoAnomalia.IRREVERSÍVEL){
            throw new IllegalArgumentException("Esta anomalia é 'IRREVERSÍVEL', não adianta criar missões para ela.");
        }

        return missaoRepository.save(missao);
    }

    @Transactional
    @CacheEvict(value = {"estabilidadeTemporal", "estadoOperacional"}, allEntries = true)
    public Missao assignMission(AtribuirMissaoDTO dto) {
        Missao m = getById(dto.id());
        Set<Agente> novosAgentes = new HashSet<>();
        Set<Long> ids = new HashSet<>(dto.idsAgentes()); //Tira os duplicatas

        if (ids.size() != dto.idsAgentes().size()) {
            throw new IllegalArgumentException("Existem IDs de agentes repetidos.");
        }


        for (Long id : dto.idsAgentes()) {
            Agente agente = agenteService.getById(id);

            if (agente.getSituacao() != SituacaoAgente.DISPONÍVEL){
                throw new IllegalArgumentException("O agente " + agente.getId() + " não está 'DISPONÍVEL' ele(a) está " + agente.getSituacao().name());
            }

            agente.setSituacao(SituacaoAgente.EM_MISSÃO);
            agenteService.update(agente, agente.getId());
            novosAgentes.add(agente);
        }

        Set<Agente> totalidadeAgentes = new HashSet<>(m.getAgentes());

        totalidadeAgentes.addAll(novosAgentes);

        m.setAgentes(totalidadeAgentes);

        return missaoRepository.save(m);
    }

    @Transactional
    @CacheEvict(value = {"estabilidadeTemporal", "estadoOperacional"}, allEntries = true)
    public Missao alterState(@Valid MudarEstadoMissaoDTO dto) {
        Missao m = getById(dto.id());

        //PLANEJADA, AUTORIZADA, EM_EXECUÇÃO, CONCLUÍDA, CANCELADA, FALHOU
        switch (dto.estado()){
            case AUTORIZADA -> {
                if (m.getEstado() != EstadoMissao.PLANEJADA){
                    throw new IllegalArgumentException("Apenas uma missão planejada pode ser 'AUTORIZADA'.");
                }
                if (m.getPrioridade() == PrioridadeMissao.EMERGÊNCIA && aoService.getByMission(dto.id()) == null) {
                    throw new EntidadeNaoLocalizada("A prioridade da Missão " + dto.id() + " foi classificada como 'EMERGÊNCIA' e não possui uma autorização de operação.");
                }

                Anomalia anomalia = anomaliaService.getById(m.getAnomalia().getId());
                if (anomalia.getRisco() == RiscoAnomalia.CRÍTICO && aoService.getByMission(dto.id()) == null){
                    throw new EntidadeNaoLocalizada("A anomalia da Missão " + dto.id() + " foi classificada como 'CRÍTICO' e não possui uma autorização de operação.");
                }
                m.setEstado(EstadoMissao.AUTORIZADA);
            }
            case EM_EXECUÇÃO -> {
                if (m.getEstado() != EstadoMissao.AUTORIZADA){
                    throw new IllegalArgumentException("A missão "+dto.id()+" não pode mudar entrar 'EM_EXECUÇÃO' porque ainda não foi 'AUTORIZADA'.");
                }
                m.setEstado(dto.estado());
            }

            case CONCLUÍDA -> {
                if (m.getEstado() != EstadoMissao.EM_EXECUÇÃO){
                    throw new IllegalArgumentException("A missão "+dto.id()+" não está 'EM_EXECUÇÃO' para ser 'CONCLUÍDA'.");
                }
                m.setEstado(dto.estado());

                m.getAgentes().forEach(a -> {
                    a.setSituacao(SituacaoAgente.DISPONÍVEL);
                    agenteService.update(a, a.getId());
                });
            }
            case CANCELADA -> {
                if (m.getEstado() == EstadoMissao.CONCLUÍDA){
                    throw new IllegalArgumentException("A missão "+dto.id()+" já foi 'CONCLUÍDA', não pode ser 'CANCELADA'.");
                }
                m.setEstado(dto.estado());

                m.getAgentes().forEach(a -> {
                    a.setSituacao(SituacaoAgente.DISPONÍVEL);
                    agenteService.update(a, a.getId());
                });
            }
            case FALHOU -> {
                if (m.getEstado() == EstadoMissao.CONCLUÍDA){
                    throw new IllegalArgumentException("A missão "+dto.id()+" já foi 'CONCLUÍDA', não é possível designar 'FALHOU'.");
                }
                m.setEstado(dto.estado());

                m.getAgentes().forEach(a -> {
                    a.setSituacao(SituacaoAgente.DISPONÍVEL);
                    agenteService.update(a, a.getId());
                });
            }
        }
        return missaoRepository.save(m);
    }
}

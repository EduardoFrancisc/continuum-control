package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.EstadoMissao;
import br.edu.infnet.continuum.domain.enums.PrioridadeMissao;
import br.edu.infnet.continuum.domain.enums.RiscoAnomalia;
import br.edu.infnet.continuum.domain.model.Agente;
import br.edu.infnet.continuum.domain.model.Anomalia;
import br.edu.infnet.continuum.domain.model.Missao;
import br.edu.infnet.continuum.dtos.AtribuirMissaoDTO;
import br.edu.infnet.continuum.dtos.MudarEstadoMissaoDTO;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.MissaoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

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
        return missaoRepository.getMissaoByEstado(EstadoMissao.EM_EXECUÇÃO);
    }

    public List<Missao> getByState(EstadoMissao estado) {
        return missaoRepository.getMissaoByEstado(estado);
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

    public Missao create(Missao missao) {

        Set<Agente> ids = new HashSet<>(missao.getAgentes());

        if (ids.size() != missao.getAgentes().size()) {
            throw new IllegalArgumentException("Existem IDs de agentes repetidos.");
        }

        return missaoRepository.save(missao);
    }

    public Missao assignMission(AtribuirMissaoDTO dto) {
        Missao m = getById(dto.id());

        Set<Agente> novosAgentes = new HashSet<>();
        Set<Long> ids = new HashSet<>(dto.idsAgentes()); //Tira os duplicados

        if (ids.size() != dto.idsAgentes().size()) {
            throw new IllegalArgumentException("Existem IDs de agentes repetidos.");
        }

        //verificar o estado dos agentes, se necessário ainda

        for (Long id : dto.idsAgentes()) {
            Agente agente = agenteService.getById(id);

            //Verifica se algum agente ja está na missão
            if (m.getAgentes().stream().map(agenteAtual -> agenteAtual.getId()).toList().contains(id)){
                throw new IllegalArgumentException("O agente " + id + " já está na missão.");
            }
            novosAgentes.add(agente);
        }

        Set<Agente> totalidadeAgentes = new HashSet<>(m.getAgentes());

        totalidadeAgentes.addAll(novosAgentes);

        m.setAgentes(totalidadeAgentes);

        return missaoRepository.save(m);
    }

    public Missao alterState(@Valid MudarEstadoMissaoDTO dto) {
        Missao m = getById(dto.id());

        //PLANEJADA, AUTORIZADA, EM_EXECUÇÃO, CONCLUÍDA, CANCELADA, FALHOU
        switch (dto.estado()){
            case AUTORIZADA -> {
                if (m.getPrioridade() == PrioridadeMissao.EMERGÊNCIA && aoService.getByMission(dto.id()) == null) {
                    throw new EntidadeNaoLocalizada("Missão " + dto.id() + " não possui uma autorização de operação.");
                }

                Anomalia anomalia = anomaliaService.getById(m.getAnomalia().getId());

                if (anomalia.getRisco() == RiscoAnomalia.CRÍTICO && aoService.getByMission(dto.id()) == null){
                    throw new EntidadeNaoLocalizada("A anomalia da Missão " + dto.id() + " foi classificada como 'CRÍTICO' e não possui uma autorização de operação.");
                }

                m.setEstado(EstadoMissao.AUTORIZADA);
            }
//            case EM_EXECUÇÃO -> {
//
//            }
//            case CONCLUÍDA -> {
//
//            }
//            case CANCELADA -> {
//
//            }
//            case FALHOU -> {
//
//            }
//            default -> {
//
//            }
        }
        return missaoRepository.save(m);
    }
}

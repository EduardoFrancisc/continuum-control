package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.EstadoMissao;
import br.edu.infnet.continuum.domain.model.Missao;
import br.edu.infnet.continuum.exception.EntidadeDeletada;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {
    private final MissaoRepository repository;

    public MissaoService(MissaoRepository repository){
        this.repository = repository;
    }

    public List<Missao> getAll() {
        return repository.findAll();
    }

    public Missao getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Missão " + id + " não encontrado(a).")
        );
    }

    public List<Missao> getByInProgress(){
        return repository.getMissaoByEstado(EstadoMissao.EM_EXECUÇÃO);
    }


    public List<Missao> getByState(EstadoMissao estado) {
        return repository.getMissaoByEstado(estado);
    }

    public List<Missao> getByAnomaly(Long id) {

        List<Missao> missoes = repository.getByAnomalia_Id(id);

        if(missoes.isEmpty()){
            throw new EntidadeNaoLocalizada("Anomalia " + id + " não encontrada em nenhuma missão.");
        }
        else {
            return missoes;
        }
    }

    public List<Missao> getByAgent(Long id) {

        List<Missao> missoes = repository.getByAgent(id);

        if(missoes.isEmpty()){
            throw new EntidadeNaoLocalizada("Agente " + id + " não encontrada em nenhuma missão.");
        }
        else {
            return missoes;
        }
    }
}

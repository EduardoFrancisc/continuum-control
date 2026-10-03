package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.SituacaoAgente;
import br.edu.infnet.continuum.domain.model.Agente;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.AgenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenteService {
    private AgenteRepository agenteRepository;

    public AgenteService(AgenteRepository agenteRepository){
        this.agenteRepository = agenteRepository;
    }

    public List<Agente> getAll(){
        return agenteRepository.findAll();
    }

    public Agente getById(Long id) {
        return agenteRepository.findById(id).orElseThrow(() -> new EntidadeNaoLocalizada("Agente "+id+" não encontrado."));
    }

    public List<Agente> getByDisponibility() {
        return agenteRepository.getAgentesBySituacao(SituacaoAgente.DISPONÍVEL);
    }
}

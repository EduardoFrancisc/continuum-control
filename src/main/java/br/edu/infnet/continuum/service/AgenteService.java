package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.EspecialidadeAgente;
import br.edu.infnet.continuum.domain.enums.SituacaoAgente;
import br.edu.infnet.continuum.domain.model.Agente;
import br.edu.infnet.continuum.exception.AgenteDeletado;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.AgenteRepository;
import jakarta.validation.Valid;
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
        return agenteRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Agente "+id+" não encontrado.")
        );
    }

    //Agentes disponíveis
    public List<Agente> getByDisponibility() {
        return agenteRepository.getAgentesBySituacaoAndIsDeletedFalse(SituacaoAgente.DISPONÍVEL);
    }

    public List<Agente> getBySituacao(SituacaoAgente situacao){
        return agenteRepository.getAgentesBySituacaoAndIsDeletedFalse(situacao);
    }

    public List<Agente> getByEspecialidade(EspecialidadeAgente especialidade) {
        return agenteRepository.getAgentesByEspecialidadeAndIsDeletedFalse(especialidade);
    }

    public Agente create(@Valid Agente agente) {
        return agenteRepository.save(agente);
    }

    public Agente delete(Long id) {
        Agente a = getById(id);
        if (a.getIsDeleted()){
            throw new AgenteDeletado("Agente "+id+" já está deletado(a).");
        }
        a.setIsDeleted(true);
        return agenteRepository.save(a);
    }

    public Agente update(@Valid Agente n, Long id) {
        Agente a = getById(id);

        a.setNome(n.getNome());
        a.setEspecialidade(n.getEspecialidade());
        a.setSituacao(n.getSituacao());

        return agenteRepository.save(a);
    }
}

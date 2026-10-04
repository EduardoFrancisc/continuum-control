package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.EspecialidadeAgente;
import br.edu.infnet.continuum.domain.enums.SituacaoAgente;
import br.edu.infnet.continuum.domain.model.Agente;
import br.edu.infnet.continuum.exception.EntidadeDeletada;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.AgenteRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenteService {
    private AgenteRepository repository;

    public AgenteService(AgenteRepository agenteRepository){
        this.repository = agenteRepository;
    }

    public List<Agente> getAll(){
        return repository.findAll();
    }

    public Agente getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Agente "+id+" não encontrado.")
        );
    }

    //Agentes disponíveis
    public List<Agente> getByDisponibility() {
        return repository.getAgentesBySituacaoAndIsDeletedFalse(SituacaoAgente.DISPONÍVEL);
    }

    public List<Agente> getBySituacao(SituacaoAgente situacao){
        return repository.getAgentesBySituacaoAndIsDeletedFalse(situacao);
    }

    public List<Agente> getByEspecialidade(EspecialidadeAgente especialidade) {
        return repository.getAgentesByEspecialidadeAndIsDeletedFalse(especialidade);
    }

    public Agente create(@Valid Agente agente) {
        return repository.save(agente);
    }

    public Agente delete(Long id) {
        Agente a = getById(id);
        if (a.getIsDeleted()){
            throw new EntidadeDeletada("Agente "+id+" já está deletado(a).");
        }
        a.setIsDeleted(true);
        return repository.save(a);
    }

    public Agente update(@Valid Agente n, Long id) {
        Agente a = getById(id);

        if (a.getIsDeleted()){throw new EntidadeDeletada("Agente "+id+" já está deletado(a).");}

        a.setNome(n.getNome());
        a.setEspecialidade(n.getEspecialidade());
        a.setSituacao(n.getSituacao());

        return repository.save(a);
    }



}

package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.EspecialidadeAgente;
import br.edu.infnet.continuum.domain.enums.SituacaoAgente;
import br.edu.infnet.continuum.domain.model.Agente;
import br.edu.infnet.continuum.exception.EntidadeDeletada;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.AgenteRepository;
import org.springframework.cache.annotation.CacheEvict;
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
                () -> new EntidadeNaoLocalizada("Agente "+id+" não encontrado(a).")
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

    @CacheEvict(value = {"estabilidadeTemporal", "estadoOperacional"}, allEntries = true)
    public Agente create(Agente agente) {
        return repository.save(agente);
    }

    @CacheEvict(value = {"estabilidadeTemporal", "estadoOperacional"}, allEntries = true)
    public Agente delete(Long id) {
        Agente a = getById(id);

        if (a.getSituacao() == SituacaoAgente.EM_MISSÃO){
            throw new IllegalArgumentException("Agente " + a.getId() + " está em missão e não pode ser deletado agora.");
        }

        if (a.getIsDeleted()){
            throw new EntidadeDeletada("Agente "+id+" já está deletado(a).");
        }
        a.setIsDeleted(true);
        a.setSituacao(SituacaoAgente.INATIVO);
        return repository.save(a);
    }

    @CacheEvict(value = {"estabilidadeTemporal", "estadoOperacional"}, allEntries = true)
    public Agente update(Agente n, Long id) {
        Agente a = getById(id);

        if (a.getIsDeleted()){
            throw new EntidadeDeletada("Agente "+id+" está deletado(a).");
        }

        a.setNome(n.getNome());
        a.setEspecialidade(n.getEspecialidade());
        a.setSituacao(n.getSituacao());

        return repository.save(a);
    }



}

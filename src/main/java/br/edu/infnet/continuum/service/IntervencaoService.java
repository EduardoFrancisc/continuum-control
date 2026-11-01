package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.EstadoMissao;
import br.edu.infnet.continuum.domain.model.Intervencao;
import br.edu.infnet.continuum.domain.model.Missao;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.IntervencaoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntervencaoService {
    private final IntervencaoRepository repository;
    private final MissaoService missaoService;

    public IntervencaoService(IntervencaoRepository repository, MissaoService missaoService) {
        this.repository = repository;
        this.missaoService = missaoService;
    }


    public List<Intervencao> getAll() {
        return repository.findAll();
    }

    public Intervencao getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Intervenção "+id+" não encontrado(a).")
        );
    }


    public Intervencao create(@Valid Intervencao intervencao) {
        Missao m = missaoService.getById(intervencao.getMissao().getId());

        if (m.getEstado() != EstadoMissao.EM_EXECUÇÃO){
            throw new IllegalArgumentException("A missão "+m.getId()+" não está em execução, logo não pode receber novas intervenções.");
        }
        return repository.save(intervencao);
    }
}


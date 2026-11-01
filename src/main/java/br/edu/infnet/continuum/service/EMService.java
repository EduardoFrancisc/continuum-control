package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.EstadoMissao;
import br.edu.infnet.continuum.domain.model.EncerramentoMissoes;
import br.edu.infnet.continuum.domain.model.Missao;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.EMRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EMService {
    private final EMRepository repository;
    private final MissaoService missaoService;

    public EMService(EMRepository repository, MissaoService missaoService){
        this.repository = repository;
        this.missaoService = missaoService;
    }

    public List<EncerramentoMissoes> getAll() {
        return repository.findAll();
    }

    public EncerramentoMissoes getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Encerramento "+id+" não encontrado(a).")
        );
    }

    public EncerramentoMissoes create(@Valid EncerramentoMissoes encerramentoMissoes) {
        Missao m = missaoService.getById(encerramentoMissoes.getId());

        if (m.getEstado() != EstadoMissao.EM_EXECUÇÃO){
            throw new IllegalArgumentException("A missão "+m.getId()+" não está em execução, logo não pode ser encerrada.");
        }

        return repository.save(encerramentoMissoes);
    }
}

package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.model.EncerramentoMissoes;
import br.edu.infnet.continuum.domain.model.EventoHistorico;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.EMRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EMService {
    private EMRepository repository;

    public EMService(EMRepository repository){
        this.repository = repository;
    }


    public List<EncerramentoMissoes> getAll() {
        return repository.findAll();
    }

    public EncerramentoMissoes getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Encerramento "+id+" não encontrado(a).")
        );
    }
}

package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.ImportanciaEH;
import br.edu.infnet.continuum.domain.model.EventoHistorico;
import br.edu.infnet.continuum.exception.EntidadeDeletada;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.EHRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EHService {
    private EHRepository repository;

    public EHService (EHRepository repository) {
        this.repository = repository;
    }

    public List<EventoHistorico> getAll(){
        return repository.findAll();
    }

    public EventoHistorico getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Evento Historico "+id+" não encontrado(a).")
        );
    }

    public EventoHistorico delete(Long id) {
        EventoHistorico a = getById(id);
        if (a.getIsDeleted()){
            throw new EntidadeDeletada("Agente "+id+" já está deletado(a).");
        }
        a.setIsDeleted(true);
        return repository.save(a);
    }

    public List<EventoHistorico> getByImportance(ImportanciaEH importancia) {
        return repository.getEventoHistoricoByImportanciaAndIsDeletedFalse(importancia);
    }

    public List<EventoHistorico> getByPeriod(LocalDate inicio, LocalDate fim) {
        return repository.getEventoHistoricoByDataInicioBetween(inicio, fim);
    }
}

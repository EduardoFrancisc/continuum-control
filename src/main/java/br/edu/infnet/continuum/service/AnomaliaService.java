package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.EstadoAnomalia;
import br.edu.infnet.continuum.domain.enums.RiscoAnomalia;
import br.edu.infnet.continuum.domain.model.Anomalia;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.AnomaliaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomaliaService {

    private final AnomaliaRepository repository;

    public AnomaliaService(AnomaliaRepository repository){
        this.repository = repository;
    }

    public List<Anomalia> getAll() {
        return repository.findAll();
    }

    public Anomalia getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Anomalia "+id+" não encontrado(a).")
        );
    }

    public List<Anomalia> getByActive(){
        return repository.getAnomaliaByIsActiveTrueAndIsDeletedFalse();
    }

    public List<Anomalia> getByCritical() {
        return repository.getAnomaliaByRiscoAndIsActiveTrueAndIsDeletedFalse(RiscoAnomalia.CRÍTICO);
    }

    public List<Anomalia> getByLevelRisc(RiscoAnomalia risco) {
        return repository.getAnomaliaByRiscoAndIsActiveTrueAndIsDeletedFalse(risco);
    }

    public List<Anomalia> getByState(EstadoAnomalia estado) {
        return repository.getAnomaliaByEstadoAndIsActiveTrueAndIsDeletedFalse(estado);
    }
}

package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.repository.AnomaliaRepository;
import org.springframework.stereotype.Service;

@Service
public class AnomaliaService {

    private final AnomaliaRepository repository;

    public AnomaliaService(AnomaliaRepository repository){
        this.repository = repository;
    }
}

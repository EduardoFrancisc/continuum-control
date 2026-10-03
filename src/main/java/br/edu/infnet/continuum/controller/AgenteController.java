package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.model.Agente;
import br.edu.infnet.continuum.service.AgenteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agente")
public class AgenteController {

    private final AgenteService service;

    public AgenteController(AgenteService AventureiroService) {
        this.service = AventureiroService;
    }

    @GetMapping
    public List<Agente> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Agente getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/disponiveis")
    public List<Agente> getByDisponibility(){
        return service.getByDisponibility();
    }





}

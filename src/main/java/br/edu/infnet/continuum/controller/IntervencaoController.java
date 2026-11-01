package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.model.Intervencao;
import br.edu.infnet.continuum.service.IntervencaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intervencao")
public class IntervencaoController {

    private final IntervencaoService service;

    public IntervencaoController(IntervencaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Intervencao> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Intervencao getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<Intervencao> create(@Valid @RequestBody Intervencao intervencao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(intervencao));
    }
}

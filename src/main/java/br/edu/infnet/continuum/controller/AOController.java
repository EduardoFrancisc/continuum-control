package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.model.AutorizacaoOperacao;
import br.edu.infnet.continuum.service.AOService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autorizar-operacoes")
public class AOController { //AutorizaçãoOperação

    private final AOService service;

    public AOController(AOService service){
        this.service = service;
    }

    @GetMapping
    public List<AutorizacaoOperacao> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AutorizacaoOperacao getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<AutorizacaoOperacao> create(@Valid @RequestBody AutorizacaoOperacao autorizacaoOperacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(autorizacaoOperacao));
    }

}

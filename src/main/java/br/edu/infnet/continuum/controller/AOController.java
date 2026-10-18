package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.model.AutorizacaoOperacao;
import br.edu.infnet.continuum.service.AOService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autorizar-operacoes")
public class AOController {

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

}

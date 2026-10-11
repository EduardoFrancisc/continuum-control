package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.model.EncerramentoMissoes;
import br.edu.infnet.continuum.service.EMService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/encerramento")
public class EMController {

    private EMService service;

    public EMController(EMService service){
        this.service = service;
    }

    @GetMapping
    public List<EncerramentoMissoes> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EncerramentoMissoes getById(@PathVariable Long id) {
        return service.getById(id);
    }
}

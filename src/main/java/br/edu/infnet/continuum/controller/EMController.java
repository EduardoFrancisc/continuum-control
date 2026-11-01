package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.model.EncerramentoMissoes;
import br.edu.infnet.continuum.service.EMService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/encerramento")
public class EMController {//EncerramentoMissão

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

    @PostMapping
    public ResponseEntity<EncerramentoMissoes> create(@Valid @RequestBody EncerramentoMissoes encerramentoMissoes) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(encerramentoMissoes));
    }


}

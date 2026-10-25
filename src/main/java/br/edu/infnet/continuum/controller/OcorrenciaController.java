package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.model.Ocorrencia;
import br.edu.infnet.continuum.dtos.ocorrencias.OcorrenciaCreateDTO;
import br.edu.infnet.continuum.service.OcorrenciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    public final OcorrenciaService service;

    public OcorrenciaController(OcorrenciaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Ocorrencia> create(@Valid @RequestBody OcorrenciaCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping
    public List<Ocorrencia> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Ocorrencia getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("missao/{id}")
    public List<Ocorrencia> getByMissao(@PathVariable Long id) {
        return service.getByMissao(id);
    }

    @GetMapping("autor/{id}")
    public List<Ocorrencia> getByAutor(@PathVariable Long id) {
        return service.getByAutor(id);
    }
}

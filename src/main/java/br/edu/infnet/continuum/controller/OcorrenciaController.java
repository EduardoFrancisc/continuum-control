package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.model.Ocorrencia;
import br.edu.infnet.continuum.dtos.OcorrenciaCreateDTO;
import br.edu.infnet.continuum.service.OcorrenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    public final OcorrenciaService service;

    public OcorrenciaController(OcorrenciaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Ocorrencia> create(@RequestBody OcorrenciaCreateDTO dto) {
        Ocorrencia criada = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }



}

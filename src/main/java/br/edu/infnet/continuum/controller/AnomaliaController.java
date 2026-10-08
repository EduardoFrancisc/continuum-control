package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.service.AnomaliaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anomalia")
public class AnomaliaController {
    private final AnomaliaService service;

    public AnomaliaController(AnomaliaService service){
        this.service = service;
    }



}

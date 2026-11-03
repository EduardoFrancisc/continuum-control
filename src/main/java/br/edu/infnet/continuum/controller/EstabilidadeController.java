package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.dtos.EstadoOperacionalDTO;
import br.edu.infnet.continuum.service.EstabilidadeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/estabilidade")
public class EstabilidadeController {
    public final EstabilidadeService estabilidadeService;

    public EstabilidadeController(EstabilidadeService estabilidadeService) {
        this.estabilidadeService = estabilidadeService;
    }

    @GetMapping
    public Map<Float, String>  getEstabilidadeTemporal(){
        return estabilidadeService.getEstabilidadeTemporal();
    }

    @GetMapping("/estado")
    public EstadoOperacionalDTO getEstadoOperacional(){
        return estabilidadeService.getEstadoOperacional();
    }

}

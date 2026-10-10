package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.enums.EstadoMissao;
import br.edu.infnet.continuum.domain.enums.RiscoAnomalia;
import br.edu.infnet.continuum.domain.model.Missao;
import br.edu.infnet.continuum.service.MissaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissaoController {
    private final MissaoService service;

    public MissaoController(MissaoService service){
        this.service = service;
    }

    @GetMapping
    public List<Missao> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Missao getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/acontecendo")
    public List<Missao> getByInProgress(){
        return service.getByInProgress();
    }

    @GetMapping("/estado/{estado}")
    public List<Missao> getByState(@PathVariable EstadoMissao estado){
        return service.getByState(estado);
    }

    @GetMapping("/anomalia/{id}")
    public List<Missao> getByAnomaly(@PathVariable Long id){
        return service.getByAnomaly(id);
    }

    @GetMapping("/agente/{id}")
    public List<Missao> getByAgent(@PathVariable Long id){
        return service.getByAgent(id);
    }

}

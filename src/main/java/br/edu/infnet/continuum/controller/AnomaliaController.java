package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.enums.EstadoAnomalia;
import br.edu.infnet.continuum.domain.enums.RiscoAnomalia;
import br.edu.infnet.continuum.domain.model.Anomalia;
import br.edu.infnet.continuum.service.AnomaliaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/anomalia")
public class AnomaliaController {
    private final AnomaliaService service;

    public AnomaliaController(AnomaliaService service){
        this.service = service;
    }

    @GetMapping
    public List<Anomalia> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Anomalia getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/ativas")
    public List<Anomalia> getByActive(){
        return service.getByActive();
    }

    @GetMapping("/criticas")
    public List<Anomalia> getByCritical(){
        return service.getByCritical();
    }

    @GetMapping("/estado/{estado}")
    public List<Anomalia> getByState(@PathVariable EstadoAnomalia estado){
        return service.getByState(estado);
    }

    @GetMapping("/risco/{risco}")
    public List<Anomalia> getByLevelRisc(@PathVariable RiscoAnomalia risco){
        return service.getByLevelRisc(risco);
    }






}

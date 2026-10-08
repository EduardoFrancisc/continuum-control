package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.enums.ImportanciaEH;
import br.edu.infnet.continuum.domain.model.EventoHistorico;
import br.edu.infnet.continuum.service.EHService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/evento")
public class EHController {
    private final EHService service;

    public EHController(EHService service) {
        this.service = service;
    }

    @GetMapping
    public List<EventoHistorico> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EventoHistorico getById(@PathVariable Long id) {
        return service.getById(id);
    }

    //BAIXA, MODERADA, ALTA, CRÍTICA
    @GetMapping("/importancia/{importancia}")
    public List<EventoHistorico> getByImportance(@PathVariable ImportanciaEH importancia){
        return service.getByImportance(importancia);
    }

    @GetMapping("/periodo")
    public List<EventoHistorico> getByPeriod(
            @RequestParam("inicio") LocalDate inicio,
            @RequestParam("fim") LocalDate fim) {
        return service.getByPeriod(inicio, fim);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventoHistorico> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    //Falta criar o create e o put, mas faz sentido? avaliar depois
}

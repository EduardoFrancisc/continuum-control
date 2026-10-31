package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.enums.EstadoMissao;
import br.edu.infnet.continuum.domain.enums.RiscoAnomalia;
import br.edu.infnet.continuum.domain.model.Anomalia;
import br.edu.infnet.continuum.domain.model.EventoHistorico;
import br.edu.infnet.continuum.domain.model.Missao;
import br.edu.infnet.continuum.dtos.AnomaliaMudancaRiscoDTO;
import br.edu.infnet.continuum.dtos.AtribuirMissaoDTO;
import br.edu.infnet.continuum.dtos.MudarEstadoMissaoDTO;
import br.edu.infnet.continuum.service.MissaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Missao> create(@Valid @RequestBody Missao missao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(missao));
    }

    @PutMapping("/atribuir")
    public ResponseEntity<Missao> assignMission(@Valid @RequestBody AtribuirMissaoDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.assignMission(dto));
    }

    @PutMapping("/estado/alterar")
    public ResponseEntity<Missao> alterState(@Valid @RequestBody MudarEstadoMissaoDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.alterState(dto));
    }



}

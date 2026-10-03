package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.enums.EspecialidadeAgente;
import br.edu.infnet.continuum.domain.enums.SituacaoAgente;
import br.edu.infnet.continuum.domain.model.Agente;
import br.edu.infnet.continuum.service.AgenteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agente")
public class AgenteController {

    private final AgenteService service;

    public AgenteController(AgenteService AventureiroService) {
        this.service = AventureiroService;
    }

    @GetMapping
    public List<Agente> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Agente getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/disponiveis")
    public List<Agente> getByDisponibility(){
        return service.getByDisponibility();
    }

    //DISPONÍVEL, EM_MISSÃO, SUSPENSO, INATIVO
    @GetMapping("/situacao/{situacao}")
    public List<Agente> getBySituacao(@PathVariable SituacaoAgente situacao){
        return service.getBySituacao(situacao);
    }

    //INVESTIGACAO, CONTENCAO_FISICA, ANALISE_HISTORICA, ENGENHARIA_TEMPORAL
    @GetMapping("/especialidade/{especialidade}")
    public List<Agente> getByEspecialidade(@PathVariable EspecialidadeAgente especialidade){
        return service.getByEspecialidade(especialidade);
    }

    @PostMapping
    public ResponseEntity<Agente> create(@Valid @RequestBody Agente agente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(agente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Agente> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }







}

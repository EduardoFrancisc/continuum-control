package br.edu.infnet.continuum.domain.model;

import br.edu.infnet.continuum.domain.enums.EstadoMissao;
import br.edu.infnet.continuum.domain.enums.PrioridadeMissao;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "missoes")
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "anomalia_id", nullable = false)
    private Anomalia anomalia;

    @Column(nullable = false)
    private String objetivo;

    @Column(nullable = false)
    private String destino_temporal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PrioridadeMissao prioridade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoMissao estado = EstadoMissao.PLANEJADA;

    @ManyToMany()
    private Set<Agente> agentes;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = true)
    private LocalDate dataFim;

    @Column(nullable = false)
    private Boolean isDeleted = false;
}

package br.edu.infnet.continuum.domain.model;

import br.edu.infnet.continuum.domain.enums.EstadoAnomalia;
import br.edu.infnet.continuum.domain.enums.RiscoAnomalia;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "anomalias")
public class Anomalia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "evento_id")
    private EventoHistorico evento;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String divergencia;

    @Column(nullable = false)
    private LocalDate dataDeteccao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RiscoAnomalia risco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoAnomalia estado;

    @Column(nullable = true)
    private String origem;

    @Column(nullable = false)
    private String observacoes;

    @Column(nullable = false)
    private Boolean isActive = true;

    @Column(nullable = false)
    private Boolean isDeleted = false;
}

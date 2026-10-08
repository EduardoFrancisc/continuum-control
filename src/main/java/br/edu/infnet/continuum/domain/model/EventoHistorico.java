package br.edu.infnet.continuum.domain.model;

import br.edu.infnet.continuum.domain.enums.ImportanciaEH;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "eventos_historicos")
public class EventoHistorico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImportanciaEH importancia;

    @Column(nullable = false)
    private Boolean isDeleted = false;

}

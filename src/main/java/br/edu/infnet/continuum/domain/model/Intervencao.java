package br.edu.infnet.continuum.domain.model;

import br.edu.infnet.continuum.domain.enums.ImpactoObservado;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "intervencoes")
public class Intervencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "missao_id", nullable = false)
    private Missao missao;

    @ManyToOne()
    @JoinColumn(name = "agente_id", nullable = false)
    private Agente agente;

    @Column(nullable = false)
    private LocalDateTime data = LocalDateTime.now();

    @Column(nullable = false)
    private String acaoExecutada;

    @Column(nullable = false)
    private String justificativa;

    @Column(nullable = false)
    private String resultadoObservado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImpactoObservado impactoEstimado;
}

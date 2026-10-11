package br.edu.infnet.continuum.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "autorizacoes_operacao")
public class AutorizacaoOperacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "missao_id", nullable = false)
    private Missao missao;

    @Column(nullable = false)
    private String responsavel;

    @Column(nullable = false)
    private LocalDateTime instante;

    @Column(nullable = false)
    private String observacao;
}

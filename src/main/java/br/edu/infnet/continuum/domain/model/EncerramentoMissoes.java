package br.edu.infnet.continuum.domain.model;

import br.edu.infnet.continuum.domain.enums.EstadoAnomalia;
import br.edu.infnet.continuum.domain.enums.ImpactoObservado;
import br.edu.infnet.continuum.domain.enums.ResultadoMissao;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "encerramento_missoes")
public class EncerramentoMissoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "missao_id", nullable = false)
    private Missao missao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResultadoMissao resultado;

    @Column(nullable = false)
    private String resumo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImpactoObservado impacto;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoAnomalia situacaoAnomalia;

    @Column(nullable = false)
    private String observacoesRelevantes;
}

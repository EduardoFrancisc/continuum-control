package br.edu.infnet.continuum.domain.model;

import br.edu.infnet.continuum.domain.enums.EspecialidadeAgente;
import br.edu.infnet.continuum.domain.enums.SituacaoAgente;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "agentes")
public class Agente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING) //Para salvar o nome e não o num da posição do enum
    @Column(nullable = false)
    private EspecialidadeAgente especialidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SituacaoAgente situacao = SituacaoAgente.DISPONÍVEL;

    @Column(nullable = false)
    private Boolean IsDeleted = false;
}

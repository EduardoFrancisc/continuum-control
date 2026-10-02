package br.edu.infnet.continuum.domain.model;

import br.edu.infnet.continuum.domain.enums.EspecialidadeAgente;
import br.edu.infnet.continuum.domain.enums.SituacaoAgente;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Agentes")
public class Agente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated //Para salvar o nome e não o num da posição do enum
    @Column(nullable = false)
    private EspecialidadeAgente especialidade;

    @Enumerated
    @Column(nullable = false)
    private SituacaoAgente situacao;

    @Column(nullable = false)
    private Boolean isDeleted = false;
}

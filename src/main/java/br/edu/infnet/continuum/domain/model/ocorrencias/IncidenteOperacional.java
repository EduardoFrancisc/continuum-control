package br.edu.infnet.continuum.domain.model.ocorrencias;

import br.edu.infnet.continuum.domain.enums.ImpactoMissao;
import br.edu.infnet.continuum.domain.enums.StatusResolucao;
import br.edu.infnet.continuum.domain.enums.TipoIncidente;
import br.edu.infnet.continuum.domain.model.Ocorrencia;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class IncidenteOperacional extends Ocorrencia {
    private String titulo;
    private Integer numeroFatalidades;
    private Integer numeroFeridos;
    private Float intensidade;
    private TipoIncidente tipoIncidente;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String danosMateriais;
    private ImpactoMissao impactoMissao;
    private StatusResolucao statusResolucao;
    private String medidasAdotadas;
}


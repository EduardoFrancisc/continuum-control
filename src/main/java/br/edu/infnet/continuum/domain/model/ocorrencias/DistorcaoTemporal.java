package br.edu.infnet.continuum.domain.model.ocorrencias;

import br.edu.infnet.continuum.domain.model.Ocorrencia;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DistorcaoTemporal extends Ocorrencia{
    private Integer intensidade;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String localOcorrencia;
    private Integer raioImpacto;
    private String estabilidade;
    private String efeitosObservados;
    private Integer riscoEstimado;
}

package br.edu.infnet.continuum.dtos.ocorrencias;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DistorcaoTemporalDTO extends OcorrenciaCreateDTO {

    @NotNull
    private Integer intensidade;

    @NotNull
    @JsonProperty("data_inicio") //mapeamento do json
    private LocalDateTime dataInicio;

    @NotNull
    @JsonProperty("data_fim")
    private LocalDateTime dataFim;

    @NotNull
    @JsonProperty("local_ocorrencia")
    private String localOcorrencia;

    @NotNull
    @JsonProperty("raio_impacto")
    private Integer raioImpacto;

    @NotNull
    private String estabilidade;

    @NotNull
    @JsonProperty("efeitos_observados")
    private String efeitosObservados;

    @NotNull
    @JsonProperty("risco_estimado")
    private Integer riscoEstimado;
}


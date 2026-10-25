package br.edu.infnet.continuum.dtos.ocorrencias;

import br.edu.infnet.continuum.domain.enums.RelevanciaHistorica;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ObservacaoHistoricaDTO extends OcorrenciaCreateDTO {

    @NotNull
    @JsonProperty("periodo_historico")
    private String periodoHistorico;

    @NotNull
    @JsonProperty("fonte_historica")
    private String fonteHistorica;

    @NotNull
    @JsonProperty("data_observacao")
    private LocalDateTime dataObservacao;

    @NotNull
    @JsonProperty("local_historico")
    private String localHistorico;

    @NotNull
    @JsonProperty("grau_confiabilidade")
    private Float grauConfiabilidade;

    @NotNull
    @JsonProperty("relevancia_historica")
    private RelevanciaHistorica relevanciaHistorica;
}


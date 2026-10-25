package br.edu.infnet.continuum.dtos.ocorrencias;

import br.edu.infnet.continuum.domain.enums.TipoAlteracao;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AlteracaoDetectadaDTO extends OcorrenciaCreateDTO {
    @NotNull(message = "O elemento afetado é obrigatório.")
    @JsonProperty("elemento_afetado")
    private String elementoAfetado;

    @NotNull(message = "O tipo de alteração é obrigatório.")
    @JsonProperty("tipo_alteracao")
    private TipoAlteracao tipoAlteracao;

    @NotNull(message = "O estado anterior é obrigatório.")
    @JsonProperty("estado_anterior")
    private String estadoAnterior;

    @NotNull(message = "O estado atual é obrigatório.")
    @JsonProperty("estado_atual")
    private String estadoAtual;

    @NotNull(message = "A data de detecção é obrigatória.")
    @JsonProperty("data_deteccao")
    private LocalDateTime dataDeteccao;

    @NotNull(message = "A origem detectada é obrigatória.")
    @JsonProperty("origem_detectada")
    private String origemDetectada;

    @NotNull(message = "O grau de anomalia é obrigatório.")
    @DecimalMin(value = "0.0", message = "O grau de anomalia não pode ser negativo.")
    @JsonProperty("grau_anomalia")
    private Float grauAnomalia;
}

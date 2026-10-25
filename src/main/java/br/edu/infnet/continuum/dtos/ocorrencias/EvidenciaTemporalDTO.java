package br.edu.infnet.continuum.dtos.ocorrencias;

import br.edu.infnet.continuum.domain.enums.EstadoIntegridade;
import br.edu.infnet.continuum.domain.enums.TipoEvidencia;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EvidenciaTemporalDTO extends OcorrenciaCreateDTO {
    @NotNull(message = "O objeto é obrigatório.")
    private String objeto;
    @NotNull(message = "O período estimado é obrigatório.")
    @JsonProperty("periodo_estimado")
    private String periodoEstimado;
    @NotNull(message = "O grau de confiabilidade é obrigatório.")
    @DecimalMin(value = "0.0", message = "O grau de confiabilidade deve ser no mínimo 0.0")
    @DecimalMax(value = "1.0", message = "O grau de confiabilidade deve ser no máximo 1.0")
    @JsonProperty("grau_confiabilidade")
    private Float grauConfiabilidade;
    @NotNull(message = "O tipo de evidência é obrigatório.")
    @JsonProperty("tipo_evidencia")
    private TipoEvidencia tipoEvidencia;
    @NotNull(message = "O local encontrado é obrigatório.")
    @JsonProperty("local_encontrado")
    private String localEncontrado;
    @NotNull(message = "A data de coleta é obrigatória.")
    @JsonProperty("data_coleta")
    private LocalDateTime dataColeta;
    @NotNull(message = "O responsável pela coleta é obrigatório.")
    @JsonProperty("responsavel_coleta")
    private Long responsavelColeta;
    @NotNull(message = "O estado de integridade é obrigatório.")
    private EstadoIntegridade integridade;
    @NotNull(message = "A origem estimada é obrigatória.")
    @JsonProperty("origem_estimada")
    private String origemEstimada;
}

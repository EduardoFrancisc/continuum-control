package br.edu.infnet.continuum.dtos.ocorrencias;


import br.edu.infnet.continuum.domain.enums.ImpactoMissao;
import br.edu.infnet.continuum.domain.enums.StatusResolucao;
import br.edu.infnet.continuum.domain.enums.TipoIncidente;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class IncidenteOperacionalDTO extends OcorrenciaCreateDTO {
    @NotNull(message = "O título é obrigatório.")
    private String titulo;

    @NotNull(message = "O número de fatalidades é obrigatório.")
    @Min(value = 0, message = "O número de fatalidades não pode ser negativo.")
    @JsonProperty("numero_fatalidades")
    private Integer numeroFatalidades;

    @NotNull(message = "O número de feridos é obrigatório.")
    @Min(value = 0, message = "O número de feridos não pode ser negativo.")
    @JsonProperty("numero_feridos")
    private Integer numeroFeridos;

    @NotNull(message = "A intensidade é obrigatória.")
    private Float intensidade;

    @NotNull(message = "O tipo de incidente é obrigatório.")
    @JsonProperty("tipo_incidente")
    private TipoIncidente tipoIncidente;

    @NotNull(message = "A data de início é obrigatória.")
    @JsonProperty("data_inicio")
    private LocalDateTime dataInicio;

    @NotNull(message = "A data de fim é obrigatória.")
    @JsonProperty("data_fim")
    private LocalDateTime dataFim;

    @NotNull(message = "A descrição dos danos materiais é obrigatória.")
    @JsonProperty("danos_materiais")
    private String danosMateriais;

    @NotNull(message = "O impacto na missão é obrigatório.")
    @JsonProperty("impacto_missao")
    private ImpactoMissao impactoMissao;

    @NotNull(message = "O status de resolução é obrigatório.")
    @JsonProperty("status_resolucao")
    private StatusResolucao statusResolucao;

    @NotNull(message = "As medidas adotadas são obrigatórias.")
    @JsonProperty("medidas_adotadas")
    private String medidasAdotadas;
}


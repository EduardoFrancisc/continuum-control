package br.edu.infnet.continuum.dtos.ocorrencias;

import br.edu.infnet.continuum.domain.enums.NivelHostilidade;
import br.edu.infnet.continuum.domain.enums.NivelRisco;
import br.edu.infnet.continuum.domain.enums.TipoEncontro;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EncontroInesperadoDTO extends OcorrenciaCreateDTO {
    @NotNull(message = "O campo 'encontrado' é obrigatório.")
    private String encontrado;

    @NotNull(message = "O campo 'onde' é obrigatório.")
    private String onde;

    @NotNull(message = "O campo 'como' é obrigatório.")
    private String como;

    @NotNull(message = "A data é obrigatória.")
    private LocalDateTime data;

    @NotNull(message = "O tipo de encontro é obrigatório.")
    @JsonProperty("tipo_encontro")
    private TipoEncontro tipoEncontro;

    @NotNull(message = "O nível de hostilidade é obrigatório.")
    private NivelHostilidade hostilidade;

    @NotNull(message = "A condição do encontrado é obrigatória.")
    @JsonProperty("condicao_encontrado")
    private String condicaoEncontrado;

    @NotNull(message = "O campo 'interacao' é obrigatório.")
    private Boolean interacao;

    @NotNull(message = "O resultado do encontro é obrigatório.")
    @JsonProperty("resultado_encontro")
    private String resultadoEncontro;

    @NotNull(message = "O nível de ameaça é obrigatório.")
    @JsonProperty("nivel_ameaca")
    private NivelRisco nivelAmeaca;
}


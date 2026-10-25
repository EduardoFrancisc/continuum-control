package br.edu.infnet.continuum.dtos.ocorrencias;

import br.edu.infnet.continuum.domain.enums.TipoOcorrencia;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

//o que faz a "mágica" de mudar o classe de dados de acordo com o campo "tipo" quem vem da req.
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, // usar valor do campo
        include = JsonTypeInfo.As.EXISTING_PROPERTY, // esta fora de dadosEspecificos
        property = "tipo", //campo
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DistorcaoTemporalDTO.class, name = "DISTORÇÃO_TEMPORAL"),
        @JsonSubTypes.Type(value = ObservacaoHistoricaDTO.class, name = "OBSERVAÇÃO_HISTÓRICA"),
        @JsonSubTypes.Type(value = EvidenciaTemporalDTO.class, name = "EVIDÊNCIA_TEMPORAL"),
        @JsonSubTypes.Type(value = AlteracaoDetectadaDTO.class, name = "ALTERAÇÃO_DETECTADA"),
        @JsonSubTypes.Type(value = EncontroInesperadoDTO.class, name = "ENCONTRO_INESPERADO"),
        @JsonSubTypes.Type(value = IncidenteOperacionalDTO.class, name = "INCIDENTE_OPERACIONAL")
})

@Data
public abstract class OcorrenciaCreateDTO {
        @NotNull(message = "O tipo é obrigatório.")
        private TipoOcorrencia tipo;

        @Min(value = 1, message = "Não existe ID negativo.")
        @NotNull(message = "O ID da missão é obrigatório.")
        private Long missaoId;

        @Min(value = 1, message = "Não existe ID negativo.")
        @NotNull(message = "O ID do autor é obrigatório.")
        private Long autorId;

        @NotNull(message = "Observações são obrigatórias.")
        private String observacoes;
}


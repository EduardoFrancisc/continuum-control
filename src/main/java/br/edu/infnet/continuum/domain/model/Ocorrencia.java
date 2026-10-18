package br.edu.infnet.continuum.domain.model;

import br.edu.infnet.continuum.domain.enums.TipoOcorrencia;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Document(collection = "ocorrencias")
public class Ocorrencia {

    @Id
    private String id;

    private TipoOcorrencia tipo;

    private LocalDateTime dataRegistro;

    private Long autorId; //id do agente?

    private Long missaoId; //id da missao onde ocorreu

    private String observacoes;

    private Map<String, Object> dadosEspecificos;
}

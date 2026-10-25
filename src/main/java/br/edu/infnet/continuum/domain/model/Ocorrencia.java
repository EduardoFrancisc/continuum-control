package br.edu.infnet.continuum.domain.model;

import br.edu.infnet.continuum.domain.enums.TipoOcorrencia;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "ocorrencias")
public abstract class Ocorrencia {
    @Id
    private String id;
    private TipoOcorrencia tipo;
    private LocalDateTime dataRegistro = LocalDateTime.now();
    private Long autorId;
    private Long missaoId;
    private String observacoes;
}


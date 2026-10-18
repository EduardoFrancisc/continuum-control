package br.edu.infnet.continuum.dtos;

import br.edu.infnet.continuum.domain.enums.TipoOcorrencia;
import lombok.Data;

import java.util.Map;

@Data
public class OcorrenciaCreateDTO {
    private TipoOcorrencia tipo;
    private Long missaoId;
    private Long autorId;
    private String observacoes;
    private Map<String, Object> dadosEspecificos;
}

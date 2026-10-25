package br.edu.infnet.continuum.domain.model.ocorrencias;

import br.edu.infnet.continuum.domain.enums.NivelHostilidade;
import br.edu.infnet.continuum.domain.enums.NivelRisco;
import br.edu.infnet.continuum.domain.enums.TipoEncontro;
import br.edu.infnet.continuum.domain.model.Ocorrencia;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class EncontroInesperado extends Ocorrencia {
    private String encontrado;
    private String onde;
    private String como;
    private LocalDateTime data;
    private TipoEncontro tipoEncontro;
    private NivelHostilidade hostilidade;
    private String condicaoEncontrado;
    private Boolean interacao;
    private String resultadoEncontro;
    private NivelRisco nivelAmeaca;
}


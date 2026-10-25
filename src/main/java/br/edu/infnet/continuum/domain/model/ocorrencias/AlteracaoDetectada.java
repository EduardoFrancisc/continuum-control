package br.edu.infnet.continuum.domain.model.ocorrencias;

import br.edu.infnet.continuum.domain.enums.TipoAlteracao;
import br.edu.infnet.continuum.domain.model.Ocorrencia;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AlteracaoDetectada extends Ocorrencia {
    private String elementoAfetado;
    private TipoAlteracao tipoAlteracao;
    private String estadoAnterior;
    private String estadoAtual;
    private LocalDateTime dataDeteccao;
    private String origemDetectada;
    private Float grauAnomalia;
}


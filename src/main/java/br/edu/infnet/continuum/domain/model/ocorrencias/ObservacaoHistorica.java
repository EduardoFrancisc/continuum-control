package br.edu.infnet.continuum.domain.model.ocorrencias;

import br.edu.infnet.continuum.domain.enums.RelevanciaHistorica;
import br.edu.infnet.continuum.domain.model.Ocorrencia;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ObservacaoHistorica extends Ocorrencia {
    private String periodoHistorico;
    private String fonteHistorica;
    private LocalDateTime dataObservacao;
    private String localHistorico;
    private Float grauConfiabilidade;
    private RelevanciaHistorica relevanciaHistorica;
}


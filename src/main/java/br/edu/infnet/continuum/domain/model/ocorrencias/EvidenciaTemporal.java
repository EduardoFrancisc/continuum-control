package br.edu.infnet.continuum.domain.model.ocorrencias;

import br.edu.infnet.continuum.domain.enums.EstadoIntegridade;
import br.edu.infnet.continuum.domain.enums.TipoEvidencia;
import br.edu.infnet.continuum.domain.model.Ocorrencia;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EvidenciaTemporal extends Ocorrencia {
    private String objeto;
    private String periodoEstimado;
    private Float grauConfiabilidade;
    private TipoEvidencia tipoEvidencia;
    private String localEncontrado;
    private LocalDateTime dataColeta;
    private Long responsavelColeta;
    private EstadoIntegridade integridade;
    private String origemEstimada;
}

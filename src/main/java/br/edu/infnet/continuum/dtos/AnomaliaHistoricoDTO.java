package br.edu.infnet.continuum.dtos;

import br.edu.infnet.continuum.domain.enums.RiscoAnomalia;

import java.time.LocalDateTime;
import java.util.List;

public record AnomaliaHistoricoDTO(
        Long id,
        String nome,
        LocalDateTime dataDeteccao,
        RiscoAnomalia risco,
        List<OcorrenciasAnomaliaHistoricoDTO> ocorrencias,
        List<MissoesAnomaliaHistorico> missoes
) {
}

package br.edu.infnet.continuum.dtos;

import br.edu.infnet.continuum.domain.enums.TipoOcorrencia;

import java.time.LocalDateTime;

public record OcorrenciasAnomaliaHistoricoDTO(
        String id,
        TipoOcorrencia tipo,
        LocalDateTime dataRegistro
) {
}

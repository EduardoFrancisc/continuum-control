package br.edu.infnet.continuum.dtos;

import br.edu.infnet.continuum.domain.enums.EstadoAnomalia;

public record AnomaliaMudancaEstadoDTO(
        Long id,
        EstadoAnomalia estadoAnomalia
) {
}

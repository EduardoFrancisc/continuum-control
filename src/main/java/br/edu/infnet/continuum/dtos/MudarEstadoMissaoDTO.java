package br.edu.infnet.continuum.dtos;

import br.edu.infnet.continuum.domain.enums.EstadoMissao;

public record MudarEstadoMissaoDTO(
        Long id,
        EstadoMissao estado
) {
}

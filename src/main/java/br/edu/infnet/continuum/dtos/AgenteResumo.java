package br.edu.infnet.continuum.dtos;

import br.edu.infnet.continuum.domain.enums.EspecialidadeAgente;

public record AgenteResumo(
        Long id,
        String nome,
        EspecialidadeAgente especialidade
) {
}

package br.edu.infnet.continuum.dtos;

import java.util.List;

public record AtribuirMissaoDTO(
        Long id,
        List<Long> idsAgentes
) {
}

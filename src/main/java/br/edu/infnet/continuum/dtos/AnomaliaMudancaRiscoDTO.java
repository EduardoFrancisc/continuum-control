package br.edu.infnet.continuum.dtos;

import br.edu.infnet.continuum.domain.enums.RiscoAnomalia;

public record AnomaliaMudancaRiscoDTO(
        Long id,
        RiscoAnomalia riscoAnomalia
) {
}

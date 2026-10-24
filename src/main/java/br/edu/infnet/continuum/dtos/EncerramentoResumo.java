package br.edu.infnet.continuum.dtos;

import br.edu.infnet.continuum.domain.enums.EstadoAnomalia;
import br.edu.infnet.continuum.domain.enums.ImpactoObservado;
import br.edu.infnet.continuum.domain.enums.ResultadoMissao;

public record EncerramentoResumo(
        Long id,
        ResultadoMissao resultado,
        ImpactoObservado impacto,
        EstadoAnomalia estado,
        String resumo
) {
}

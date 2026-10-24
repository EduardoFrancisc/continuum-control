package br.edu.infnet.continuum.dtos;

import br.edu.infnet.continuum.domain.enums.EstadoMissao;

import java.time.LocalDate;
import java.util.Set;

public record MissoesAnomaliaHistorico(
        Long id,
        EstadoMissao estado,
        LocalDate dataInicio,
        LocalDate dataFim,
        Set<AgenteResumo> agentes,
        EncerramentoResumo encerramento
) {
}

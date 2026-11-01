package br.edu.infnet.continuum.dtos;

public record EstadoOperacionalDTO(
        Integer agentesDisponiveis,
        Integer agentesEmMissao,
        Integer missoesEmExecucao,
        Integer anomaliasAtivas,
        Integer anomaliasCriticas,
        String estadoLinhaTemporal
) {
}

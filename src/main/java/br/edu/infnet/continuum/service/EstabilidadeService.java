package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.EstadoAnomalia;
import br.edu.infnet.continuum.domain.enums.EstadoMissao;
import br.edu.infnet.continuum.domain.enums.ImpactoObservado;
import br.edu.infnet.continuum.domain.enums.RiscoAnomalia;
import br.edu.infnet.continuum.domain.enums.SituacaoAgente;
import br.edu.infnet.continuum.dtos.EstadoOperacionalDTO;
import br.edu.infnet.continuum.repository.AgenteRepository;
import br.edu.infnet.continuum.repository.AnomaliaRepository;
import br.edu.infnet.continuum.repository.IntervencaoRepository;
import br.edu.infnet.continuum.repository.MissaoRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EstabilidadeService {
    private final IntervencaoRepository intervencaoRepository;
    private final AnomaliaRepository anomaliaRepository;
    private final MissaoRepository missaoRepository;
    private final AgenteRepository agenteRepository;


    public EstabilidadeService(IntervencaoRepository intervencaoRepository,
                               AnomaliaRepository anomaliaRepository,
                               MissaoRepository missaoRepository,
                               AgenteRepository agenteRepository) {
        this.intervencaoRepository = intervencaoRepository;
        this.anomaliaRepository = anomaliaRepository;
        this.missaoRepository = missaoRepository;
        this.agenteRepository = agenteRepository;
    }

    @Cacheable(value = "estabilidadeTemporal")
    public Map<Float, String> getEstabilidadeTemporal() {
        float indice = 100f;

        Integer intervencoesSeveras = intervencaoRepository.countAllByImpactoEstimado(ImpactoObservado.SEVERO);
        Integer anomaliasCriticas = anomaliaRepository.countAnomaliaByRiscoAndIsActiveTrueAndIsDeletedFalse(RiscoAnomalia.CRÍTICO);
        Integer missoesFalhas = missaoRepository.countMissaoByEstado(EstadoMissao.FALHOU);
        Integer anomaliasAtivas = anomaliaRepository.countAnomaliaByIsActiveTrueAndIsDeletedFalse();
        Integer missoesEmExecucao = missaoRepository.countMissaoByEstado(EstadoMissao.EM_EXECUÇÃO);

        // Coisas boas
        Integer intervencoesControladas = intervencaoRepository.countAllByImpactoEstimado(ImpactoObservado.CONTROLADO);
        Integer intervencoesMinimas = intervencaoRepository.countAllByImpactoEstimado(ImpactoObservado.MÍNIMO);
        Integer anomaliasEstabilizadas = anomaliaRepository
                .getAnomaliaByEstadoAndIsActiveTrueAndIsDeletedFalse(EstadoAnomalia.ESTABILIZADA)
                .size();
        Integer missoesConcluidas = missaoRepository.countMissaoByEstado(EstadoMissao.CONCLUÍDA);

        float negativos = (intervencoesSeveras * 3.0f)
                + (anomaliasCriticas * 2.0f)
                + (missoesFalhas * 1.5f)
                + (anomaliasAtivas * 0.6f)
                + (missoesEmExecucao * 0.1f);

        float positivos = (intervencoesControladas * 0.9f)
                + (intervencoesMinimas * 0.5f)
                + (anomaliasEstabilizadas * 2.0f)
                + (missoesConcluidas * 1.6f);

        // Clamp - nunca maior que 100 ou menor que 0
        float resultado = indice + positivos - negativos;
        resultado = Math.max(0f, Math.min(100f, resultado));
        resultado = Math.round(resultado * 10f) / 10f;

        String estabilidade_qualitativa;

        if (resultado >= 80) {
            estabilidade_qualitativa = "PLENO";
        } else if (resultado >= 60) {
            estabilidade_qualitativa = "ESTÁVEL";
        } else if (resultado >= 40) {
            estabilidade_qualitativa = "INSTÁVEL";
        } else if (resultado >= 30) {
            estabilidade_qualitativa = "ATENÇÃO";
        } else if (resultado >= 10) {
            estabilidade_qualitativa = "CRÍTICO";
        } else {
            estabilidade_qualitativa = "COLAPSO TEMPORAL";
        }

        return Map.of(resultado, estabilidade_qualitativa);
    }

    @Cacheable(value = "estadoOperacional")
    public EstadoOperacionalDTO getEstadoOperacional() {
        Integer agentesDisponiveis = agenteRepository.getAgentesBySituacaoAndIsDeletedFalse(SituacaoAgente.DISPONÍVEL).size();
        Integer agentesEmMissao = agenteRepository.getAgentesBySituacaoAndIsDeletedFalse(SituacaoAgente.EM_MISSÃO).size();
        Integer missaoEmExecucao = missaoRepository.getMissaoByEstadoAndIsDeletedFalse(EstadoMissao.EM_EXECUÇÃO).size();
        Integer anomaliasAtivas = anomaliaRepository.countAnomaliaByIsActiveTrueAndIsDeletedFalse();
        Integer anomaliasCriticas = anomaliaRepository.countAnomaliaByRiscoAndIsActiveTrueAndIsDeletedFalse(RiscoAnomalia.CRÍTICO);
        String estadoLinhaTemporal = getEstabilidadeTemporal().values().iterator().next();

        return new EstadoOperacionalDTO(
                agentesDisponiveis,
                agentesEmMissao,
                missaoEmExecucao,
                anomaliasAtivas,
                anomaliasCriticas,
                estadoLinhaTemporal
        );
    }

}

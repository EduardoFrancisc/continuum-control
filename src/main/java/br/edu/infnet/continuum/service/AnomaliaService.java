package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.EstadoAnomalia;
import br.edu.infnet.continuum.domain.enums.RiscoAnomalia;
import br.edu.infnet.continuum.domain.model.Anomalia;
import br.edu.infnet.continuum.domain.model.EncerramentoMissoes;
import br.edu.infnet.continuum.domain.model.Ocorrencia;
import br.edu.infnet.continuum.dtos.*;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.AnomaliaRepository;
import br.edu.infnet.continuum.repository.EMRepository;
import br.edu.infnet.continuum.repository.MissaoRepository;
import br.edu.infnet.continuum.repository.OcorrenciaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnomaliaService {

    private final AnomaliaRepository anomaliaRepository;
    private final OcorrenciaRepository ocorrenciaRepository;
    private final MissaoRepository missaoRepository;
    private final EMRepository eMRepository;

    public AnomaliaService(AnomaliaRepository repository,
                           OcorrenciaRepository ocorrenciaRepository,
                           MissaoRepository missaoRepository, EMService emService, EMRepository eMRepository){
        this.anomaliaRepository = repository;
        this.ocorrenciaRepository = ocorrenciaRepository;
        this.missaoRepository = missaoRepository;
        this.eMRepository = eMRepository;
    }

    public List<Anomalia> getAll() {
        return anomaliaRepository.findAll();
    }

    public Anomalia getById(Long id) {
        return anomaliaRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Anomalia "+id+" não encontrado(a).")
        );
    }

    public List<Anomalia> getByActive(){
        return anomaliaRepository.getAnomaliaByIsActiveTrueAndIsDeletedFalse();
    }

    public List<Anomalia> getByCritical() {
        return anomaliaRepository.getAnomaliaByRiscoAndIsActiveTrueAndIsDeletedFalse(RiscoAnomalia.CRÍTICO);
    }

    public List<Anomalia> getByLevelRisc(RiscoAnomalia risco) {
        return anomaliaRepository.getAnomaliaByRiscoAndIsActiveTrueAndIsDeletedFalse(risco);
    }

    public List<Anomalia> getByState(EstadoAnomalia estado) {
        return anomaliaRepository.getAnomaliaByEstadoAndIsActiveTrueAndIsDeletedFalse(estado);
    }

    public AnomaliaHistoricoDTO getAnomalyByHistory(Long id) {
        Anomalia anomalia = getById(id);

        Optional<EncerramentoMissoes> em = eMRepository.findById(id);

        EncerramentoResumo encerramentoResumo = em
                .map(e -> new EncerramentoResumo(
                        e.getId(),
                        e.getResultado(),
                        e.getImpacto(),
                        e.getSituacaoAnomalia(),
                        e.getResumo()
                )).orElse(null);

        List<Long> ids_missoes = new ArrayList<>();

        List<MissoesAnomaliaHistorico> missoes = missaoRepository.getByAnomalia_Id(id).stream().map(
                m -> {
                    ids_missoes.add(m.getId());
                    return new MissoesAnomaliaHistorico(
                        m.getId(),
                        m.getEstado(),
                        m.getDataInicio(),
                        m.getDataFim(),
                        m.getAgentes().stream()
                                .map(a -> new AgenteResumo(
                                        a.getId(),
                                        a.getNome(),
                                        a.getEspecialidade()
                                )).collect(Collectors.toSet()),
                            encerramentoResumo
                    );
                }
        ).toList();

        List<Ocorrencia> ocorrencias = new ArrayList<>();

        if (!ids_missoes.isEmpty()){
            ids_missoes.forEach(i -> ocorrencias.addAll(ocorrenciaRepository.getOcorrenciaByMissaoId(i)));
        }

        List<OcorrenciasAnomaliaHistoricoDTO> ocorrenciasDto = ocorrencias
                .stream()
                .map(oc -> new OcorrenciasAnomaliaHistoricoDTO(
                oc.getId(),
                oc.getTipo(),
                oc.getDataRegistro())
        ).toList();

        AnomaliaHistoricoDTO dto = new AnomaliaHistoricoDTO(
                anomalia.getId(),
                anomalia.getNome(),
                anomalia.getDataDeteccao(),
                anomalia.getRisco(),
                ocorrenciasDto,
                missoes
        );
        return dto;
    }
}

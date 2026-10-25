
package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.model.Ocorrencia;
import br.edu.infnet.continuum.domain.model.ocorrencias.*;
import br.edu.infnet.continuum.dtos.ocorrencias.*;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.OcorrenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository repository;
    private final MissaoService missaoService;
    private final AgenteService agenteService;

    public OcorrenciaService(
            OcorrenciaRepository repository,
            MissaoService missaoService,
            AgenteService agenteService) {
        this.repository = repository;
        this.missaoService = missaoService;
        this.agenteService = agenteService;
    }

    public List<Ocorrencia> getAll() {return repository.findAll();}

    public Ocorrencia getById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Ocorrência " + id + " não encontrada."));
    }

    public List<Ocorrencia> getByMissao(Long missaoId) {
        missaoService.getById(missaoId);

        List<Ocorrencia> ocorrencias = repository.getOcorrenciaByMissaoId(missaoId);

        if (ocorrencias.isEmpty()) {
            throw new EntidadeNaoLocalizada("Nenhuma ocorrência encontrada para a missão "+ missaoId + ".");
        }

        return ocorrencias;
    }

    public List<Ocorrencia> getByAutor(Long autorId) {
        agenteService.getById(autorId);

        List<Ocorrencia> ocorrencias = repository.getOcorrenciaByAutorId(autorId);

        if (ocorrencias.isEmpty()) {
            throw new EntidadeNaoLocalizada(
                    "Nenhuma ocorrência encontrada para o agente " + autorId + ".");
        }

        return ocorrencias;
    }

    public Ocorrencia create(OcorrenciaCreateDTO dto) {

        missaoService.getById(dto.getMissaoId());
        agenteService.getById(dto.getAutorId());

        Ocorrencia ocorrencia;

        switch (dto.getTipo()) {
            case DISTORÇÃO_TEMPORAL -> {
                DistorcaoTemporalDTO d = (DistorcaoTemporalDTO) dto;// nem todo tipo de ocorrenciadto é uma dist, etc.

                if (d.getDataFim().isBefore(d.getDataInicio())) {
                    throw new IllegalArgumentException("A data final não pode ser anterior a data inicial.");
                }

                DistorcaoTemporal distorcao = new DistorcaoTemporal();
                distorcao.setIntensidade(d.getIntensidade());
                distorcao.setDataInicio(d.getDataInicio());
                distorcao.setDataFim(d.getDataFim());
                distorcao.setLocalOcorrencia(d.getLocalOcorrencia());
                distorcao.setRaioImpacto(d.getRaioImpacto());
                distorcao.setEstabilidade(d.getEstabilidade());
                distorcao.setEfeitosObservados(d.getEfeitosObservados());
                distorcao.setRiscoEstimado(d.getRiscoEstimado());

                ocorrencia = distorcao; //todo tipo é uma ocorrencia

            }

            case OBSERVAÇÃO_HISTÓRICA -> {
                ObservacaoHistoricaDTO o = (ObservacaoHistoricaDTO) dto;

                if (o.getGrauConfiabilidade() < 0 || o.getGrauConfiabilidade() > 1) {
                    throw new IllegalArgumentException("O grau de confiabilidade deve estar entre 0 e 1.");
                }

                ObservacaoHistorica obs = new ObservacaoHistorica();
                obs.setPeriodoHistorico(o.getPeriodoHistorico());
                obs.setFonteHistorica(o.getFonteHistorica());
                obs.setDataObservacao(o.getDataObservacao());
                obs.setLocalHistorico(o.getLocalHistorico());
                obs.setGrauConfiabilidade(o.getGrauConfiabilidade());
                obs.setRelevanciaHistorica(o.getRelevanciaHistorica());

                ocorrencia = obs;
            }

            case EVIDÊNCIA_TEMPORAL -> {
                EvidenciaTemporalDTO e = (EvidenciaTemporalDTO) dto;

                agenteService.getById(e.getResponsavelColeta()); //verificar se o responsavel existe

                EvidenciaTemporal evidencia = new EvidenciaTemporal();
                evidencia.setObjeto(e.getObjeto());
                evidencia.setPeriodoEstimado(e.getPeriodoEstimado());
                evidencia.setGrauConfiabilidade(e.getGrauConfiabilidade());
                evidencia.setTipoEvidencia(e.getTipoEvidencia());
                evidencia.setLocalEncontrado(e.getLocalEncontrado());
                evidencia.setDataColeta(e.getDataColeta());
                evidencia.setResponsavelColeta(e.getResponsavelColeta());
                evidencia.setIntegridade(e.getIntegridade());
                evidencia.setOrigemEstimada(e.getOrigemEstimada());

                ocorrencia = evidencia;
            }

            case ALTERAÇÃO_DETECTADA -> {
                AlteracaoDetectadaDTO a = (AlteracaoDetectadaDTO) dto;
                if (a.getGrauAnomalia() < 0) {
                    throw new IllegalArgumentException("O grau de anomalia não pode ser negativo.");
                }
                AlteracaoDetectada alt = new AlteracaoDetectada();
                alt.setElementoAfetado(a.getElementoAfetado());
                alt.setTipoAlteracao(a.getTipoAlteracao());
                alt.setEstadoAnterior(a.getEstadoAnterior());
                alt.setEstadoAtual(a.getEstadoAtual());
                alt.setDataDeteccao(a.getDataDeteccao());
                alt.setOrigemDetectada(a.getOrigemDetectada());
                alt.setGrauAnomalia(a.getGrauAnomalia());
                ocorrencia = alt;
            }

            case ENCONTRO_INESPERADO -> {
                EncontroInesperadoDTO enc = (EncontroInesperadoDTO) dto;

                EncontroInesperado encontro = new EncontroInesperado();
                encontro.setEncontrado(enc.getEncontrado());
                encontro.setOnde(enc.getOnde());
                encontro.setComo(enc.getComo());
                encontro.setData(enc.getData());
                encontro.setTipoEncontro(enc.getTipoEncontro());
                encontro.setHostilidade(enc.getHostilidade());
                encontro.setCondicaoEncontrado(enc.getCondicaoEncontrado());
                encontro.setInteracao(enc.getInteracao());
                encontro.setResultadoEncontro(enc.getResultadoEncontro());
                encontro.setNivelAmeaca(enc.getNivelAmeaca());

                ocorrencia = encontro;
            }

            case INCIDENTE_OPERACIONAL -> {
                IncidenteOperacionalDTO inc = (IncidenteOperacionalDTO) dto;

                if (inc.getNumeroFatalidades() < 0 || inc.getNumeroFeridos() < 0) {
                    throw new IllegalArgumentException("O número de fatalidades e feridos não pode ser negativo.");
                }

                if (inc.getDataFim().isBefore(inc.getDataInicio())) {
                    throw new IllegalArgumentException("A data final não pode ser anterior à data inicial.");
                }

                IncidenteOperacional incidente = new IncidenteOperacional();
                incidente.setTitulo(inc.getTitulo());
                incidente.setNumeroFatalidades(inc.getNumeroFatalidades());
                incidente.setNumeroFeridos(inc.getNumeroFeridos());
                incidente.setIntensidade(inc.getIntensidade());
                incidente.setTipoIncidente(inc.getTipoIncidente());
                incidente.setDataInicio(inc.getDataInicio());
                incidente.setDataFim(inc.getDataFim());
                incidente.setDanosMateriais(inc.getDanosMateriais());
                incidente.setImpactoMissao(inc.getImpactoMissao());
                incidente.setStatusResolucao(inc.getStatusResolucao());
                incidente.setMedidasAdotadas(inc.getMedidasAdotadas());

                ocorrencia = incidente;
            }
            default -> throw new IllegalArgumentException("Tipo de ocorrência inexistente: "+dto.getTipo());
        }

        ocorrencia.setTipo(dto.getTipo());
        ocorrencia.setMissaoId(dto.getMissaoId());
        ocorrencia.setAutorId(dto.getAutorId());
        ocorrencia.setObservacoes(dto.getObservacoes());

        return repository.save(ocorrencia);
    }


}

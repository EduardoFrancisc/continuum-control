
package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.*;
import br.edu.infnet.continuum.domain.model.Ocorrencia;
import br.edu.infnet.continuum.dtos.OcorrenciaCreateDTO;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.OcorrenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

        Ocorrencia ocorrencia = new Ocorrencia();

        ocorrencia.setTipo(dto.getTipo());
        ocorrencia.setMissaoId(dto.getMissaoId());
        ocorrencia.setAutorId(dto.getAutorId());
        ocorrencia.setObservacoes(dto.getObservacoes());
        ocorrencia.setDadosEspecificos(dto.getDadosEspecificos());

        missaoService.getById(ocorrencia.getMissaoId());
        agenteService.getById(ocorrencia.getAutorId());

        switch (ocorrencia.getTipo()){
            case DISTORÇÃO_TEMPORAL -> {
                Map<String, Object> dados = ocorrencia.getDadosEspecificos();

                if (dados == null
                        || dados.get("intensidade") == null
                        || dados.get("data_inicio") == null
                        || dados.get("data_fim") == null
                        || dados.get("local_ocorrencia") == null
                        || dados.get("raio_impacto") == null
                        || dados.get("estabilidade") == null
                        || dados.get("efeitos_observados") == null
                        || dados.get("risco_estimado") == null) {
                    throw new IllegalArgumentException(
                            "Preencha todos os campos da distorção temporal."
                    );
                }

                LocalDateTime inicio = (LocalDateTime) dados.get("data_inicio");
                LocalDateTime fim = (LocalDateTime) dados.get("data_fim");

                if (fim.isBefore(inicio)) {
                    throw new IllegalArgumentException("A data final não pode ser anterior à data inicial.");
                }
            }

            case EVIDÊNCIA_TEMPORAL -> {
                Map<String, Object> dados = ocorrencia.getDadosEspecificos();

                if (dados == null
                        || dados.get("objeto") == null
                        || dados.get("periodo_estimado") == null
                        || dados.get("grau_confiabilidade") == null
                        || dados.get("tipo_evidencia") == null
                        || dados.get("local_encontrado") == null
                        || dados.get("data_coleta") == null
                        || dados.get("responsavel_coleta") == null
                        || dados.get("integridade") == null
                        || dados.get("origem_estimada") == null) {
                    throw new IllegalArgumentException(
                            "Preencha todos os campos da evidência temporal."
                    );
                }

                Long responsavelId = ((Number) dados.get("responsavel_coleta")).longValue();
                agenteService.getById(responsavelId);
            }

            case ALTERAÇÃO_DETECTADA -> {
                Map<String, Object> dados = ocorrencia.getDadosEspecificos();

                if (dados == null
                        || dados.get("elemento_afetado") == null
                        || dados.get("tipo_alteracao") == null
                        || dados.get("estado_anterior") == null
                        || dados.get("estado_atual") == null
                        || dados.get("data_deteccao") == null
                        || dados.get("origem_detectada") == null
                        || dados.get("grau_anomalia") == null) {

                    throw new IllegalArgumentException(
                            "Preencha todos os campos da alteração detectada."
                    );
                }

                TipoAlteracao.valueOf(dados.get("tipo_alteracao").toString());

                LocalDateTime.parse(dados.get("data_deteccao").toString());

                Float grauAnomalia = ((Number) dados.get("grau_anomalia")).floatValue();
            }
            case ENCONTRO_INESPERADO -> {
                Map<String, Object> dados = ocorrencia.getDadosEspecificos();

                if (dados == null
                        || dados.get("encontrado") == null
                        || dados.get("onde") == null
                        || dados.get("como") == null
                        || dados.get("data") == null
                        || dados.get("tipo_encontro") == null
                        || dados.get("hostilidade") == null
                        || dados.get("condicao_encontrado") == null
                        || dados.get("interacao") == null
                        || dados.get("resultado_encontro") == null
                        || dados.get("nivel_ameaca") == null
                        || dados.get("observacoes") == null) {

                    throw new IllegalArgumentException(
                            "Preencha todos os campos do encontro inesperado."
                    );
                }

                LocalDateTime.parse(dados.get("data").toString()
                );

                TipoEncontro.valueOf(dados.get("tipo_encontro").toString()
                );

                NivelHostilidade.valueOf(dados.get("hostilidade").toString()
                );

                NivelRisco.valueOf(dados.get("nivel_ameaca").toString()
                );

                Boolean.parseBoolean(dados.get("interacao").toString()
                );
            }
            case OBSERVAÇÃO_HISTÓRICA -> {
                Map<String, Object> dados = ocorrencia.getDadosEspecificos();

                if (dados == null
                        || dados.get("periodo_historico") == null
                        || dados.get("fonte_historica") == null
                        || dados.get("data_observacao") == null
                        || dados.get("local_historico") == null
                        || dados.get("grau_confiabilidade") == null
                        || dados.get("relevancia_historica") == null) {

                    throw new IllegalArgumentException(
                            "Preencha todos os campos da observação histórica."
                    );
                }

                LocalDateTime.parse(dados.get("data_observacao").toString()
                );

                Float confiabilidade = ((Number) dados.get("grau_confiabilidade")).floatValue();

                if (confiabilidade < 0 || confiabilidade > 1) {
                    throw new IllegalArgumentException(
                            "O grau de confiabilidade deve estar entre 0 e 1."
                    );
                }

                RelevanciaHistorica.valueOf(dados.get("relevancia_historica").toString());
            }
            case INCIDENTE_OPERACIONAL -> {
                Map<String, Object> dados = ocorrencia.getDadosEspecificos();

                if (dados == null
                        || dados.get("numero_fatalidades") == null
                        || dados.get("intensidade") == null
                        || dados.get("titulo") == null
                        || dados.get("tipo_incidente") == null
                        || dados.get("data_inicio") == null
                        || dados.get("data_fim") == null
                        || dados.get("numero_feridos") == null
                        || dados.get("danos_materiais") == null
                        || dados.get("impacto_missao") == null
                        || dados.get("status_resolucao") == null
                        || dados.get("medidas_adotadas") == null) {

                    throw new IllegalArgumentException(
                            "Preencha todos os campos do incidente operacional."
                    );
                }

                Integer fatalidades = ((Number) dados.get("numero_fatalidades")).intValue();

                Integer feridos = ((Number) dados.get("numero_feridos")).intValue();

                Float intensidade = ((Number) dados.get("intensidade")).floatValue();

                if (fatalidades < 0 || feridos < 0) {
                    throw new IllegalArgumentException(
                            "O número de fatalidades e feridos não pode ser negativo.");
                }

                LocalDateTime inicio = (LocalDateTime) dados.get("data_inicio");

                LocalDateTime fim = (LocalDateTime) dados.get("data_fim");

                if (fim.isBefore(inicio)) {
                    throw new IllegalArgumentException(
                            "A data final não pode ser anterior à data inicial.");
                }

                TipoIncidente.valueOf(dados.get("tipo_incidente").toString());

                ImpactoMissao.valueOf(dados.get("impacto_missao").toString());

                StatusResolucao.valueOf(dados.get("status_resolucao").toString());
            }
        }

        return repository.save(ocorrencia);
    }
}

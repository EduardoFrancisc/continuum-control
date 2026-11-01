package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.enums.EstadoMissao;
import br.edu.infnet.continuum.domain.enums.SituacaoAgente;
import br.edu.infnet.continuum.domain.model.Anomalia;
import br.edu.infnet.continuum.domain.model.EncerramentoMissoes;
import br.edu.infnet.continuum.domain.model.Missao;
import br.edu.infnet.continuum.dtos.AnomaliaMudancaEstadoDTO;
import br.edu.infnet.continuum.dtos.MudarEstadoMissaoDTO;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.EMRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EMService {
    private final EMRepository repository;
    private final MissaoService missaoService;
    private final AgenteService agenteService;
    private final AnomaliaService anomaliaService;

    public EMService(EMRepository repository,
                     MissaoService missaoService,
                     AgenteService agenteService, AnomaliaService anomaliaService){
        this.repository = repository;
        this.missaoService = missaoService;
        this.agenteService = agenteService;
        this.anomaliaService = anomaliaService;
    }

    public List<EncerramentoMissoes> getAll() {
        return repository.findAll();
    }

    public EncerramentoMissoes getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Encerramento "+id+" não encontrado(a).")
        );
    }

    @Transactional
    public EncerramentoMissoes create(@Valid EncerramentoMissoes encerramentoMissoes) {
        Missao m = missaoService.getById(encerramentoMissoes.getMissao().getId());

        if (m.getEstado() != EstadoMissao.EM_EXECUÇÃO){
            throw new IllegalArgumentException("A missão "+m.getId()+" não está em execução, logo não pode ser encerrada.");
        }

        switch (encerramentoMissoes.getResultado()){
            case FALHA ->{
                missaoService.alterState(new MudarEstadoMissaoDTO(
                        m.getId(),
                        EstadoMissao.FALHOU
                ));
            }
            case SUCESSO -> {
                missaoService.alterState(new MudarEstadoMissaoDTO(
                        m.getId(),
                        EstadoMissao.CONCLUÍDA
                ));
            }
//            case SUCESSO_PARCIAL -> {
//                //fazer o que aqui?
//
//            }
        }

        Anomalia anomalia = m.getAnomalia();

        anomaliaService.changeEstate(new AnomaliaMudancaEstadoDTO(
                anomalia.getId(),
                encerramentoMissoes.getSituacaoAnomalia())
        );

        m.getAgentes().forEach(a->{
            a.setSituacao(SituacaoAgente.DISPONÍVEL);
            agenteService.update(a, a.getId());
        });

        return repository.save(encerramentoMissoes);
    }
}

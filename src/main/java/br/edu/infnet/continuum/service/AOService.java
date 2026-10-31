package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.model.AutorizacaoOperacao;
import br.edu.infnet.continuum.domain.model.Missao;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.AORepository;
import br.edu.infnet.continuum.repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AOService {
    private final AORepository repository;
    private final MissaoRepository missaoRepository;

    public AOService(AORepository repository, MissaoRepository missaoRepository){
        this.repository = repository;
        this.missaoRepository = missaoRepository;
    }

    public List<AutorizacaoOperacao> getAll(){
        return repository.findAll();
    }

    public AutorizacaoOperacao getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Autorizacao de Operacao "+id+" não encontrado(a).")
        );
    }

    //Usar o service de missões aqui estava acusando dependência circular
    public Missao getMissionById(Long id) {
        return missaoRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Missão " + id + " não encontrado(a).")
        );
    }

    public AutorizacaoOperacao getByMission(Long id){
        Missao m = getMissionById(id);
        return repository.getAutorizacaoOperacaoByMissao_Id(m.getId());
    }

}

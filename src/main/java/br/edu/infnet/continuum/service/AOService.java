package br.edu.infnet.continuum.service;

import br.edu.infnet.continuum.domain.model.AutorizacaoOperacao;
import br.edu.infnet.continuum.domain.model.Missao;
import br.edu.infnet.continuum.exception.EntidadeNaoLocalizada;
import br.edu.infnet.continuum.repository.AORepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AOService {
    private final AORepository repository;
    private final MissaoService missaoService;

    public AOService(AORepository repository, MissaoService missaoService){
        this.repository = repository;
        this.missaoService = missaoService;
    }

    public List<AutorizacaoOperacao> getAll(){
        return repository.findAll();
    }

    public AutorizacaoOperacao getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntidadeNaoLocalizada("Autorizacao de Operacao "+id+" não encontrado(a).")
        );
    }

    public AutorizacaoOperacao getByMission(Long id){
        Missao m = missaoService.getById(id);
        return repository.getAutorizacaoOperacaoByMissao_Id(m.getId());
    }

}

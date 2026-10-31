package br.edu.infnet.continuum.repository;

import br.edu.infnet.continuum.domain.model.AutorizacaoOperacao;
import br.edu.infnet.continuum.domain.model.Missao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AORepository extends JpaRepository<AutorizacaoOperacao, Long> {
    AutorizacaoOperacao getAutorizacaoOperacaoByMissao_Id(Long missaoId);

}

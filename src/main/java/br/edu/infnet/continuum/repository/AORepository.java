package br.edu.infnet.continuum.repository;

import br.edu.infnet.continuum.domain.model.AutorizacaoOperacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AORepository extends JpaRepository<AutorizacaoOperacao, Long> {
}

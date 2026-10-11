package br.edu.infnet.continuum.repository;

import br.edu.infnet.continuum.domain.model.EncerramentoMissoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EMRepository extends JpaRepository<EncerramentoMissoes, Long> {
}

package br.edu.infnet.continuum.repository;

import br.edu.infnet.continuum.domain.model.EncerramentoMissoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EMRepository extends JpaRepository<EncerramentoMissoes, Long> {
    Optional<EncerramentoMissoes> findByMissao_Id(Long missaoId);
}

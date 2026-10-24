package br.edu.infnet.continuum.repository;

import br.edu.infnet.continuum.domain.enums.ImpactoObservado;
import br.edu.infnet.continuum.domain.model.Intervencao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IntervencaoRepository extends JpaRepository<Intervencao, Long> {
    Integer countAllByImpactoEstimado(ImpactoObservado impacto);
}

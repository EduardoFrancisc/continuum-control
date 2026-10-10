package br.edu.infnet.continuum.repository;

import br.edu.infnet.continuum.domain.enums.EstadoAnomalia;
import br.edu.infnet.continuum.domain.enums.RiscoAnomalia;
import br.edu.infnet.continuum.domain.model.Anomalia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnomaliaRepository extends JpaRepository<Anomalia, Long> {
    List<Anomalia> getAnomaliaByIsActiveTrueAndIsDeletedFalse();
    List<Anomalia> getAnomaliaByRiscoAndIsActiveTrueAndIsDeletedFalse(RiscoAnomalia risco);
    List<Anomalia> getAnomaliaByEstadoAndIsActiveTrueAndIsDeletedFalse(EstadoAnomalia estado);
}

package br.edu.infnet.continuum.repository;

import br.edu.infnet.continuum.domain.enums.ImportanciaEH;
import br.edu.infnet.continuum.domain.model.EventoHistorico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EHRepository extends JpaRepository<EventoHistorico, Long> {
    List<EventoHistorico> getEventoHistoricoByImportanciaAndIsDeletedFalse(ImportanciaEH importanciaEH);
    List<EventoHistorico> getEventoHistoricoByDataInicioBetween(LocalDate dataInicioAfter, LocalDate dataInicioBefore);
}

package br.edu.infnet.continuum.repository;

import br.edu.infnet.continuum.domain.enums.EstadoMissao;
import br.edu.infnet.continuum.domain.model.Missao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissaoRepository extends JpaRepository<Missao, Long> {
    List<Missao> getMissaoByEstado(EstadoMissao estado);
    List<Missao> getByAnomalia_Id(Long id);
    @Query("SELECT missao " +
            "FROM Missao missao " +
            "JOIN missao.agentes agente " +
            "WHERE agente.id = :agenteId"
    )
    List<Missao> getByAgent(@Param("agenteId") Long agenteId);
}

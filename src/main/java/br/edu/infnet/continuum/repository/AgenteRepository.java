package br.edu.infnet.continuum.repository;

import br.edu.infnet.continuum.domain.enums.EspecialidadeAgente;
import br.edu.infnet.continuum.domain.enums.SituacaoAgente;
import br.edu.infnet.continuum.domain.model.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, Long> {
    List<Agente> getAgentesBySituacao(SituacaoAgente situacao);
    List<Agente> getAgentesByEspecialidade(EspecialidadeAgente especialidade);
}

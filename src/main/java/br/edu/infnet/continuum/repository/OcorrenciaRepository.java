package br.edu.infnet.continuum.repository;

import br.edu.infnet.continuum.domain.model.Ocorrencia;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OcorrenciaRepository extends MongoRepository<Ocorrencia, String> {
    List<Ocorrencia> getOcorrenciaByMissaoId(Long id);
    List<Ocorrencia> getOcorrenciaByAutorId(Long id);

}

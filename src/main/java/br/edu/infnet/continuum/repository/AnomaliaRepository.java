package br.edu.infnet.continuum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnomaliaRepository extends JpaRepository<Repository, Long> {
}

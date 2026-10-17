package br.edu.infnet.continuum.repository;

import br.edu.infnet.continuum.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails getUsuarioByLogin(String login);
}

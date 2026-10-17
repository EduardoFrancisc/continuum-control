package br.edu.infnet.continuum.dtos;

import br.edu.infnet.continuum.domain.enums.PerfilUsuario;

public record CriacaoUsuarioDTO(
        String login,
        String senha,
        PerfilUsuario role
) {
}

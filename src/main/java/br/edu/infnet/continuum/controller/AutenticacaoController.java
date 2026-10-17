package br.edu.infnet.continuum.controller;

import br.edu.infnet.continuum.domain.model.Usuario;
import br.edu.infnet.continuum.dtos.AutenticacaoUsuarioDTO;
import br.edu.infnet.continuum.dtos.CriacaoUsuarioDTO;
import br.edu.infnet.continuum.repository.UsuarioRepository;
import br.edu.infnet.continuum.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, TokenService tokenService){
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoUsuarioDTO usuario) {
        var usuarioSenha = new UsernamePasswordAuthenticationToken(usuario.login(), usuario.senha());

        var autenticacao = this.authenticationManager.authenticate(usuarioSenha);

        var token = tokenService.gerarToken( (Usuario) autenticacao.getPrincipal());

        return ResponseEntity.ok(token);

    }

    @PostMapping("/register")
    public ResponseEntity create(@RequestBody @Valid CriacaoUsuarioDTO novoUsuario){
        if (this.usuarioRepository.getUsuarioByLogin(novoUsuario.login()) != null) return ResponseEntity.badRequest().build();

        //senha hash criptografada
        String senhaCriptografada = new BCryptPasswordEncoder().encode(novoUsuario.senha());

        Usuario novo = new Usuario(novoUsuario.login(), senhaCriptografada, novoUsuario.role());

        usuarioRepository.save(novo);

        return ResponseEntity.ok().build();

    }
}

package br.edu.infnet.continuum.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//Autenticação Stateless - token
//Autenticação Statefull - armazenamento se sessão
// video base da parte de segurança - https://www.youtube.com/watch?v=5w-YCcOjPD0

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final SecurityFilter securityFilter;

    public SecurityConfig(SecurityFilter securityFilter){
        this.securityFilter = securityFilter;
    }

    @Bean //pro spring conseguir instanciar a classe
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity
                .csrf(csfr -> csfr.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        //Auth
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()

                        //Agente
                        .requestMatchers(HttpMethod.POST, "/agente").hasAnyRole("ADMINISTRADOR")//create
                        .requestMatchers(HttpMethod.DELETE, "/agente/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//getById
                        .requestMatchers(HttpMethod.PUT, "/agente/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//update
                        .requestMatchers(HttpMethod.GET,  "/agente").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getAll
                        .requestMatchers(HttpMethod.GET,  "/agente/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getById
                        .requestMatchers(HttpMethod.GET,  "/agente/situacao/{situacao}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getBySituacao
                        .requestMatchers(HttpMethod.GET,  "/agente/especialidade/{especialidade}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getByEspecialidade
                        .requestMatchers(HttpMethod.GET,  "/agente/disponiveis").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getDisponiveis

                        //EventoHistórico
                        .requestMatchers(HttpMethod.GET,  "/evento").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR","AGENTE")//getAll
                        .requestMatchers(HttpMethod.GET,  "/evento/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getById
                        .requestMatchers(HttpMethod.POST,  "/evento").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//create

                        //Anomalia
                        .requestMatchers(HttpMethod.POST, "/anomalia").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//create
                        .requestMatchers(HttpMethod.GET, "/anomalia").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getAll
                        .requestMatchers(HttpMethod.GET,  "/anomalia/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getById
                        .requestMatchers(HttpMethod.POST, "/anomalia/classificar/risco").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//changeRisc
                        .requestMatchers(HttpMethod.GET,  "/anomalia/ativas").hasAnyRole("ADMINISTRADOR", "SUPERVISOR", "OPERADOR")//getAtivas
                        .requestMatchers(HttpMethod.GET,  "/anomalia/criticas").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//getCriticas
                        .requestMatchers(HttpMethod.GET,  "/anomalia/estado/{estado}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//getByEstado
                        .requestMatchers(HttpMethod.GET,  "/anomalia/risco/{risco}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//getByRisco
                        .requestMatchers(HttpMethod.GET,  "/anomalia/historico/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//getHistorico

                        //Missão
                        .requestMatchers(HttpMethod.GET, "/missao").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getAll
                        .requestMatchers(HttpMethod.POST, "/missao").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//creat
                        .requestMatchers(HttpMethod.PUT, "/missao/atribuir").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//atribuirAMissões
                        .requestMatchers(HttpMethod.PUT, "/missao/estado/alterar").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//mudarEstadoMissão
                        .requestMatchers(HttpMethod.GET, "/missao/acontecendo").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getAll

                        //Intervenções
                        .requestMatchers(HttpMethod.POST, "/intervencao").hasAnyRole("AGENTE")//create
                        .requestMatchers(HttpMethod.GET,  "/intervencao").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//getAll
                        .requestMatchers(HttpMethod.GET,  "/intervencao/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getById

                        //Ocorrencias
                        .requestMatchers(HttpMethod.POST, "/ocorrencia").hasAnyRole("AGENTE")//create
                        .requestMatchers(HttpMethod.GET,  "/ocorrencia").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//getAll
                        .requestMatchers(HttpMethod.GET,  "/ocorrencia/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getById
                        .requestMatchers(HttpMethod.GET,  "/ocorrencia/missao/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getByMission
                        .requestMatchers(HttpMethod.GET,  "/ocorrencia/autor/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getByAutor

                        //EstabilidadeTemporal
                        .requestMatchers(HttpMethod.GET, "/estabilidade").permitAll()
                        .requestMatchers(HttpMethod.GET,"/estabilidade/estado").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")

                        //AutorizaçãoOperação
                        .requestMatchers(HttpMethod.GET,  "/autorizar-operacoes").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//getAll
                        .requestMatchers(HttpMethod.GET,  "/autorizar-operacoes/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getById
                        .requestMatchers(HttpMethod.POST,  "/autorizar-operacoes").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//getAll

                        //EncerramentoMissoes
                        .requestMatchers(HttpMethod.GET, "/encerramento/**").hasAnyRole("ADMINISTRADOR", "SUPERVISOR", "OPERADOR")
                        .requestMatchers(HttpMethod.POST, "/encerramento").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration){
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }




}

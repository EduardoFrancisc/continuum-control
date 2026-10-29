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
                        .requestMatchers(HttpMethod.POST, "/agente").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//create
                        .requestMatchers(HttpMethod.DELETE, "/agente/{id}").hasAnyRole("ADMINISTRADOR", "OPERADOR")//getById
                        .requestMatchers(HttpMethod.PUT, "/agente/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR")//update
                        .requestMatchers(HttpMethod.GET,  "/agente").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getAll
                        .requestMatchers(HttpMethod.GET,  "/agente/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getById
                        .requestMatchers(HttpMethod.GET,  "/agente/situacao/{situacao}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getBySituacao
                        .requestMatchers(HttpMethod.GET,  "/agente/especialidade/{especialidade}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getByEspecialidade
                        .requestMatchers(HttpMethod.GET,  "/agente/disponiveis").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getDisponiveis

                        //EventoHistórico
                        .requestMatchers(HttpMethod.GET,  "/evento").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR","AGENTE")//getAll
                        .requestMatchers(HttpMethod.GET,  "/evento/{id}").hasAnyRole("ADMINISTRADOR", "SUPERVISOR","OPERADOR")//getById

                        .requestMatchers(HttpMethod.GET, "/anomalia").permitAll()
                        .requestMatchers(HttpMethod.GET, "/estabilidade").permitAll()
                        .requestMatchers(HttpMethod.POST, "/ocorrencia").permitAll()
                        .requestMatchers(HttpMethod.GET, "/ocorrencia").permitAll()
                        .requestMatchers(HttpMethod.GET, "/ocorrencia/missao/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/ocorrencia/autor/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/ocorrencia/{id}").permitAll()


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

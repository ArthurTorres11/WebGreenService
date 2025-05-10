package br.com.tcc.webgreenservice.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desativa CSRF para facilitar testes no Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll() // permite acesso público às rotas da API
                        .anyRequest().authenticated() // outras rotas precisam de login
                )
                .httpBasic(Customizer.withDefaults()); // mantém autenticação básica padrão

        return http.build();
    }
}

package com.formulario.atividade.config;

import com.formulario.atividade.service.DetalhesUsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final DetalhesUsuarioService detalhesUsuarioService;

    public SecurityConfig(DetalhesUsuarioService detalhesUsuarioService) {
        this.detalhesUsuarioService = detalhesUsuarioService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http
            .userDetailsService(detalhesUsuarioService)
            .authorizeHttpRequests(auth -> auth
                // Rotas públicas (sem login)
                .requestMatchers("/", "/home", "/login", "/cadastrar", "/sobre", "/css/**", "/img/**", "/js/**").permitAll()
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                // Qualquer outra rota precisa de autenticação
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home")  // Volta para home após logout
                .permitAll()
            )
            .csrf(csrf -> csrf.disable());
        
        return http.build();
    }
}
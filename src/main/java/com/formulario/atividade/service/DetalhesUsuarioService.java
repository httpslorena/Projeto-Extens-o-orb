package com.formulario.atividade.service;

import com.formulario.atividade.model.Usuario;
import com.formulario.atividade.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DetalhesUsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    // Injeção de dependência via construtor
    public DetalhesUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Método CRÍTICO: Carrega o usuário pelo nome de usuário (username) para o login.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca o usuário no banco de dados usando o método que definimos no Repository
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        // Cria o objeto UserDetails que o Spring Security espera, usando a ROLE do seu modelo
        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                Collections.singletonList(() -> usuario.getRole()) 
        );
    }
}
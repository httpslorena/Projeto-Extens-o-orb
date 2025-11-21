package com.formulario.atividade.service;

import com.formulario.atividade.model.Usuario;
import com.formulario.atividade.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder; 

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

   
    public Usuario salvarUsuario(Usuario usuario) {
        String senhaCodificada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCodificada); 

        if (usuario.getRole() == null || usuario.getRole().isEmpty()) {
            usuario.setRole("ROLE_USER");
        }

        return usuarioRepository.save(usuario);
    }

  
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
    
   
    public void deletarUsuario(Long id) {
        System.out.println("=== DELETANDO USUÁRIO COM ID: " + id + " ===");
        
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            System.out.println("=== USUÁRIO DELETADO COM SUCESSO ===");
        } else {
            System.out.println("=== USUÁRIO NÃO ENCONTRADO ===");
        }
    }
}
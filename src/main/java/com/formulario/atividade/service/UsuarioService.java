package com.formulario.atividade.service;

import com.formulario.atividade.model.Usuario;
import com.formulario.atividade.repository.UsuarioRepository;
// import org.springframework.beans.factory.annotation.Autowired; 👈 ESSA IMPORTAÇÃO TAMBÉM PODE SER REMOVIDA
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder; 

    // ✅ Injeção de dependência via construtor (agora sem o @Autowired desnecessário)
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Salva um novo usuário no banco de dados.
     * CRÍTICO: Codifica a senha antes de salvar.
     */
    public Usuario salvarUsuario(Usuario usuario) {
        // 1. Codifica a senha usando o BCryptPasswordEncoder
        String senhaCodificada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCodificada); 

        // 2. Garante que a ROLE está definida (padrão ROLE_USER)
        if (usuario.getRole() == null || usuario.getRole().isEmpty()) {
            usuario.setRole("ROLE_USER");
        }

        // 3. Salva no banco de dados
        return usuarioRepository.save(usuario);
    }

    /**
     * Lista todos os usuários (para a tela /usuarios)
     */
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
    
    // Outros métodos de serviço (se houver, como buscar por ID, deletar, etc.)
}
package com.formulario.atividade.model;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; 

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    
    // 💥 CORREÇÃO 1: Adição do campo 'email' que faltava
    private String email; 
    
    // CORREÇÃO 2: Garantir que a coluna tenha tamanho suficiente (60)
    // para armazenar o hash do BCrypt.
    @Column(length = 60) 
    private String password; 
    
    // Campo Role é essencial para o Spring Security
    @Column(name = "role")
    private String role; 

    
    public Usuario() {}

    // Construtor atualizado para incluir email
    public Usuario(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // --- Getters e Setters ---
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // 💥 Getters e Setters para o novo campo EMAIL
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() { 
        return password;
    }
    public void setPassword(String password) { 
        this.password = password;
    }

    // Getters e Setters para a ROLE
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
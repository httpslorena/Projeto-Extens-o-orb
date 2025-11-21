package com.formulario.atividade.controller;

import com.formulario.atividade.model.Usuario;
import com.formulario.atividade.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String home() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showHome() {
        return "home";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/sobre")
    public String showAbout() {
        return "sobre";
    }

    @GetMapping("/cadastrar")
    public String showRegistrationForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String registerUser(@ModelAttribute Usuario usuario, Model model) {
        try {
            usuarioService.salvarUsuario(usuario);
            return "redirect:/login?success"; 
        } catch (Exception e) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("cadastroErro", "Erro ao cadastrar: o nome de usuário ou e-mail já existe.");
            return "cadastrar";
        }
    }

    @GetMapping("/usuarios")
    public String listUsers(Model model) {
        model.addAttribute("listaUsuarios", usuarioService.listarUsuarios());
        return "usuarios";
    }

  
    
    @GetMapping("/usuarios/deletar/{id}")
    public String deletarUsuarioGet(@PathVariable("id") Long id) {
        try {
            usuarioService.deletarUsuario(id);
        } catch (Exception e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
        }
        return "redirect:/usuarios";
    }
    
    @PostMapping("/usuarios/deletar/{id}")
    public String deletarUsuarioPost(@PathVariable("id") Long id) {
        try {
            usuarioService.deletarUsuario(id);
        } catch (Exception e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
        }
        return "redirect:/usuarios";
    }
    
    @DeleteMapping("/usuarios/deletar/{id}")
    public String deletarUsuarioDelete(@PathVariable("id") Long id) {
        try {
            usuarioService.deletarUsuario(id);
        } catch (Exception e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
        }
        return "redirect:/usuarios";
    }
}
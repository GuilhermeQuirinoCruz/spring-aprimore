package com.guilherme.aprimore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guilherme.aprimore.entity.Usuario;
import com.guilherme.aprimore.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String cadastro(Usuario usuario) {
        return "usuario/cadastro";
    }

    @GetMapping("/login")
    public String login(Usuario usuario) {
        return "usuario/login";
    }

    @PostMapping("/cadastro")
    public String cadastrar(Usuario usuario, Model model) {
        this.usuarioService.cadastrar(usuario);

        return "redirect:/login";
    }
}

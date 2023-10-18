package com.guilherme.aprimore.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guilherme.aprimore.service.UsuarioDetailsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class IndexController {

    private final UsuarioDetailsService usuarioDetailsService;
    private final SessionRegistry sessionRegistry;
    
    @GetMapping
    public String index() {
        return "index";
    }

    // @GetMapping("bloqueado")
    // public String bloqueado(Authentication authentication, Model model) {
    //     Usuario usuario = usuarioService.usuarioByEmail(authentication.getName());
    //     model.addAttribute("usuario", usuario);
    //     return "bloqueado";
    // }

    @GetMapping("bloqueado")
    public String bloqueado(Model model) {
        model.addAttribute("usuarios", usuarioDetailsService.getUsuariosLogados(this.sessionRegistry));

        return "bloqueado";
    }
}

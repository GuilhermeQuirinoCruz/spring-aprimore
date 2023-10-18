package com.guilherme.aprimore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.guilherme.aprimore.entity.Usuario;
import com.guilherme.aprimore.repository.UsuarioRepository;
import com.guilherme.aprimore.security.UsuarioDetails;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email não encontrado: " + email));
        
        return new UsuarioDetails(usuario);
    }
    
    public List<UsuarioDetails> getUsuariosLogados(SessionRegistry sessionRegistry) {
        List<UsuarioDetails> usuarios = new ArrayList<>();
        for (Object principal : sessionRegistry.getAllPrincipals()) {
            usuarios.add((UsuarioDetails)principal);
        }

        return usuarios;
    }
}

package com.guilherme.aprimore.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.guilherme.aprimore.entity.Usuario;
import com.guilherme.aprimore.enums.Grupo;
import com.guilherme.aprimore.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario cadastrar(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).orElse(null) != null) {
            return null;
        }
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        if (usuario.getGrupo() == null) {
            usuario.setGrupo(Grupo.ALUNO);
        }
        usuarioRepository.save(usuario);

        return usuario;
    }

    public Usuario usuarioByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() ->
            new UsernameNotFoundException("Usuário não encontrado"));
        
        return usuario;
    }
}

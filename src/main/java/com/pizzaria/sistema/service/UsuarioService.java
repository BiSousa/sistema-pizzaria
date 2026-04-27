package com.pizzaria.sistema.service;

import com.pizzaria.sistema.model.Usuario;
import com.pizzaria.sistema.repository.UsuarioRepository;
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

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        if (usuario.getTipo() == null) {
            usuario.setTipo("CLIENTE");
        }

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

}

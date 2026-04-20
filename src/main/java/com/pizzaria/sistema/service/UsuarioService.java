package com.pizzaria.sistema.service;

import com.pizzaria.sistema.model.Usuario;
import com.pizzaria.sistema.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        // regra de negócio: todo novo usuário é CLIENTE por padrão
        if (usuario.getTipo() == null) {
            usuario.setTipo("CLIENTE");
        }
        return usuarioRepository.save(usuario);
    }
}

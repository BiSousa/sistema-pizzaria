package com.pizzaria.sistema.repository;

import com.pizzaria.sistema.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

package com.pizzaria.sistema.repository;

import com.pizzaria.sistema.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
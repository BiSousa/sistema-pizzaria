package com.pizzaria.sistema.repository;

import com.pizzaria.sistema.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}

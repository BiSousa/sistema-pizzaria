package com.pizzaria.sistema.repository;

import com.pizzaria.sistema.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}

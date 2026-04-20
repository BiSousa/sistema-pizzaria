package com.pizzaria.sistema.service;

import com.pizzaria.sistema.model.Pizza;
import com.pizzaria.sistema.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> listarTodas() {
        return pizzaRepository.findAll();
    }

    public Pizza salvar(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }
}

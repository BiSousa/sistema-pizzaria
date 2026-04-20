package com.pizzaria.sistema.controller;

import com.pizzaria.sistema.model.Pizza;
import com.pizzaria.sistema.service.PizzaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<Pizza> listarTodas() {
        return pizzaService.listarTodas();
    }

    @PostMapping
    public Pizza salvar(@RequestBody Pizza pizza) {
        return pizzaService.salvar(pizza);
    }
}

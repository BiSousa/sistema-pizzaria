package com.pizzaria.sistema.repository;

import com.pizzaria.sistema.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

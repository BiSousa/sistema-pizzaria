package com.pizzaria.sistema.service;

import com.pizzaria.sistema.model.Pedido;
import com.pizzaria.sistema.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido salvar(Pedido pedido) {
        // regra de negócio: todo pedido novo começa como PENDENTE
        pedido.setStatus("PENDENTE");
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarStatus(Long id, String status) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(status);
        return pedidoRepository.save(pedido);
    }
}

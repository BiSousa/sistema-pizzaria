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

    private Double calcularPrecoTotal(Pedido pedido) {
        return pedido.getItens().stream()
                .mapToDouble(item -> item.getQuantidade() * item.getPrecoUnitario())
                .sum();
    }

    public Pedido salvar(Pedido pedido) {
        if (pedido.getItens() == null || pedido.getItens().isEmpty()) {
            throw new IllegalArgumentException("Pedido deve conter ao menos um item");
        }
        pedido.setStatus("PENDENTE");
        pedido.setPrecoTotal(calcularPrecoTotal(pedido));
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarStatus(Long id, String status) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado"));
        pedido.setStatus(status);
        return pedidoRepository.save(pedido);
    }
}

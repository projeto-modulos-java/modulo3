package com.projetos.modulo3.services;

import org.springframework.stereotype.Service;

import com.projetos.modulo3.controllers.DTO.Pedido;
import com.projetos.modulo3.repositories.PedidoRepository;
import com.projetos.modulo3.services.adapters.PedidoAdapter;

@Service
public class PedidoService {
    private final PedidoRepository repository;
    private final PedidoAdapter adapter;

    public PedidoService(PedidoRepository repository, PedidoAdapter adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }
    
    public void createPedido(Pedido pedido){
        this.repository.save(adapter.adapt(pedido));
    }


}

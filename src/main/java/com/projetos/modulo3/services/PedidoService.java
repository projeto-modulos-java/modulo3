package com.projetos.modulo3.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetos.modulo3.entities.Pedido;
import com.projetos.modulo3.repositories.PedidoRepository;
import com.projetos.modulo3.services.adapters.AdapterPedido;

@Service
public class PedidoService {
    private final PedidoRepository repository;
    private final AdapterPedido adapter;

    public PedidoService(PedidoRepository repository, AdapterPedido adapter) {
        this.repository = repository;
        this.adapter = adapter;
    }
    
    public void createPedido(Pedido pedido){
        pedido.setStatus("ativo");
        this.repository.save(adapter.adapt(pedido));
    }

    public List<Pedido> list(){
        return this.adapter.adaptEntities(this.repository.findAll());
    }

    public Pedido find(int id){
        return this.adapter.adapt(this.repository.findById(id).orElseThrow());
    }

    public void cancelaPedido(Integer id){
        Pedido pedido = adapter.adapt(this.repository.findById(id).orElseThrow());
        pedido.setStatus("cancelado");
        this.repository.save(adapter.adapt(pedido));
    }
    
}

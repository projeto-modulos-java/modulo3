package com.projetos.modulo3.services.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetos.modulo3.controllers.DTO.Pedido;
import com.projetos.modulo3.repositories.entities.PedidoEntity;
 
@Service
public class PedidoAdapter {
    public PedidoEntity adapt(Pedido pedido){
        return new PedidoEntity(pedido.id(), pedido.produto(), pedido.qtd(), pedido.cep(), pedido.data(), pedido.status());
    }

    public List<PedidoEntity> adaptPedidos(List<Pedido> pedidos){
        return pedidos.stream().map(pedido -> new PedidoEntity(pedido.id(), pedido.produto(), pedido.qtd(), pedido.cep(), pedido.data(),  pedido.status())).toList();
    }

    public Pedido adapt(PedidoEntity entity){
        return new Pedido(entity.getId(), entity.getProduto(), entity.getQtd(), entity.getData(), entity.getCep(), entity.getStatus());
    }

    public List<Pedido> adaptEntities(List<PedidoEntity> entities){
        return entities.stream().map( entity -> 
            new Pedido(entity.getId(), 
                entity.getProduto(), 
                entity.getQtd(), 
                entity.getData(), 
                entity.getCep(), 
                entity.getStatus()
            )).toList();
    }
}

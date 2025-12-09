package com.projetos.modulo3.services.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetos.modulo3.entities.Pedido;
import com.projetos.modulo3.repositories.entities.PedidoEntity;
 
@Service
public class AdapterPedido {
    public PedidoEntity adapt(Pedido pedido){
        return new PedidoEntity(pedido.getId(), pedido.getProduto(), pedido.getQtd(), pedido.getCep(), pedido.getData(), pedido.getStatus());
    }

    public List<PedidoEntity> adaptPedidos(List<Pedido> pedidos){
        return pedidos.stream().map(pedido -> 
            new PedidoEntity(
                pedido.getId(), 
                pedido.getProduto(), 
                pedido.getQtd(), 
                pedido.getCep(), 
                pedido.getData(),  
                pedido.getStatus()
            )).toList();
    }

    public Pedido adapt(PedidoEntity entity){
        return new Pedido(entity.getId(), entity.getProduto(), entity.getQtd(),  entity.getCep(), entity.getData(), entity.getStatus());
    }

    public List<Pedido> adaptEntities(List<PedidoEntity> entities){
        return entities.stream().map( entity -> 
            new Pedido(entity.getId(), 
                entity.getProduto(), 
                entity.getQtd(), 
                entity.getCep(), 
                entity.getData(), 
                entity.getStatus()
            )).toList();
    }
}

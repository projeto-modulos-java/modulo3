package com.projetos.modulo3.controllers.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetos.modulo3.controllers.entities.PedidoRequestDTO;
import com.projetos.modulo3.controllers.entities.PedidoResponseDTO;
import com.projetos.modulo3.entities.Pedido;

@Service
public class AdapterDTO {

     public Pedido adapt(PedidoRequestDTO pedido){
        return new Pedido(pedido.produto(), pedido.qtd(), pedido.cep(), pedido.data());
    }
    
    public PedidoResponseDTO adapt(Pedido pedido){
        return new PedidoResponseDTO(pedido.getId(), pedido.getProduto(), pedido.getQtd(), pedido.getData(), pedido.getCep(), pedido.getStatus());
    }

    public List<Pedido> adapt(List<PedidoResponseDTO> pedidos){
        return pedidos.stream().map(pedido -> new Pedido(pedido.id(), pedido.produto(), pedido.qtd(), pedido.cep(), pedido.data(), null)).toList();
    } 

    public List<PedidoResponseDTO> adaptProducts(List<Pedido> pedidos){
        return pedidos.stream().map(pedido -> 
            new PedidoResponseDTO(pedido.getId(), 
            pedido.getProduto(), 
            pedido.getQtd(), 
            pedido.getData(), 
            pedido.getCep(),
            pedido.getStatus()
        )).toList();
    }
}

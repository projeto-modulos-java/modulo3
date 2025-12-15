package com.projetos.modulo3.controllers;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.projetos.modulo3.controllers.adapters.AdapterDTO;
import com.projetos.modulo3.controllers.entities.PedidoRequestDTO;
import com.projetos.modulo3.services.PedidoService;

@Component
public class PedidoConsumer {

    private final PedidoService service;
    private final AdapterDTO adapter;
    private final Logger logger = LoggerFactory.getLogger(PedidoConsumer.class);

    public PedidoConsumer(PedidoService service, AdapterDTO adapter) {
        this.service = service;
        this.adapter = adapter;
    }

    @Bean
    public Consumer<PedidoRequestDTO> pedido() {
       return value -> {
            service.createPedido(adapter.adapt(value));
            logger.info("Pedido criado com sucesso");
       };
    }

    @Bean
    public Consumer<String> cancelamento(){
        return value -> {
            this.service.cancelaPedido(Integer.parseInt(value));
            logger.info("Cancelando pedido:  {}", value);
        };
    }
}

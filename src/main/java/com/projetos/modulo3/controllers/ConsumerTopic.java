package com.projetos.modulo3.controllers;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.projetos.modulo3.controllers.DTO.Pedido;
import com.projetos.modulo3.services.PedidoService;

@Component
public class ConsumerTopic {

    private final PedidoService service;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ConsumerTopic(PedidoService service) {
        this.service = service;
    }

    @Bean
    public Consumer<Pedido> pedido() {
       return value -> {
            service.createPedido(value);
            logger.info("Pedido criado");
       };
    }

    @Bean
    public Consumer<Pedido> cancelamento(){
        return value -> {

        };
    }
}

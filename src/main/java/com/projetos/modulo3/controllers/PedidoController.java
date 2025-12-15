package com.projetos.modulo3.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.modulo3.controllers.adapters.AdapterDTO;
import com.projetos.modulo3.controllers.entities.PedidoRequestDTO;
import com.projetos.modulo3.controllers.entities.PedidoResponseDTO;
import com.projetos.modulo3.services.PedidoService;

@RestController
@RequestMapping(path = "/pedido")
public class PedidoController {

    private final PedidoService service;
    private final AdapterDTO adapter;
    private final StreamBridge bridge;
    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    public PedidoController(AdapterDTO adapter, PedidoService service, StreamBridge bridge ) {
        this.adapter = adapter;
        this.service = service;
        this.bridge = bridge;
    }

    @GetMapping
    public List<PedidoResponseDTO> get(){
        logger.info("Listando pedidos");
        return adapter.adaptProducts(this.service.list());
    }

    @GetMapping("/{id}")
    public PedidoResponseDTO find(@PathVariable("id") int id){
        logger.info("Encontrando pedido pelo id: {}", id);
        return this.adapter.adapt(this.service.find(id));
    }

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody PedidoRequestDTO pedido){
        logger.info("Pedido criado com sucesso");
        bridge.send("pedido-topic", pedido);
        return ResponseEntity.ok().build();
    } 

    @DeleteMapping("/cancelamento/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id){
        logger.info("Cancelando pedido com id: {}", id);
        bridge.send("cancelar-topic", id);
        return ResponseEntity.ok().build();
    }

}
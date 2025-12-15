package com.projetos.modulo3.controllers.entities;

import java.util.Date;

public record PedidoResponseDTO(
    int id,
    String produto,
    int qtd,
    Date data,
    String cep,
    String status
) {}

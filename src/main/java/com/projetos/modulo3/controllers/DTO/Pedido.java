package com.projetos.modulo3.controllers.DTO;

import java.sql.Date;

public record Pedido(
    int id,
    String produto,
    int qtd,
    Date data,
    String cep,
    String status
) {}

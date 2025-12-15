package com.projetos.modulo3.controllers.entities;

import java.util.Date;

public record PedidoRequestDTO(
    String produto,
    int qtd,
    Date data,
    String cep
) {

}

package com.projetos.modulo3.controllers.DTO;

import java.util.Date;

public record PedidoRequestDTO(
    String produto,
    int qtd,
    Date data,
    String cep
) {

}

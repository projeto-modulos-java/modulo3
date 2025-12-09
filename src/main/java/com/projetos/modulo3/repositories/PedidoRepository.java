package com.projetos.modulo3.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.projetos.modulo3.repositories.entities.PedidoEntity;

@Repository
public interface PedidoRepository extends ListCrudRepository<PedidoEntity, Integer> {
    
}

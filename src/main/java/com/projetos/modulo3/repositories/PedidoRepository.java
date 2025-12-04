package com.projetos.modulo3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetos.modulo3.repositories.entities.PedidoEntity;

@Repository
public interface PedidoRepository extends CrudRepository<PedidoEntity, Integer> {
    
}

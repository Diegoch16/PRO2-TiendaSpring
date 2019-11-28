  
package com.mitienda.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import src.models.Clientes;

@Repository
public interface ClienteRepository extends CrudRepository<Clientes, Long> {

}
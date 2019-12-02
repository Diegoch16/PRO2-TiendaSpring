package com.mitienda.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import src.models.Categorias;

@Repository
public interface CategoriasRepository extends CrudRepository<Categorias, Long> {

    List<Categorias> findByName(String name);

}

package com.mitienda.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import src.models.Categorias;

import java.util.List;

public interface CategoriasRepository extends CrudRepository<Categorias, Long> {

    List<Categorias> findByName(String name);

}

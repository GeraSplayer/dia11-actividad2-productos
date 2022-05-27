package com.gerardo.actividadback1.repositorio;

import java.io.Serializable;

import com.gerardo.actividadback1.entidades.Categoria;

import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Serializable>{
}

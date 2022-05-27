package com.gerardo.actividadback1.repositorio;

import com.gerardo.actividadback1.entidades.Producto;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ProductoRepository extends CrudRepository <Producto, Serializable>{
    
}

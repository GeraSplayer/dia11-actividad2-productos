package com.gerardo.actividadback1.servicio;

import com.gerardo.actividadback1.entidades.Categoria;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CategoriaService {
    ResponseEntity<?> obtenerTodos();
    ResponseEntity<?> obtenerById(Long id);
    ResponseEntity<?> crear(Categoria categoria);
    ResponseEntity<?> actualizar(Long id, Categoria categoria);
    ResponseEntity<?> actualizarPacial(Long id, Map<Object, Object> field);
    ResponseEntity<?> borrar(Long id);
    
}

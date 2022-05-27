package com.gerardo.actividadback1.servicio;

import java.util.Map;

import com.gerardo.actividadback1.entidades.Producto;

import org.springframework.http.ResponseEntity;

public interface ProductoService {
    
    ResponseEntity<?> obtenerTodos();    
    ResponseEntity<?> obtenerById(Long id);
    ResponseEntity<?> crear(Producto producto);
    ResponseEntity<?> actualizar(Long id, Producto producto);
    ResponseEntity<?> actualizarPacial(Long id, Map<Object, Object> field);
    ResponseEntity<?> borrar(Long id);
    
}
package com.gerardo.actividadback1.controlador;

import java.util.Map;

import com.gerardo.actividadback1.entidades.Producto;
import com.gerardo.actividadback1.servicio.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/productos")
public class ProductoControlador {

    @Autowired
    ProductoService service;
    
    @ApiOperation(value = "Reading", notes = "Obtiene todos los productos de la base de datos")
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> obtenerTodos(){
        return service.obtenerTodos();
    }

    @ApiOperation(value = "Read by One", notes = "Obtiene un de los productos de la base de datos," 
                                + "buscando por ID del producto")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> obtenerById(@PathVariable(name = "id") final Long id){
        return service.obtenerById(id);
    }

    @ApiOperation(value = "Creating", notes = "Crea un producto y lo guarda en la base de datos")
    @PostMapping(produces = "application/json")
    public ResponseEntity<?> crear(@RequestBody final Producto producto){
        return service.crear(producto);
    }

    @ApiOperation(value = "Update", notes = "Actualiza todos los datos de un producto")
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> actualizar(@PathVariable(name = "id") final Long id, @RequestBody final Producto producto){
        return service.actualizar(id, producto);
    }

    @ApiOperation(value = "Update parcial", notes = "Actualiza algunos de los datos de un producto")
    @PatchMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> actualizarParcial(@PathVariable(name = "id") final Long id, @RequestBody final Map<Object, Object> fields){
        return service.actualizarPacial(id, fields);
    }

    @ApiOperation(value = "Deleting", notes = "Elimina uno de los productos de la base de datos")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> eliminar(@PathVariable(name = "id") final Long id){
        return service.borrar(id);
    }
    
}
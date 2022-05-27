package com.gerardo.actividadback1.controlador;

import com.gerardo.actividadback1.entidades.Categoria;
import com.gerardo.actividadback1.servicio.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/category")
public class CategoriaControlador {
    
    @Autowired
    CategoriaService service;

    @ApiOperation(value = "Reading", notes = "Obtiene todos las categorias de la base de datos")
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> obtenerTodos(){
        return service.obtenerTodos();
    }

    @ApiOperation(value = "Read by One", notes = "Obtiene un de las categorias de la base de datos," 
                                + "buscando por ID del producto")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> obtenerById(@PathVariable(name = "id") final Long id){
        return service.obtenerById(id);
    }

    @ApiOperation(value = "Creating", notes = "Crea una categoria y lo guarda en la base de datos")
    @PostMapping(produces = "application/json")
    public ResponseEntity<?> crear(@RequestBody final Categoria categoria){
        return service.crear(categoria);
    }

    @ApiOperation(value = "Update", notes = "Actualiza todos los datos de una categorias")
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> actualizar(@PathVariable(name = "id") final Long id, @RequestBody final Categoria categoria){
        return service.actualizar(id, categoria);
    }

    @ApiOperation(value = "Update parcial", notes = "Actualiza algunos de los datos de una categorias")
    @PatchMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> actualizarParcial(@PathVariable(name = "id") final Long id, @RequestBody final Map<Object, Object> fields){
        return service.actualizarPacial(id, fields);
    }

    @ApiOperation(value = "Deleting", notes = "Elimina uno de las categorias de la base de datos")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> eliminar(@PathVariable(name = "id") final Long id){
        return service.borrar(id);
    }

}

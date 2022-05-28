package com.gerardo.actividadback1.servicio.Implementaciones;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

import com.gerardo.actividadback1.entidades.Categoria;
import com.gerardo.actividadback1.entidades.Producto;
import com.gerardo.actividadback1.repositorio.CategoriaRepository;
import com.gerardo.actividadback1.servicio.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    CategoriaRepository repository;
    
    public CategoriaServiceImpl(CategoriaRepository repository) {
		super();
		this.repository = repository;
	}
    
	@Override
    public ResponseEntity<?> obtenerTodos() {
        try {
            ArrayList<Categoria> data = (ArrayList<Categoria>) repository.findAll();
            return new ResponseEntity<>(data, HttpStatus.OK);

        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<?> obtenerById(Long id) {
        try {
            if(id != null) {
                Categoria data = repository.findById(id).orElse(null);
                if(data != null)
                    return new ResponseEntity<>(data, HttpStatus.OK);
                else
                    return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
            }else
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @Override
    public ResponseEntity<?> crear(Categoria categoria) {
        try {
            Categoria data = repository.save(categoria);
            if(data.getId() >= 0)
                return new ResponseEntity<>(data, HttpStatus.CREATED);
            else
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @Override
    public ResponseEntity<?> actualizar(Long id, Categoria categoria) {
        try {
            categoria.setId(id);
            Categoria data = repository.save(categoria);
            if(data.getId() >= 0)
                return new ResponseEntity<>(data, HttpStatus.CREATED);
            else
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<?> actualizarPacial(Long id, Map<Object, Object> fields) {
        try {
            Categoria data = repository.findById(id).orElse(null);
            if(data != null) {
                fields.forEach((key, value) -> {
                    Field f = ReflectionUtils.findField(Categoria.class, (String) key);
                    if (f != null) {
                        f.setAccessible(true);
                        ReflectionUtils.setField(f, data, value);
                    }
                });
                Categoria response = repository.save(data);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else
                return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<?> borrar(Long id) {
        try {
            Categoria data = repository.findById(id).orElse(null);
            if(data != null) {
                repository.delete(data);
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }else
                return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

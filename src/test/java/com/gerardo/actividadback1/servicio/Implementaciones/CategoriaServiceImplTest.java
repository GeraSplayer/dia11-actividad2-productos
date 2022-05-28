package com.gerardo.actividadback1.servicio.Implementaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.gerardo.actividadback1.entidades.Categoria;
import com.gerardo.actividadback1.repositorio.CategoriaRepository;

class CategoriaServiceImplTest {
	
	CategoriaRepository repositoryMock = Mockito.mock(CategoriaRepository.class);
	@Autowired
	CategoriaServiceImpl categoriaServiceImpl = new CategoriaServiceImpl(repositoryMock);
	
	Categoria data;
	ResponseEntity<?> response;
	Map<Object, Object> dataMap;

	@BeforeEach
	void setUp() throws Exception {
		data = new Categoria();
		data.setId(1);
		data.setNombre("Frituras");
		
		dataMap = new HashMap<>();
		dataMap.put("nombre", "Consola");
		
		ArrayList<Categoria> dataAll = new ArrayList<>();
		dataAll.add(data);
		dataAll.add(data);
		dataAll.add(data);
		
		Mockito.when(repositoryMock.findAll()).thenReturn(dataAll);
		Mockito.when(repositoryMock.findById((long)1)).thenReturn(Optional.of(data));
		Mockito.when(repositoryMock.save(any(Categoria.class))).thenReturn(data);
	}

	@Test
	void testObtenerTodos() {
		response = categoriaServiceImpl.obtenerTodos();
		ArrayList<Categoria> dataAll = (ArrayList<Categoria>) response.getBody();
		for (Categoria categoria : dataAll) {
			Assertions.assertEquals(1, categoria.getId() );
			Assertions.assertEquals("Frituras", categoria.getNombre() );
		}
	}

	@Test
	void testObtenerById() {
		response = categoriaServiceImpl.obtenerById((long) 1);
		Assertions.assertEquals(1, ((Categoria)response.getBody()).getId() );
		Assertions.assertEquals("Frituras", ((Categoria)response.getBody()).getNombre() );
	}
	@Test
	void testObtenerByIdreturnNull() {		
		response = categoriaServiceImpl.obtenerById(null);
		Assertions.assertNull(response.getBody());
	}

	@Test
	void testCrear() {
		ResponseEntity<?> response;
		response = categoriaServiceImpl.crear(data);
		Assertions.assertEquals(1, ((Categoria)response.getBody()).getId() );
		Assertions.assertEquals("Frituras", ((Categoria)response.getBody()).getNombre() );
	}

	@Test
	void testActualizar() {
		ResponseEntity<?> response;
		response = categoriaServiceImpl.actualizar((long)1, data);
		Assertions.assertEquals(1, ((Categoria)response.getBody()).getId() );
		Assertions.assertEquals("Frituras", ((Categoria)response.getBody()).getNombre() );
	}

	@Test
	void testActualizarPacial() {
		ResponseEntity<?> response;	
		response = categoriaServiceImpl.actualizarPacial((long)1, dataMap);
		Assertions.assertEquals(1, ((Categoria)response.getBody()).getId() );
		Assertions.assertEquals("Consola", ((Categoria)response.getBody()).getNombre() );
	}

	@Test
	void testBorrar() {
		categoriaServiceImpl.borrar((long) 1);
		Mockito.verify(repositoryMock, atLeastOnce()).delete(data);	
	}

}

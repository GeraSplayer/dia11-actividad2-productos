package com.gerardo.actividadback1.servicio.Implementaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.gerardo.actividadback1.entidades.Producto;
import com.gerardo.actividadback1.repositorio.ProductoRepository;

class ProductoServiceImplTest {

    ProductoRepository repositoryMock = Mockito.mock(ProductoRepository.class);
	@Autowired
	ProductoServiceImpl productoServiceImpl = new ProductoServiceImpl(repositoryMock);
	
	Producto data;
	ResponseEntity<?> response;
	Map<Object, Object> dataMap;
	
	@BeforeEach
	void setUp() throws Exception {
		data = new Producto();
		data.setId(1);
		data.setNombre("Sabritas");
		data.setNumero(123);
		data.setDescripcion("Bolsa de papas");
		data.setCategoria_id(1);
		
		dataMap = new HashMap<>();
		dataMap.put("nombre", "Doritos");
		
		ArrayList<Producto> dataAll = new ArrayList<>();
		dataAll.add(data);
		dataAll.add(data);
		dataAll.add(data);
		
		Mockito.when(repositoryMock.findAll()).thenReturn(dataAll);
		Mockito.when(repositoryMock.findById((long)1)).thenReturn(Optional.of(data));
		Mockito.when(repositoryMock.save(any(Producto.class))).thenReturn(data);
	}


	@Test
	void testObtenerTodos() {
		response = productoServiceImpl.obtenerTodos();
		ArrayList<Producto> dataAll = (ArrayList<Producto>) response.getBody();
		for (Producto producto : dataAll) {
			Assertions.assertEquals(1, producto.getId() );
			Assertions.assertEquals("Sabritas", producto.getNombre() );
			Assertions.assertEquals(123, producto.getNumero() );
			Assertions.assertEquals("Bolsa de papas", producto.getDescripcion() );
			Assertions.assertEquals(1, producto.getCategoria_id() );
		}
	}

	@Test
	void testObtenerById() {
		response = productoServiceImpl.obtenerById((long) 1);
		Assertions.assertEquals(1, ((Producto)response.getBody()).getId() );
		Assertions.assertEquals("Sabritas", ((Producto)response.getBody()).getNombre() );
		Assertions.assertEquals(123, ((Producto)response.getBody()).getNumero() );
		Assertions.assertEquals("Bolsa de papas", ((Producto)response.getBody()).getDescripcion() );
		Assertions.assertEquals(1, ((Producto)response.getBody()).getCategoria_id() );
	}
	@Test
	void testObtenerByIdreturnNull() {		
		response = productoServiceImpl.obtenerById(null);
		Assertions.assertNull(response.getBody());
	}

	@Test
	void testCrear() {
		ResponseEntity<?> response;
		response = productoServiceImpl.crear(data);
		Assertions.assertEquals(1, ((Producto)response.getBody()).getId() );
		Assertions.assertEquals("Sabritas", ((Producto)response.getBody()).getNombre() );
		Assertions.assertEquals(123, ((Producto)response.getBody()).getNumero() );
		Assertions.assertEquals("Bolsa de papas", ((Producto)response.getBody()).getDescripcion() );
		Assertions.assertEquals(1, ((Producto)response.getBody()).getCategoria_id() );
	}

	@Test
	void testActualizar() {
		ResponseEntity<?> response;
		response = productoServiceImpl.actualizar((long)1, data);
		Assertions.assertEquals(1, ((Producto)response.getBody()).getId() );
		Assertions.assertEquals("Sabritas", ((Producto)response.getBody()).getNombre() );
		Assertions.assertEquals(123, ((Producto)response.getBody()).getNumero() );
		Assertions.assertEquals("Bolsa de papas", ((Producto)response.getBody()).getDescripcion() );
		Assertions.assertEquals(1, ((Producto)response.getBody()).getCategoria_id() );
	}

	@Test
	void testActualizarPacial() {
		ResponseEntity<?> response;	
		response = productoServiceImpl.actualizarPacial((long)1, dataMap);
		Assertions.assertEquals(1, ((Producto)response.getBody()).getId() );
		Assertions.assertEquals("Doritos", ((Producto)response.getBody()).getNombre() );
		Assertions.assertEquals(123, ((Producto)response.getBody()).getNumero() );
		Assertions.assertEquals("Bolsa de papas", ((Producto)response.getBody()).getDescripcion() );
		Assertions.assertEquals(1, ((Producto)response.getBody()).getCategoria_id() );
	}

	@Test
	void testBorrar() {
		productoServiceImpl.borrar((long) 1);
		Mockito.verify(repositoryMock, atLeastOnce()).delete(data);	
	}

}

package com.cursoee.vuelos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoee.vuelos.model.Vuelo;
import com.cursoee.vuelos.service.VuelosServiceImpl;

@CrossOrigin("*")
@RestController
public class VuelosController {
	
	@Autowired
	VuelosServiceImpl vuelosService;
	
	@Value("${eureka.instance.instance-id}")
	String instancia;
	
	@GetMapping(value="disponibilidadVuelos/{p}")
	public List<Vuelo> listaProductos(@PathVariable("p") int plazas) {
		System.out.println("Instancia en ejecución: " + instancia);
		return vuelosService.listaVuelosDisponibles(plazas);
	}
	
	@PutMapping(value="actualizarPlazas/{id}/{p}")
	public ResponseEntity<?> obtenerProducto(@PathVariable("id") int idVuelo,
								 @PathVariable("p") int plazas) {
		System.out.println("Instancia en ejecución: " + instancia);

		boolean respuesta = vuelosService.actualizaPlazas(idVuelo, plazas);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("resultado", respuesta?"ok":"error");
		ResponseEntity<?> entity = new ResponseEntity<>(null, headers, HttpStatus.OK);
		return entity;
	}
	
}

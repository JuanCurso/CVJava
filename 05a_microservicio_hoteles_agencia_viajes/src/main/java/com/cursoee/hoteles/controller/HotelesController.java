package com.cursoee.hoteles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursoee.hoteles.model.Hotel;
import com.cursoee.hoteles.service.HotelesServiceImpl;

@CrossOrigin("*")
@RestController
public class HotelesController {
	
	@Autowired
	HotelesServiceImpl hotelesService;
	
	@GetMapping(value="hotelesDisponibles")
	public List<Hotel> listaProductos() {
		return hotelesService.listaHotelesDisponibles();
	}
	
	@GetMapping(value="hotel/{n}")
	public Hotel obtenerProducto(@PathVariable("n") String nombre) {
		return hotelesService.buscarHotel(nombre);
	}
	
}

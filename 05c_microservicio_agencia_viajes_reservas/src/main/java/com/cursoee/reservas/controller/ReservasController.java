package com.cursoee.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cursoee.reservas.dto.DtoReservaI;
import com.cursoee.reservas.dto.DtoReservaO;
import com.cursoee.reservas.service.ReservasServiceImpl;

@CrossOrigin("*")
@RestController
public class ReservasController {
	
	@Autowired
	ReservasServiceImpl reservasService;

	@PostMapping(value="reservar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> altaReserva(@RequestBody DtoReservaI reserva) {
		
		boolean respuesta = reservasService.altaReserva(reserva);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("resultado", respuesta?"ok":"error");
		headers.setAccessControlExposeHeaders(List.of("resultado"));
		ResponseEntity<?> entity = new ResponseEntity<>(null, headers, HttpStatus.OK);
		return entity;
	}
	
	
	@GetMapping(value="reservas/{h}")
	public ResponseEntity<?> listaProductos(@PathVariable("h") String hotel) {
		
		List<DtoReservaO> respuesta = reservasService.listaReservasPorHotel(hotel);

		HttpHeaders headers = new HttpHeaders();
		headers.add("resultado", (respuesta == null || respuesta.isEmpty())?"error":"ok");
		headers.setAccessControlExposeHeaders(List.of("resultado"));
		ResponseEntity<?> entity = new ResponseEntity<>(respuesta, headers, HttpStatus.OK);
		return entity;
	}
	

	
}

package com.cursoee.cliente.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cursoee.cliente.service.ReservasService;

@Controller
public class ReservasController {

	@Autowired
	ReservasService service;
	
	@GetMapping(value="buscar")
	public String buscarReservas(@RequestParam("nombre") String nombreHotel,
													HttpServletRequest request) {
		request.setAttribute("reservas", service.buscarReserva(nombreHotel));
		return "listarReservas";
	}
	
}

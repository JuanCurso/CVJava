package com.cursoee.cliente.service;

import java.util.List;

import com.cursoee.cliente.model.Reserva;

public interface ReservasService {
	
	List<Reserva> buscarReserva(String nombreHotel);
	
}

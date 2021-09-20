package com.cursoee.reservas.service;

import java.util.List;

import com.cursoee.reservas.dto.DtoReservaI;
import com.cursoee.reservas.dto.DtoReservaO;

public interface ReservasService {
	
	boolean altaReserva(DtoReservaI reserva);

	List<DtoReservaO> listaReservasPorHotel(String hotel);
	
}

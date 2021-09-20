package com.cursoee.reservas.util;

import com.cursoee.reservas.dto.DtoReservaI;
import com.cursoee.reservas.dto.DtoReservaO;
import com.cursoee.reservas.model.Reserva;

public class Utilidades {
	
	public static Reserva convertirAReserva(DtoReservaI reserva) {
		return new Reserva(0,reserva.getNombre(), reserva.getDni(), reserva.getHotel(),
				reserva.getVuelo());
	}

	public static DtoReservaO convertirADtoReservaO(Reserva reserva) {
		return new DtoReservaO(reserva.getNombre(), reserva.getDni(), reserva.getVuelo());
	}


}

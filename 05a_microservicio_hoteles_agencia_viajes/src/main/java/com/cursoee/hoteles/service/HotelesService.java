package com.cursoee.hoteles.service;

import java.util.List;

import com.cursoee.hoteles.model.Hotel;

public interface HotelesService {
	
	Hotel buscarHotel(String nombre);

	List<Hotel> listaHotelesDisponibles();
	
}

package com.cursoee.vuelos.service;

import java.util.List;

import com.cursoee.vuelos.model.Vuelo;

public interface VuelosService {
	
	List<Vuelo> listaVuelosDisponibles(int plazas);

	boolean actualizaPlazas(int idVuelo, int plazasReservadas);
	
}

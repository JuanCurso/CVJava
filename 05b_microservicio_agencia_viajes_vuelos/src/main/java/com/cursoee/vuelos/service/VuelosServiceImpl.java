package com.cursoee.vuelos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoee.vuelos.dao.VuelosDaoRepository;
import com.cursoee.vuelos.model.Vuelo;

@Service
public class VuelosServiceImpl implements VuelosService {
	
	@Autowired
	VuelosDaoRepository vuelosDao;

	@Override
	public List<Vuelo> listaVuelosDisponibles(int plazas) {
		return vuelosDao.findByPlazasLessThanEqual(plazas);
	}

	@Override
	public boolean actualizaPlazas(int idVuelo, int plazasReservadas) {
		Optional<Vuelo> vuelo = vuelosDao.findById(idVuelo);

		if (vuelo.isPresent()) {
			int nuevasPlazas = vuelo.get().getPlazas()-plazasReservadas;
			if (nuevasPlazas >= 0) {
				vuelo.get().setPlazas(nuevasPlazas);
				vuelosDao.save(vuelo.get());

				return true;
			} else {
				return false;
			}

		}
		return false;
	}


}

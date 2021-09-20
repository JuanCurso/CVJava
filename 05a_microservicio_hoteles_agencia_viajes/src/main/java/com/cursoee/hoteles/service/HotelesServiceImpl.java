package com.cursoee.hoteles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoee.hoteles.dao.HotelesDaoRepository;
import com.cursoee.hoteles.model.Hotel;

@Service
public class HotelesServiceImpl implements HotelesService {
	
	@Autowired
	HotelesDaoRepository hotelesDao;

	@Override
	public List<Hotel> listaHotelesDisponibles() {
		return hotelesDao.findByDisponible(1);
	}

	@Override
	public Hotel buscarHotel(String nombre) {
		List<Hotel> hoteles = hotelesDao.findByNombre(nombre);
		return hoteles==null?null:hoteles.get(0);

	}


}

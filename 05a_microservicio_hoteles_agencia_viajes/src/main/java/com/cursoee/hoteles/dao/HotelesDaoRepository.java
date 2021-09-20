package com.cursoee.hoteles.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoee.hoteles.model.Hotel;

public interface HotelesDaoRepository extends JpaRepository<Hotel, Integer> {
	
	List<Hotel> findByDisponible(int disponible);

	List<Hotel> findByNombre(String nombre);
}

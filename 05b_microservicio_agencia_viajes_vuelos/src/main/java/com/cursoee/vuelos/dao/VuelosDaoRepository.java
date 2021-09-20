package com.cursoee.vuelos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoee.vuelos.model.Vuelo;

public interface VuelosDaoRepository extends JpaRepository<Vuelo, Integer> {
	
	List<Vuelo> findByPlazasLessThanEqual(int disponible);

}

package com.cursoee.reservas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursoee.reservas.model.Reserva;

public interface ReservasDaoRepository extends JpaRepository<Reserva, Integer> {

	List<Reserva> findByHotel(int hotel);

}

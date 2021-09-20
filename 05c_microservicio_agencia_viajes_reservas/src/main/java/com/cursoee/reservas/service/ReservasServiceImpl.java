package com.cursoee.reservas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cursoee.reservas.dao.ReservasDaoRepository;
import com.cursoee.reservas.dto.DtoReservaI;
import com.cursoee.reservas.dto.DtoReservaO;
import com.cursoee.reservas.model.Hotel;
import com.cursoee.reservas.util.Utilidades;

@Service
public class ReservasServiceImpl implements ReservasService {

	@Autowired
	ReservasDaoRepository reservasDao;

	@Autowired
	RestTemplate template;

	@Autowired
	CircuitBreakerFactory factory;

	//	String urlHoteles="http://localhost:8000";
	//	String urlVuelos="http://localhost:9000";
	String urlHoteles="http://servicio-hoteles";
	String urlVuelos="http://servicio-vuelos";


	@Override
	public boolean altaReserva(DtoReservaI dtoReserva) {

		boolean reservaOK;

		reservaOK = comprobarHotel(dtoReserva.getHotel());

		if (!reservaOK) return false;

		reservaOK = reservarPlazas(dtoReserva.getVuelo(), dtoReserva.getPlazas());

		if (!reservaOK) return false;

		reservasDao.save(Utilidades.convertirAReserva(dtoReserva));

		return true;

	}

	@Override
	public List<DtoReservaO> listaReservasPorHotel(String hotel) {
		Hotel miHotel = obtenerHotel(hotel);

		if (miHotel==null) return null;

		return reservasDao.findByHotel(miHotel.getIdHotel())
				.stream()
				.map(r -> Utilidades.convertirADtoReservaO(r))
				.collect(Collectors.toList());
	}

	private boolean comprobarHotel(int idHotel) {
		System.out.println("comprobarHotel");

		//creamos el CircuitBreaker
		CircuitBreaker breaker=factory.create("circuit1");

		return breaker.run( () -> {
			List<Hotel> hoteles = List.of(template.getForObject(urlHoteles+"/hotelesDisponibles", Hotel[].class));

			return hoteles
					.stream()
					.filter(h -> h.getIdHotel()==idHotel)
					.collect(Collectors.toList()).isEmpty()?false:true;
		}, t -> {
			return false;
		});
	}

	private boolean reservarPlazas(int idVuelo, int plazas) {
		System.out.println("reservarPlazas");

		ResponseEntity<?> response=template.exchange(urlVuelos+"/actualizarPlazas/" + idVuelo
				+"/" + plazas, HttpMethod.PUT, null,Void.class);

		return response.getHeaders().getFirst("resultado").equals("ok")?true:false;

	}

	private Hotel obtenerHotel(String nombre) {
		//creamos el CircuitBreaker
		CircuitBreaker breaker=factory.create("circuit1");
		return breaker.run( () -> {
			return template.getForObject(urlHoteles+"/hotel/" + nombre, Hotel.class);
		}, t -> {
			return null;
		});
	}
}

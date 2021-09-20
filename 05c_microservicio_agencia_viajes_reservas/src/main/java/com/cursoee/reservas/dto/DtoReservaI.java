package com.cursoee.reservas.dto;

public class DtoReservaI {

	private int idreserva;
	private String nombre;
	private String dni;
	private int hotel;
	private int vuelo;
	
	private int plazas;
	
	public DtoReservaI() {
		super();
	}

	public DtoReservaI(int idreserva, String nombre, String dni, int hotel, int vuelo, int plazas) {
		super();
		this.idreserva = idreserva;
		this.nombre = nombre;
		this.dni = dni;
		this.hotel = hotel;
		this.vuelo = vuelo;
		this.plazas = plazas;
	}

	public int getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getHotel() {
		return hotel;
	}

	public void setHotel(int hotel) {
		this.hotel = hotel;
	}

	public int getVuelo() {
		return vuelo;
	}

	public void setVuelo(int vuelo) {
		this.vuelo = vuelo;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}




}

package com.cursoee.cliente.model;

public class Reserva {
	private String nombre;
	private String dni;
	private int vuelo;
	
	
	public Reserva() {
		super();
	}


	public Reserva(String nombre, String dni, int vuelo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.vuelo = vuelo;
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


	public int getVuelo() {
		return vuelo;
	}


	public void setVuelo(int vuelo) {
		this.vuelo = vuelo;
	}

	
}

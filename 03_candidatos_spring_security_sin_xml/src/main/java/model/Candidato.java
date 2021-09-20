package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name="Candidato.findAll", query = "Select c From Candidato c")
@NamedQuery(name="Candidato.findRangeAge", query = "Select c From Candidato c where c.edad>=?1 and c.edad<=?2")
@Entity
@Table(name = "candidatos")
public class Candidato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcandidato;
	private String nombre;
	private int edad;
	private String puesto;
	private String email;

	public Candidato() {
		super();
	}

	public Candidato(int idcandidato, String nombre, int edad, String puesto, String email) {
		super();
		this.idcandidato = idcandidato;
		this.nombre = nombre;
		this.edad = edad;
		this.puesto = puesto;
		this.email = email;
	}

	public int getIdcandidato() {
		return idcandidato;
	}

	public void setIdcandidato(int idcandidato) {
		this.idcandidato = idcandidato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}

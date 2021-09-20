package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "Alumno.findAll", query = "Select a From Alumno a")
@Entity
@Table(name = "alumnos")
public class Alumno {
	@Id
	private String usuario;
	private String password;
	private String nombre;
	private String email;
	private int edad;
	
//  no recomendable porque colapsa la memoria	
//    @ManyToMany(fetch = FetchType.EAGER, mappedBy="alumnos")
    @ManyToMany(mappedBy="alumnos")
	private List<Curso> cursos;
	
	public Alumno() {
		super();
	}

	public Alumno(String usuario, String password, String nombre, String email, int edad) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Alumno [usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", email=" + email
				+ ", edad=" + edad + ", cursos=" + cursos + "]";
	}


	
	
}

package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "preguntas")
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPregunta;
	private String enunciado;

	@ManyToOne
	@JoinColumn(name = "idCurso", referencedColumnName = "idCurso")
	private Curso curso;
	
	@OneToMany(mappedBy = "pregunta", cascade = CascadeType.REMOVE)
	private List<Respuesta> preguntas;


	public Pregunta() {
		super();
	}

	public Pregunta(int idPregunta, String enunciado, Curso curso) {
		super();
		this.idPregunta = idPregunta;
		this.enunciado = enunciado;
		this.curso = curso;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	
	
}

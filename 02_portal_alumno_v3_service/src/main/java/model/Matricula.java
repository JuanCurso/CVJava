package model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "Matricula.findMatriculasAlumno", query = "select m From Matricula m where m.alumno.usuario=?1")
@NamedQuery(name = "Matricula.deleteMatriculas", query = "delete From Matricula m where m.alumno.usuario=?1 and m.curso.idCurso in (?2)")
@Entity
@Table(name = "matriculas")
public class Matricula {
	@EmbeddedId
	private MatriculaPK matricula;
	private double nota;
	
	@ManyToOne
	@JoinColumn(name = "usuario", referencedColumnName = "usuario", insertable = false, updatable = false)
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name = "idCurso", referencedColumnName = "idCurso", insertable = false, updatable = false)
	private Curso curso;

	
	public Matricula() {
		super();
	}
	public Matricula(MatriculaPK matricula, double nota) {
		super();
		this.matricula = matricula;
		this.nota = nota;
	}
	public MatriculaPK getMatricula() {
		return matricula;
	}
	public void setMatricula(MatriculaPK matricula) {
		this.matricula = matricula;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
}

package dao;

import java.util.List;

import javax.ejb.Local;

import models.Alumno;

@Local
public interface AlumnosDao {

	Alumno altaAlumno(Alumno alumno);

	Alumno buscarAlumno(String usuario);

	List<Alumno> listarAlumnos();

	List<Alumno> listarAlumnosDeUnCusso(int idCurso);
	
	boolean compruebaAlumnoMatriculado(String usuario, int idCurso);
	
	List<Alumno> listarAlumnosPorTema(String tema);
	
	void matricularAlumno(String alumno, int idCurso);
	
	void desmatricularAlumno(String alumno, int idCurso);
}
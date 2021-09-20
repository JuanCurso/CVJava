package service;

import java.util.List;

import model.Alumno;

public interface AlumnosService {
	Alumno autenticarAlumno(String user, String password);
	Alumno recuperarAlumno(String user);
	void matricularAlumnoEnCurso(String usuario, int idCurso);
	void desmatricularAlumnoDeCursos(String usuario, List<Integer> idsCurso);

}

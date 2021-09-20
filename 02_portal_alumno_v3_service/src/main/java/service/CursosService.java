package service;

import java.util.List;

import model.Curso;
import model.Matricula;

public interface CursosService {
	List<Matricula> listarCursosDeUnAlumno (String usuario);
	List<Curso> listarCursosParaMatricular(String usuario);
	
	void altaCurso(Curso curso);
}

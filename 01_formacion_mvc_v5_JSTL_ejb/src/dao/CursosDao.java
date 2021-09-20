package dao;

import java.util.List;

import javax.ejb.Local;

import models.Curso;
import models.Pregunta;
import models.Respuesta;

@Local
public interface CursosDao {

	void altaCurso(Curso curso);

	List<Curso> listarCursoDuracionMenor(int duracion);
	
	List<Pregunta> preguntasCurso(int idCurso);

	List<Curso> cursosPreguntasTipo(String tema);

	List<Curso> listarCursos();
	
	List<Respuesta> listarRespuestas(int idPregunta);

	boolean comprobarRespuesta(int idRespuesta);
	
	List<Curso> listarCursosDeUnAlumno(String usuario);

}
package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Curso;
import models.Pregunta;
import models.Respuesta;

@Stateless
@LocalBean
public class CursosDaoImpl implements CursosDao {

	@PersistenceContext(unitName = "formacionPU")
	EntityManager eManager;

	
	@Override
	public void altaCurso(Curso curso) {
		System.out.println(curso.toString());
		eManager.persist(curso);
	}

	@Override
	public List<Curso> listarCursos() {
		String jpql = "select c from Curso c";

		TypedQuery<Curso> q = eManager.createQuery(jpql, Curso.class);
		return q.getResultList();
	}

	@Override
	public List<Curso> listarCursoDuracionMenor(int duracion) {
		TypedQuery<Curso> q = eManager.createNamedQuery("Curso.findDuracionMenor", Curso.class);
		q.setParameter(1, duracion);
		return q.getResultList();
	}
	
	@Override
	public List<Pregunta> preguntasCurso(int idCurso) {
		String jpql = "select p from Pregunta p where p.curso.idCurso = ?1";

		TypedQuery<Pregunta> q = eManager.createQuery(jpql, Pregunta.class);
		q.setParameter(1, idCurso);
		return q.getResultList();
	}
	
	@Override
	public List<Curso> cursosPreguntasTipo(String tema) {
		String jpql = "select c from Curso c join c.preguntas p where p.enunciodo like ?1";

		TypedQuery<Curso> q = eManager.createQuery(jpql , Curso.class);
		q.setParameter(1, "%" + tema + "%");
		return q.getResultList();
	}

	@Override
	public List<Respuesta> listarRespuestas(int idPregunta) {
		String jpql = "select r from Respuesta r where r.pregunta.idPregunta = ?1";

		TypedQuery<Respuesta> q = eManager.createQuery(jpql, Respuesta.class);
		q.setParameter(1, idPregunta);
		return q.getResultList();
	}

	@Override
	public boolean comprobarRespuesta(int idRespuesta) {
		Respuesta respuesta = eManager.find(Respuesta.class, idRespuesta);

		return respuesta.getCorrecta()==1?true:false;
	}

	@Override
	public List<Curso> listarCursosDeUnAlumno(String usuario) {
		String jpql = "select c from Curso c join c.alumnos a where a.usuario = ?1";

		TypedQuery<Curso> q = eManager.createQuery(jpql , Curso.class);
		q.setParameter(1, usuario);
		return q.getResultList();

	}
}

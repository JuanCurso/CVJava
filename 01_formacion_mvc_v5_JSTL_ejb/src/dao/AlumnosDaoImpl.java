package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Alumno;
import models.Curso;

@Stateless
@LocalBean
public class AlumnosDaoImpl implements AlumnosDao {

	@PersistenceContext(unitName = "formacionPU")
	EntityManager eManager;

	
	@Override
	public Alumno altaAlumno(Alumno alumno) {
		Alumno alumnoEncontrado = buscarAlumno(alumno.getUsuario());

		if (alumnoEncontrado==null) {
			eManager.persist(alumno);
			
		}
		return alumnoEncontrado;
	}

	@Override
	public Alumno buscarAlumno(String usuario) {
		return eManager.find(Alumno.class, usuario);
	}

	@Override
	public List<Alumno> listarAlumnos() {
		TypedQuery<Alumno> q = eManager.createNamedQuery("Alumno.findAll", Alumno.class);
		return q.getResultList();
	}

	@Override
	public List<Alumno> listarAlumnosDeUnCusso(int idCurso) {
		String jpql = "select a from Alumno a join a.cursos c where c.idCurso = ?1";

		TypedQuery<Alumno> q = eManager.createQuery(jpql , Alumno.class);
		q.setParameter(1, idCurso);
		return q.getResultList();

	}

	@Override
	public boolean compruebaAlumnoMatriculado(String usuario, int idCurso) {
		String jpql = "select a from Alumno a join a.cursos c where a.usuario = ?1 and c.idCurso = ?2";

		TypedQuery<Alumno> q = eManager.createQuery(jpql , Alumno.class);
		q.setParameter(1, usuario);
		q.setParameter(1, idCurso);
		
		//true= está matriculado | false = no está matriculado
		return !(q.getResultList().isEmpty());
	}

	@Override
	public List<Alumno> listarAlumnosPorTema(String tema) {
		String jpql="select distinct(a) from Alumno a join fetch a.cursos c where a in ";
				jpql+="(select a from Alumno a join a.cursos c where c.nombre like ?1)";


		TypedQuery<Alumno> q = eManager.createQuery(jpql , Alumno.class);
		q.setParameter(1, "%" + tema + "%");
		return q.getResultList();
		
	}

	@Override
	public void matricularAlumno(String usuario, int idCurso) {
		Curso curso = eManager.find(Curso.class, idCurso);
		Alumno alumno = eManager.find(Alumno.class, usuario);
		
		curso.getAlumnos().add(alumno);
		eManager.merge(curso);
		
	}

	@Override
	public void desmatricularAlumno(String usuario, int idCurso) {
		Curso curso = eManager.find(Curso.class, idCurso);
		curso.getAlumnos().removeIf(a->a.getUsuario().equals(usuario));
		eManager.merge(curso);
	}
}

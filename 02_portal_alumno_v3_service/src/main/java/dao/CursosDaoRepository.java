package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;
import model.Curso;

public interface CursosDaoRepository extends JpaRepository<Curso, Integer> {

	//hecho
	//List<Curso> listarCursosDeUnAlumno(String usuario)
	
	@Query(name = "Curso.listCursosDeUnAlumno")
	List<Curso> listarCursosDeUnAlumno(String usuario);
	
	@Transactional
	@Modifying
	@Query(name = "Curso.listCursosParaMatricular")
	List<Curso> listarCursosParaMatricular(String usuario);
}

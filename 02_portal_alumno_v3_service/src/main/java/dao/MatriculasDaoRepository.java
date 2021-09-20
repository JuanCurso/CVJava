package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Matricula;
import model.MatriculaPK;

public interface MatriculasDaoRepository extends JpaRepository<Matricula, MatriculaPK> {
	
	//hecho
	//void matricularAlumno(Matricula matricula);
	
	@Query(name="Matricula.findMatriculasAlumno")
	List<Matricula> matriculasDeUnAlumno(String usuario);
	
	
	@Transactional
	@Modifying
	@Query(name="Matricula.deleteMatriculas")
	void desmatricularCursos(String usuario, List<Integer> idCurso);
}

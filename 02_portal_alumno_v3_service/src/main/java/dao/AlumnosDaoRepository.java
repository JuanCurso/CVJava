package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Alumno;

public interface AlumnosDaoRepository extends JpaRepository<Alumno, String> {

	//hecho
	//Alumno buscarAlumno(String usuario)
	
	
}

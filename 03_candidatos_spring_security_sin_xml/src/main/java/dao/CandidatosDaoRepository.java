package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import model.Candidato;

//Integer hace referencia al tipo de dato de la primary key
public interface CandidatosDaoRepository extends JpaRepository<Candidato, Integer> {
	//alta de candidatos, ya lo tenemos
	//eliminacion de candidato por clave primaria, ya lo tenemos
	//recuperacion de todos los candidatos, ya lo tenemos
	
	
	//buscar candidato por email
	Candidato findByEmail(String email);
	
	//eliminar candidato por email
	@Transactional
	@Modifying
	void deleteByEmail(String email);
	
	
	//buscar candidatos por puesto
	List<Candidato> findByPuesto(String puesto);
	
	//modificar un email antiguo por uno nuevo
	@Transactional
	@Modifying
	@Query(value = "update Candidato c set c.email=?1 where c.email=?2")
	void actualizarEmail(String nuevo, String antiguo);
	
	//recupera candidatos entre unas edades
	@Query(name="Candidato.findRangeAge")
	List<Candidato> recuperarCandidatosEntreEdades(int edad1, int edad2);
}

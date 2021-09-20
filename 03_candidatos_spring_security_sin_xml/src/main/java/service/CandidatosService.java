package service;

import java.util.List;

import model.Candidato;

public interface CandidatosService {
	void altaCandidatos(Candidato candidato);
	
	void eliminarCandidato(int idCandidato);
	
	List<Candidato> recuperarCandidatos();
	
	Candidato buscarCandidato(String email);
}

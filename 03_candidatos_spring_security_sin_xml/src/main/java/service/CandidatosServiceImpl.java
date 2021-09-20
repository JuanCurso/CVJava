package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CandidatosDaoRepository;
import model.Candidato;

@Service
public class CandidatosServiceImpl implements CandidatosService {

	@Autowired
	CandidatosDaoRepository repository;
	
	@Override
	public void altaCandidatos(Candidato candidato) {
		if(repository.findById(candidato.getIdcandidato()).isEmpty() &&
				buscarCandidato(candidato.getEmail())==null) {
			repository.save(candidato);
		}

	}

	@Override
	public void eliminarCandidato(int idCandidato) {
		if(repository.findById(idCandidato)!=null) {
			repository.deleteById(idCandidato);
		}

	}

	@Override
	public List<Candidato> recuperarCandidatos() {
		return repository.findAll();
	}

	@Override
	public Candidato buscarCandidato(String email) {
		return repository.findByEmail(email);
	}

}

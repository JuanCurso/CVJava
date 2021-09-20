package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDaoRepository;
import dao.MatriculasDaoRepository;
import model.Alumno;
import model.Matricula;
import model.MatriculaPK;

@Service
public class AlumnosServiceImpl implements AlumnosService {
	@Autowired
	AlumnosDaoRepository alumnosDao;
	
	@Autowired
	MatriculasDaoRepository matriculasDao;

	@Override
	public Alumno autenticarAlumno(String user, String password) {
		Optional<Alumno> alumnoBBDD = alumnosDao.findById(user);

		if (alumnoBBDD.isEmpty() || !alumnoBBDD.get().getPassword().equals(password)) {
			return null;
		} else {
			return alumnoBBDD.get();
		}
	}

	@Override
	public Alumno recuperarAlumno(String user) {

		return alumnosDao.findById(user).get();
	}

	@Override
	public void matricularAlumnoEnCurso(String usuario, int idCurso) {
		Matricula matricula = new Matricula(new MatriculaPK(usuario,idCurso), 0);
		matriculasDao.save(matricula);

		
	}

	@Override
	public void desmatricularAlumnoDeCursos(String usuario, List<Integer> idsCurso) {
		matriculasDao.desmatricularCursos(usuario, idsCurso);

		
	}


}

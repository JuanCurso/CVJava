package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CursosDaoRepository;
import dao.MatriculasDaoRepository;
import model.Curso;
import model.Matricula;

@Service
public class CursosServiceImpl implements CursosService {
	
	@Autowired
	CursosDaoRepository cursosDao;
	
	@Autowired
	MatriculasDaoRepository matriculasDao;

	@Override
	public List<Matricula> listarCursosDeUnAlumno(String usuario) {
		
		return matriculasDao.matriculasDeUnAlumno(usuario);
	}

	@Override
	public List<Curso> listarCursosParaMatricular(String usuario) {
		return cursosDao.listarCursosParaMatricular(usuario);
	}

	@Override
	public void altaCurso(Curso curso) {
		// TODO Auto-generated method stub

	}

}

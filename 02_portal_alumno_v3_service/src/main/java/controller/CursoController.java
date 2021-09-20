package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Alumno;
import service.CursosService;

@Controller
public class CursoController {

	@Autowired
	CursosService cursosService;
	
	@RequestMapping(value = "listarCursosDeUnAlumno")
	public String listarCursosDeUnAlumno(@SessionAttribute("alumno") Alumno alumno, HttpServletRequest req) {

		req.setAttribute("matriculas", cursosService.listarCursosDeUnAlumno(alumno.getUsuario()));
		return "listar_cursos_de_un_alumno";
		
	}

	@GetMapping(value = "listarCursosParaMatricular")
	public String listarCursosParaMatricular(@SessionAttribute("alumno") Alumno alumno, HttpServletRequest req) {

		
		req.setAttribute("cursos", cursosService.listarCursosParaMatricular(alumno.getUsuario()));
		return "listar_cursos_para_matricular";
		
	}

}

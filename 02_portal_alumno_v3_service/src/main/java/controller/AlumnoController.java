package controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Alumno;
import service.AlumnosService;

@Controller
public class AlumnoController {

	@Autowired
	AlumnosService alumnosService;


	@PostMapping(value = "alumnoLogin")
	public String alumnoLogin(@ModelAttribute("alumno") Alumno alumno, HttpServletRequest req, HttpServletResponse res) {
		Alumno miAlumno = alumnosService.autenticarAlumno(alumno.getUsuario(), alumno.getPassword());
		if (miAlumno==null) {
			req.setAttribute("error", "Usuario o contraseña no válidos.");
			return "login";
		} else {
			crearCookie(miAlumno.getUsuario(), res);

			req.getSession().setAttribute("alumno", miAlumno);
			return "inicio";
		}
		
	}

	@GetMapping(value = "recuperarAlumno")
	public String recuperarAlumno(@RequestAttribute("usuario") String user, HttpServletRequest req) {
		
		System.out.println("usuario_ " + user);
		Alumno alumno = alumnosService.recuperarAlumno(user);
		
		if (alumno == null) {
			req.setAttribute("error", "Usuario inválido o sesión caducada. Ingrese las credenciales de nuevo.");
			return "login";
		} else {
			req.getSession().setAttribute("alumno", alumno);
			return "inicio";
		}
	}

	@GetMapping(value = "alumnoLogout")
	public String alumnoLogout(HttpServletRequest req, HttpServletResponse res) {
			borrarCookie("usuario", res);
			req.getSession().removeAttribute("alumno");
		return "login";
	}
	
	@PostMapping(value = "matricularAlumno")
	public String matricularAlumno(@SessionAttribute("alumno") Alumno alumno,
								   @RequestParam("idCurso") int idCurso) {
		
		alumnosService.matricularAlumnoEnCurso(alumno.getUsuario(), idCurso);
		return "inicio";
	}

	@PostMapping(value = "desmatricularAlumno")
	public String desmatricularAlumno(@SessionAttribute("alumno") Alumno alumno,
								   @RequestParam("idsCurso") List<Integer> idsCurso) {
		
		alumnosService.desmatricularAlumnoDeCursos(alumno.getUsuario(), idsCurso);
		
		//otra opcion para hacerlo
		/*
		 * daoMatriculas.deleteInBatch(Arrays.stream(idsCurso)
					.map(id->new Matricula(new MatriculaPK(alumno.getUsuario(),id),0))
					.collect(Collectors.toList()));

		 */

		return "forward:/listarCursosDeUnAlumno";
	}
	
	private void crearCookie(String miusuario, HttpServletResponse response) {
		Cookie cookie = new Cookie("usuario", miusuario);
		cookie.setMaxAge(200_000);
		response.addCookie(cookie);
	}

	private void borrarCookie(String key, HttpServletResponse response) {
		Cookie cookie = new Cookie(key, "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

}

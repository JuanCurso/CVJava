package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Candidato;
import service.CandidatosService;

@Controller
public class CandidatosController {

	@Autowired
	CandidatosService dao;
	
	@PostMapping(value = "alta")
	public String alta(@ModelAttribute("candidato") Candidato miCandidato) {
		
		dao.altaCandidatos(miCandidato);

		return "formulario";
		
	}
	
	@GetMapping(value = "eliminar")
	public String eliminar(@RequestParam("id") int id,
						   HttpServletRequest request) {

		dao.eliminarCandidato(id);;
		

		return "forward:/recuperar";
	}

	@GetMapping(value = "recuperar")
//	@RequestMapping(value = "recuperar") se usa para que se ejecute ante cualquier metodo
//	HTTP (GET, POST, PUT, DELETE)
	public String recuperar(HttpServletRequest request) {

		request.setAttribute("candidatos", dao.recuperarCandidatos());
		
		return "mostrar";
	}
	
	@GetMapping(value="buscar")
	public String buscar(@RequestParam("email") String email,HttpServletRequest request) {
		Candidato candidato=dao.buscarCandidato(email);
		request.setAttribute("candidato", candidato);
		return "mostrar_candidato";
	}
}

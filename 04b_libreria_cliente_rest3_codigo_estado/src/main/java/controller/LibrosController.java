package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Libro;
import service.LibrosService;

@Controller
public class LibrosController {

	@Autowired
	LibrosService service;
	
	@PostMapping(value="alta")
	public String altaLibro(@ModelAttribute("libro") Libro libro) {
		return service.alta(libro)?"menu":"error";
	}
	
	@GetMapping(value="buscar")
	public @ResponseBody List<Libro> buscarLibros(@RequestParam("tema") String tema) {
		return service.buscarPorTematica(tema);
	}
	
	@GetMapping(value="eliminar")
	public  @ResponseBody List<Libro> eliminar(@RequestParam("tema") String tema, @RequestParam("isbn") int isbn) {
		//List<Libro> todos = service.eliminarPorIsbn(isbn);
		return service.eliminarPorIsbn(isbn)
				.stream()
				.filter(l -> l.getTema().equals(tema))
				.collect(Collectors.toList());
	}
}

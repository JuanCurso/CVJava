package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoLibro;
import service.LibrosServiceImpl;

@RestController
public class LibrosController {
	
	@Autowired
	LibrosServiceImpl librosService;

	@GetMapping(value="busquedaLibroIsbn/{i}")
	public DtoLibro busquedaLibroIsbn(@PathVariable("i") int isbn) {
		System.out.println("Entro en el controller");
		return librosService.busquedaLibroIsbn(isbn);
	}
	
	
	@GetMapping(value="busquedaLibrosTema/{t}")
	public List<DtoLibro> busquedaLibroTema(@PathVariable("t") String tema) {
		System.out.println("Entro en el controller");
		return librosService.busquedaLibrosTema(tema);
	}
	
	//otra version con ResponseEntity
	/*
	 * @GetMapping(value="busquedaLibrosTema/{t}") public
	 * ResponseEntity<List<DtoLibro>> busquedaLibroTema(@PathVariable("t") String
	 * tema) { System.out.println("Entro en el controller"); return new
	 * ResponseEntity<>(librosService.busquedaLibrosTema(tema), null,
	 * HttpStatus.OK); }
	 */

	// En esta version enviamos el resultado de la operacion en la cabecera
	/*
	 * @PostMapping(value="addLibro", consumes = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<?> addLibro(@RequestBody DtoLibro dtoLibro) {
	 * System.out.println("Entro en el controller"); boolean respuesta =
	 * librosService.addLibro(dtoLibro); //creeamos el encabezado con el valor del
	 * resultado HttpHeaders headers = new HttpHeaders(); headers.add("resultado",
	 * respuesta?"ok":"error"); ResponseEntity<?> entity = new
	 * ResponseEntity<>(null, headers, HttpStatus.OK); return entity; }
	 */
	
	// En esta version enviamos un status diferente dependiendo de cómo acabe la operativa
	public ResponseEntity<?> addLibro(@RequestBody DtoLibro dtoLibro) {
		System.out.println("Entro en el controller");
		boolean respuesta = librosService.addLibro(dtoLibro);
		HttpStatus estado = respuesta?HttpStatus.OK:HttpStatus.BAD_REQUEST;
		ResponseEntity<?> entity = new ResponseEntity<>(null, null, estado);
		return entity;
	}

	
	@PutMapping(value="actualizaLibro", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizaLibro(@RequestBody DtoLibro dtoLibro) {
		System.out.println("Entro en el controller");
		librosService.actualizaLibro(dtoLibro);
		
	}
	
	@DeleteMapping(value="eliminaLibro/{i}")
	public List<DtoLibro> eliminaLibro(@PathVariable("i") int isbn) {
		System.out.println("Entro en el controller");
		librosService.eliminaLibro(isbn);
		return librosService.busquedaLibrosTodos();
	}
	
}

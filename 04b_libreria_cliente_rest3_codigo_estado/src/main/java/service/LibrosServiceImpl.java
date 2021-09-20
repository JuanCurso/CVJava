package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import model.Libro;

@Service
public class LibrosServiceImpl implements LibrosService {
	
	@Autowired
	RestTemplate restTemplate;
	
	private String urlBase="http://localhost:8081/15_libreria_rest2_codigo_estado/";

	/*
	 * @Override public boolean alta(Libro libro) {
	 * System.out.println("buscamos el libro: " + libro.toString());
	 * 
	 * ResponseEntity<?> entity = restTemplate.exchange(urlBase+"addLibro",
	 * HttpMethod.POST, new HttpEntity<Libro>(libro), Void.class);
	 * System.out.println("hemos realizado la peticion"); HttpHeaders headers =
	 * entity.getHeaders(); return headers.getFirst("resultado").equals("ok");
	 * 
	 * }
	 */
	
	@Override
	public boolean alta(Libro libro) {
		try {
			restTemplate.postForLocation(urlBase+"addLibro", libro);
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println("Código de estado recibido: " + e.getStatusCode());
			return false;

		}
	}

	@Override
	public List<Libro> buscarPorTematica(String tema) {
		return Arrays.asList(restTemplate.getForObject(urlBase+"busquedaLibrosTema/{tema}", Libro[].class, tema));
	}

	@Override
	public List<Libro> eliminarPorIsbn(int isbn) {
		ResponseEntity<Libro[]> response =
				restTemplate.exchange(urlBase+"eliminaLibro/{isbn}",
				HttpMethod.DELETE, null, Libro[].class, isbn);
		
		return Arrays.asList(response.getBody());
	}

}

package service;

import java.util.List;

import model.Libro;

public interface LibrosService {
	
	boolean alta(Libro libro);
	
	List<Libro> buscarPorTematica(String tema);
	
	List<Libro> eliminarPorIsbn(int isbn);

}

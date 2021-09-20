package service;

import java.util.List;

import dto.DtoLibro;

public interface LibrosService {
	boolean addLibro(DtoLibro libro);
	
	void actualizaLibro(DtoLibro libro);
	
	void eliminaLibro(int isbn);
	
	DtoLibro busquedaLibroIsbn(int isbn);

	List<DtoLibro> busquedaLibrosTema(String tema);
	
	List<DtoLibro> busquedaLibrosTodos();
	
}

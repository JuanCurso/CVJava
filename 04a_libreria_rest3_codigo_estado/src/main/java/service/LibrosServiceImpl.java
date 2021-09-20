package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LibrosDaoRepository;
import dao.TemasDaoRepository;
import dto.DtoLibro;
import model.Libro;
import model.Tema;
import util.Utilidades;

@Service
public class LibrosServiceImpl implements LibrosService {
	
	@Autowired
	LibrosDaoRepository librosDao;

	@Autowired
	TemasDaoRepository temasDao;
	
	@Override
	public boolean addLibro(DtoLibro dtoLibro) {

		if (librosDao.findById(dtoLibro.getIsbn()).isEmpty()) {
			Tema tema;
			List<Tema> temaLista = temasDao.findByTema(dtoLibro.getTema());

			if (temaLista.isEmpty()) {
				System.out.println("tema no encontrado");
				tema = temasDao.save(new Tema(0,dtoLibro.getTema()));
			} else {
				tema = temaLista.get(0);
			}
			librosDao.save(Utilidades.convertirALibro(dtoLibro, tema));
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void actualizaLibro(DtoLibro dtoLibro) {
		Optional<Libro> libro = librosDao.findById(dtoLibro.getIsbn());
		if (libro.isPresent())
			addLibro(dtoLibro);

	}

	@Override
	public void eliminaLibro(int isbn) {
		Optional<Libro> libro = librosDao.findById(isbn);
		if (libro.isPresent())
			librosDao.delete(libro.get());

	}

	@Override
	public DtoLibro busquedaLibroIsbn(int isbn) {
		Optional<Libro> libro = librosDao.findById(isbn);
		return libro.isPresent()?Utilidades.convertirADtoLibro(libro.get()):null;
	}

	@Override
	public List<DtoLibro> busquedaLibrosTema(String tema) {
		return librosDao.findByTemaTema(tema)
			.stream()
			.map(l -> Utilidades.convertirADtoLibro(l))
			.collect(Collectors.toList());
		
	}

	@Override
	public List<DtoLibro> busquedaLibrosTodos() {
		return librosDao.findAll()
					.stream()
					.map(l -> Utilidades.convertirADtoLibro(l))
					.collect(Collectors.toList());
	}



}

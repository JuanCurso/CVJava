package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Libro;

public interface LibrosDaoRepository extends JpaRepository<Libro, Integer> {


	//@Query(name="Libro.findTema")
	List<Libro> findByTemaTema(String tema);

}

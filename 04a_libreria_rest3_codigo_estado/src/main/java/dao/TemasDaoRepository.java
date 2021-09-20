package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Tema;

public interface TemasDaoRepository extends JpaRepository<Tema, Integer> {

	List<Tema> findByTema(String tema);

}

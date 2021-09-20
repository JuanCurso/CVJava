package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Venta;

public interface VentasDaoRepository extends JpaRepository<Venta, Integer> {


	@Query(name="Venta.findEntreFechas")
	List<Venta> busquedaVentasEntreFechas(Date f1, Date f2);
	
	List<Venta> findByLibroIsbn(int isbn);

}

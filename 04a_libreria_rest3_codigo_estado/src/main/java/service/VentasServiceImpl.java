package service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VentasDaoRepository;
import dto.DtoVenta;
import model.Libro;
import util.Utilidades;

@Service
public class VentasServiceImpl implements VentasService {
	
	@Autowired
	VentasDaoRepository ventasDao;

	@Override
	public List<DtoVenta> busquedaVentasEntreFechas(String f1, String f2) {
		Date f1Date = Utilidades.convertirFecha(f1, "00:00:00");
		Date f2Date = Utilidades.convertirFecha(f2, "23:59:59");

		if (f1Date != null && f2Date != null) {
			return ventasDao.busquedaVentasEntreFechas(f1Date, f2Date)
						.stream()
						.map(v -> Utilidades.convertirADtoVenta(v))
						.collect(Collectors.toList());
		}
		return null;
	}
	
	@Override
	public double calculaFacturacion(int isbn) {
		return ventasDao.findByLibroIsbn(isbn)
					.stream()
					.mapToDouble(v -> v.getLibro().getPrecio())
					.sum();
		
	}
}

package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoVenta;
import service.VentasServiceImpl;

@RestController
public class VentasController {
	
	@Autowired
	VentasServiceImpl ventasService;


	
	@GetMapping(value="busquedaVentasEntreFechas/{f1}/{f2}")
	public List<DtoVenta> busquedaVentasEntreFechas(@PathVariable("f1") String f1,
			@PathVariable("f2") String f2) {
		
		System.out.println("Entro en el controller");
		return ventasService.busquedaVentasEntreFechas(f1, f2);
	}
	
	@GetMapping(value="calculaFacturacion/{i}")
	public String calculaFacturacion(@PathVariable("i") int isbn) {
		System.out.println("Entro en el controller");
		return Double.toString(ventasService.calculaFacturacion(isbn));
	}
	
}

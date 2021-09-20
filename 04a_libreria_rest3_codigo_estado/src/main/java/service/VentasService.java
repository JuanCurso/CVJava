package service;

import java.util.List;

import dto.DtoVenta;

public interface VentasService {

	List<DtoVenta> busquedaVentasEntreFechas(String f1, String f2);
	
	double calculaFacturacion(int isbn);
}

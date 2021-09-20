package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import dto.DtoLibro;
import dto.DtoVenta;
import model.Libro;
import model.Tema;
import model.Venta;

public class Utilidades {

	public static DtoLibro convertirADtoLibro(Libro libro) {
		DtoLibro dtoLibro = new DtoLibro(libro.getIsbn(),libro.getTitulo(), libro.getAutor(),
				libro.getPrecio(), libro.getPaginas());
		
		dtoLibro.setTema(libro.getTema().getTema());
				
		return dtoLibro;
	}

	public static Libro convertirALibro(DtoLibro dtoLibro, Tema tema) {
		Libro libro = new Libro(dtoLibro.getIsbn(),dtoLibro.getTitulo(), dtoLibro.getAutor(),
				dtoLibro.getPrecio(), dtoLibro.getPaginas());
		libro.setTema(tema);
		return libro;
	}
	
	public static DtoVenta convertirADtoVenta(Venta venta) {
		DtoVenta dtoVenta = new DtoVenta();
		dtoVenta.setTitulo(venta.getLibro().getTitulo());
		dtoVenta.setCliente(venta.getCliente().getUsuario());
		
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = venta.getFecha();
		dtoVenta.setFecha_venta(format.format(fecha));
		
		return dtoVenta;
	}

	public static Date convertirFecha(String fecha, String hora) {
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date fechaDate = null;
		try {
			fechaDate = format.parse(fecha + " " + hora);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return fechaDate;
		}
	}

}

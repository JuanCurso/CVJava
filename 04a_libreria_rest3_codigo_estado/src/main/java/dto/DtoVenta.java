package dto;

public class DtoVenta {
	
	private String titulo;
	private String cliente;
	private String fecha_venta;
	
	public DtoVenta() {
		super();
	}

	public DtoVenta(String titulo, String cliente, String fecha_venta) {
		super();
		this.titulo = titulo;
		this.cliente = cliente;
		this.fecha_venta = fecha_venta;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(String fecha_venta) {
		this.fecha_venta = fecha_venta;
	}
	
	

}

package colecciones;

public class Clientes {

	private String nombre;
	private String cuenta;
	private double saldo;
	
	public Clientes(String nombre, String cuenta, double saldo) {
		this.nombre = nombre;
		this.cuenta = cuenta;
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Clientes [nombre=" + nombre + ", cuenta=" + cuenta + ", saldo=" + saldo + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Clientes))
			return false;
		Clientes other = (Clientes) obj;
		if (cuenta == null) {
			if (other.cuenta != null)
				return false;
		} else if (!cuenta.equals(other.cuenta))
			return false;
		return true;
	}
	
	

}

package colecciones;

import java.util.HashMap;
import java.util.Map;

public class UsoMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Empleado> personal=new HashMap<String, Empleado>();
		
		personal.put("1", new Empleado("Juan"));
		personal.put("2", new Empleado("Pepe"));
		personal.put("3", new Empleado("Jose"));
		personal.put("4", new Empleado("Luis"));

		System.out.println(personal.get("2"));
		
		System.out.println(personal);
		
		personal.remove("3");
		
		System.out.println(personal);

		//reemplazamos el elemento 2
		personal.put("2", new Empleado("Jose"));

		System.out.println(personal);

		for (Map.Entry<String, Empleado> e : personal.entrySet()) {
			System.out.println("El id es " + e.getKey() + " y su nombre es " +
					e.getValue().getNombre() + " con un sueldo de " + e.getValue().getSueldo());
		}
	}

}

class Empleado {
	private String nombre;
	private double sueldo;
	public Empleado(String nombre) {
		this.nombre = nombre;
		this.sueldo=2000;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", sueldo=" + sueldo + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	
}
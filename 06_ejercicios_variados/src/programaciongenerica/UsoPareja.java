package programaciongenerica;

public class UsoPareja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pareja<String> miPareja = new Pareja<String>();
		
		miPareja.setPrimero("holita");
		
		System.out.println(miPareja.getPrimero());
		
		Pareja<Persona> miPersona= new Pareja<Persona>();
		
		miPersona.setPrimero(new Persona("Pepe"));
		
		System.out.println(miPersona.getPrimero());
		
		
		//Herencia y tipos Comodin
		
		Empleado montador = new Empleado("Ana", 25000, 25, 2008, 10, 1);

		Administrador jefe = new Administrador("Juan", 80000, 50, 2005, 12, 15);
		
		jefe.setIncetivo(5000);
		
		Pareja<Empleado> miEmpleado = new Pareja<Empleado>();
		Pareja<Administrador> miAdministrativo = new Pareja<Administrador>();
		
		miEmpleado.setPrimero(montador);
		miAdministrativo.setPrimero(jefe);
		
		Pareja.imprimirTrabajador(miEmpleado);
		Pareja.imprimirTrabajador(miAdministrativo);

		
	}

}

class Persona {
	
	private String nombre;
	
	Persona(String nombre) {
		this.nombre=nombre;
	}
	
	public String toString() {
		return "nombre=" + nombre;
	}
	
}
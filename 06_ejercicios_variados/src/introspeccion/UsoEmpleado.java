package introspeccion;

import java.lang.reflect.Field;

public class UsoEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona antonio=new Persona("Antonio");
		
		System.out.println(antonio.getNombre());
		
		Empleado ana=new Empleado("Ana", 50000);
		
		System.out.println(ana.getNombre() + ". " + ana.getSalario());
		
		Class cl1=antonio.getClass();
		System.out.println(cl1.getName());
		
		String nombreClase="instrospeccion.Empleado";
		
		Class cl2;
		try {
			cl2=Class.forName(nombreClase);
			System.out.println(cl2.getName());
			
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nombreClase="instrospeccion.Persona";
		
		try {
			cl2=Class.forName(nombreClase);
			System.out.println(cl2.getName());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Persona {
	private String nombre;

	
	public Persona(String nombre) {
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}
	
}

class Empleado extends Persona {
	private double salario;

	public Empleado(String nombre, double salario) {
		super(nombre);
		this.salario = salario;
	}

	public String getSalario() {
		return "El salario es " + salario;
	}
	
	public void setIncentivo(double incentivo) {
		salario+=incentivo;
	}
}
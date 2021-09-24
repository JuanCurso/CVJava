package programaciongenerica;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;


public class UsoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Administrador jefe = new Administrador("Juan", 80000, 50, 2005, 12, 15);
		
		jefe.setIncetivo(5000);
		
/*		Empleado personal[]= new Empleado[3];
		
		personal[0]=jefe;
		personal[1]=new Empleado("Ana", 25000, 25, 2008, 10, 1);
		personal[2]=new Empleado("Luis", 18000, 21, 2012, 9, 15);
*/
	
		ArrayList<Empleado> personal = new ArrayList<Empleado>();
		
		//personal.ensureCapacity(12);
		
		personal.add(jefe);
		personal.add(new Empleado("Ana", 25000, 25, 2008, 10, 1));
		personal.add(new Empleado("Luis", 18000, 21, 2012, 9, 15));
		
		personal.add(jefe);
		personal.add(new Empleado("Ana", 25000, 25, 2008, 10, 1));
		personal.add(new Empleado("Luis", 18000, 21, 2012, 9, 15));
		
		personal.add(jefe);
		personal.add(new Empleado("Ana", 25000, 25, 2008, 10, 1));
		personal.add(new Empleado("Luis", 18000, 21, 2012, 9, 15));
		
		personal.add(jefe);
		personal.add(new Empleado("Ana", 25000, 25, 2008, 10, 1));
		personal.add(new Empleado("Luis", 18000, 21, 2012, 9, 15));
		
		personal.trimToSize();
		
		System.out.println(personal.size());
		
		personal.set(3, new Administrador("Sonia", 110000, 55, 1990, 02, 27));
		
		System.out.println(personal.get(3));
		
		int i=0;
		
		for (Empleado e:personal) {
			System.out.println(i + " " +e);
			i++;
		}
		
		//Uso de iterador
		System.out.println("ITERADOR");
		
		Iterator<Empleado> iterador = personal.iterator();
		
		while (iterador.hasNext()) {
			System.out.println(iterador.next());
		}
		
		//Convierte el ArrayList a array
		System.out.println("ARRAY");

		Empleado[] miPersonal = new Empleado[personal.size()];
		
		personal.toArray(miPersonal);
		
		for (Empleado e:miPersonal) {
			System.out.println(e);

		}
	}

}


class Empleado {
	
	private String nombre;
	private double sueldo;
	private int edad;
	private Date fAlta;
	
	public Empleado(String n, double s, int e,int a, int m, int d) {
		nombre=n;
		sueldo=s;
		edad=e;
		
		fAlta = new GregorianCalendar(a, m-1, d).getTime();
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



	public Date getfAlta() {
		return fAlta;
	}



	public void setfAlta(Date fAlta) {
		this.fAlta = fAlta;
	}



	public void subirSueldo(double porcentaje) {
		sueldo = sueldo + (sueldo * porcentaje /100);
	}
	
	public String toString() {
		return "nombre=" + nombre + ", sueldo=" + sueldo + ", edad=" + edad + ", fAlta=" + fAlta;
	}
}

class Administrador extends Empleado {
	
	private double incentivo;
	
	public Administrador(String n, double s, int e, int a, int m, int d) {
		super(n, s, e, a, m, d);
		
		incentivo=0;
	}
	
	public double getSueldo() {
		double sueldoBase = this.getSueldo();
		return sueldoBase + incentivo;
	}
	
	public void setIncetivo (double i) {
		incentivo = i;
	}
	
	public String toString() {
		return super.toString() + ", incentivo=" + incentivo;
	}
	
}
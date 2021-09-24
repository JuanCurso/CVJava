package accesoficheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serializacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);
		
		jefe.setIncetivo(5000);
		
		Empleado personal[]= new Empleado[3];
		
		personal[0]=jefe;
		personal[1]=new Empleado("Ana", 25000, 2008, 10, 1);
		personal[2]=new Empleado("Luis", 18000, 2012, 9, 15);
		
		try {
			ObjectOutputStream fSalida=new ObjectOutputStream(new FileOutputStream("src/accesoficheros/personal.txt"));
			
			
			fSalida.writeObject(personal);
			
			fSalida.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ObjectInputStream fEntrada = new ObjectInputStream(new FileInputStream("src/accesoficheros/personal.txt"));
			
			Object[] pers=(Object[])fEntrada.readObject();
			
			fEntrada.close();
			
			for (Object e:pers) {
				System.out.println(e);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}

	}

}

class Empleado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private double sueldo;
	private Date fAlta;
	
	public Empleado(String n, double s, int a, int m, int d) {
		nombre=n;
		sueldo=s;
		
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
		return "nombre=" + nombre + ", sueldo=" + sueldo + ", fAlta=" + fAlta;
	}
}

class Administrador extends Empleado {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private double incentivo;
	
	public Administrador(String n, double s, int a, int m, int d) {
		super(n, s, a, m, d);
		
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

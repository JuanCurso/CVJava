package colecciones;

import java.util.Comparator;
import java.util.TreeSet;

public class UsoTreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<Articulo> tienda=new TreeSet<Articulo>();
		
		Articulo a1=new Articulo(1, "Atun");
		Articulo a2=new Articulo(3, "Calamares");
		Articulo a3=new Articulo(2, "Salmon");
		Articulo a4=new Articulo(0, "Pez espada");
		
		tienda.add(a1);
		tienda.add(a2);
		tienda.add(a3);
		tienda.add(a4);
		
		for (Articulo articulo : tienda) {
			System.out.println(articulo);
		}
		
		
		TreeSet<Articulo> tienda2=new TreeSet<Articulo>(new Comparator<Articulo>() {

			@Override
			public int compare(Articulo o1, Articulo o2) {
				// TODO Auto-generated method stub
				return o1.getDescripcion().compareTo(o2.getDescripcion());

			}
			
		});

		tienda2.add(a1);
		tienda2.add(a2);
		tienda2.add(a3);
		tienda2.add(a4);
		
		for (Articulo articulo : tienda2) {
			System.out.println(articulo);
		}
	}

}



class Articulo implements Comparable<Articulo> {

	private int numero;
	private String descripcion;
	
	
	public Articulo(int numero, String descripcion) {
		this.numero = numero;
		this.descripcion = descripcion;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "Articulo [numero=" + numero + ", descripcion=" + descripcion + "]";
	}


	@Override
	public int compareTo(Articulo o) {
		// TODO Auto-generated method stub
		return this.numero-o.numero;
	}
	
}

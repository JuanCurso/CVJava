package colecciones;

import java.util.LinkedList;
import java.util.ListIterator;

public class UsoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> paises=new LinkedList<String>();
		
		paises.add("España");
		paises.add("Colombia");
		paises.add("Mexico");
		paises.add("Peru");
		
		LinkedList<String> capitales=new LinkedList<String>();
		
		capitales.add("Madrid");
		capitales.add("Bogota");
		capitales.add("DF");
		capitales.add("Lima");
		
		ListIterator iPaises=paises.listIterator();
		ListIterator iCapitales=capitales.listIterator();

		while (iPaises.hasNext()) {
			iPaises.next();
			iPaises.add(iCapitales.next());
		}
		
		for (String p : paises) {
			System.out.println(p);
		}
		
		//Borramos las capitales pares
		
		iCapitales=capitales.listIterator();
		
		while (iCapitales.hasNext()) {
			iCapitales.next();
			
			if (iCapitales.hasNext()) {
				iCapitales.next();
				iCapitales.remove();
			}
		}
		
		System.out.println(capitales);
		
		//Borramos de la lista de paises las capitales que tenemos en la lista de capitales
		
		paises.removeAll(capitales);
		
		System.out.println(paises);
	}

}

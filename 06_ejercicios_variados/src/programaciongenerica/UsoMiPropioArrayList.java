package programaciongenerica;

import java.io.File;

public class UsoMiPropioArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList miArrayList = new ArrayList(4);
		
		miArrayList.add("Juan");
		miArrayList.add("Pepe");
		miArrayList.add("Luis");
		
		miArrayList.add(new File("texto.txt"));
		
		System.out.println((String)miArrayList.get(1));

	}

}

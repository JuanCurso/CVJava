package colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UsoClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Clientes cl1=new Clientes("Joselito", "00001", 200000);
		Clientes cl2=new Clientes("Pepeillo", "00002", 400000);
		Clientes cl3=new Clientes("Manolillo", "00003", 150000);
		Clientes cl4=new Clientes("Pepeillo", "00002", 400000);

		Set<Clientes> clientesBanco=new HashSet<Clientes>();
		
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		
		for (Clientes clientes : clientesBanco) {
			System.out.println(clientes);
		}

		System.out.println("BORRAMOS ELEMENTO CUENTA 00001");
		
		//BORRAR ELEMENTO CON ITERADOR PORQUE CON FOR EACH NO SE PUEDE
		Iterator<Clientes> i=clientesBanco.iterator();
		
		while (i.hasNext()) {
			if (i.next().getCuenta().equals("00001"))
				i.remove();

		}
		
		for (Clientes clientes : clientesBanco) {
			System.out.println(clientes);

		}
	}

}

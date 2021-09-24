package accesoficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class RWByte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeerFichero1 miLectura = new LeerFichero1();
		
		int contador=0;
		int[] img = new int[123216]; 
		int a=0;
		
		a=miLectura.lee();

		while (a!=-1) {
			
			img[contador] = a;

			contador++;

			a = miLectura.lee();
			
			System.out.println(contador + " " + a);
		} ;
		
		miLectura.cierra();
		
		System.out.println("Longitud arrary: " + img.length);
		
		EscribirFichero1 miEscritura = new EscribirFichero1();
		
		for (int i=0; i<img.length; i++) {
			miEscritura.escribe(img[i]);
		}
		
		System.out.println("Numero de bytes leidos: " + contador);
	}

}

class LeerFichero1 {
	
	private FileInputStream miFichero;
	
	LeerFichero1() {
			try {
				miFichero=new FileInputStream(new File("src/accesoficheros/imagen.jpg"));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("No he encontrado el fichero");
				e.printStackTrace();
				System.exit(0);
			}
		
	}
	
	public int lee() {
		int c=0;
		try {
			c=miFichero.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);

		}
		
		return c;
	}
	
	public void cierra() {
		try {
			miFichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class EscribirFichero1 {
	
	private FileOutputStream miFichero;
	
	EscribirFichero1() {
			try {
				miFichero=new FileOutputStream(new File("src/accesoficheros/copiaimg.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("No he encontrado el fichero");
				e.printStackTrace();
				System.exit(0);
			}
		
	}
	
	public void escribe(int frase) {
		try {
			miFichero.write(frase);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);

		}
		
	}
	
	public void cierra() {
		try {
			miFichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
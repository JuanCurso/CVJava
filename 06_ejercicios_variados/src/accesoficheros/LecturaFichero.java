package accesoficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeerFichero miLectura = new LeerFichero();
		
		String c;
		c=miLectura.lee();

		while (c!=null) {
			System.out.println(c);
			c=miLectura.lee();
		} ;
		
		miLectura.cierra();
	}

}

class LeerFichero {
	
	private FileReader miFichero;
	private BufferedReader miBuffer;
	
	LeerFichero() {
			try {
				miFichero=new FileReader(new File("src/accesoficheros/texto.txt"));
				miBuffer = new BufferedReader(miFichero);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("No he encontrado el fichero");
				e.printStackTrace();
				System.exit(0);
			}
		
	}
	
	public String lee() {
		String c="";
		try {
			c=miBuffer.readLine();
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
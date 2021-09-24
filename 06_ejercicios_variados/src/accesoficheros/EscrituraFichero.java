package accesoficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EscribirFichero miLectura = new EscribirFichero();
		
		miLectura.escribe("Holitaaaaa, esto es mi prueba de fichero.");

		miLectura.cierra();
	}

}

class EscribirFichero {
	
	private FileWriter miFichero;
	
	EscribirFichero() {
			try {
				miFichero=new FileWriter(new File("src/accesoficheros/texto1.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("No he encontrado el fichero");
				e.printStackTrace();
				System.exit(0);
			}
		
	}
	
	public void escribe(String frase) {
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
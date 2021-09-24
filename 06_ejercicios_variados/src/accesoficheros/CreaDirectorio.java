package accesoficheros;

import java.io.File;
import java.io.IOException;

public class CreaDirectorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File archivo = new File("src" + File.separator + "accesoficheros");
		
		File nuevoDir = new File(archivo.getAbsolutePath(), "nueva_carpetita");
		
		System.out.println(nuevoDir.mkdir());
		
		File nuevoFichero = new File(nuevoDir.getAbsolutePath(), "nuevo_fichero.txt");
		
		try {
			System.out.println(nuevoFichero.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//nuevoFichero.delete();
	}

}

package accesoficheros;

import java.io.File;

public class AccesoDirectorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File archivo = new File("./");
		
		System.out.println(archivo.getAbsolutePath());
		
		System.out.println(archivo.exists());
		
		String[] lista= archivo.list();
		
		for (String e:lista) {
			System.out.print(e);
			
			File f = new File(archivo.getAbsoluteFile(), e);
			if (f.isDirectory()) {
				System.out.println("---------- DIRECTORIO");
				listarDirectorio(f);

			}
			else {
				System.out.println();
			}
		}
	}
	
	private static void listarDirectorio(File f) {
		String[] lista= f.list();
		
		for (String e:lista) {
			System.out.print(e);
			
			File fa = new File(f.getAbsoluteFile(), e);
			if (fa.isDirectory()) {
				System.out.println("---------- DIRECTORIO");
				listarDirectorio(fa);
			}
			else {
				System.out.println();
			}
		}
	}

}

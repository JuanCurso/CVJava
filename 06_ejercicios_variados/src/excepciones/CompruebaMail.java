package excepciones;

import javax.swing.JOptionPane;

public class CompruebaMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		CompruebaMail.comprobarEmail(JOptionPane.showInputDialog("Dame tu email:"));
		}
		
		catch (LongitudMailException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public static void comprobarEmail(String cadena) throws LongitudMailException {
		boolean error=false;

		System.out.println(cadena);

		if (cadena.length()<4) throw new LongitudMailException("Email demasiado corto!!!!!!!!!!!!!!!!!");

		char letra;
		int arroba=0;
		int punto=0;

		for (int i=0; i<cadena.length() && !error; i++) {
			letra=cadena.charAt(i);

			switch (letra) {

			case '@':
				arroba++;
				if (arroba>1) error=true;
				break;
			case '.':
				punto++;
				break;
			}
		}

		if (punto==0) error=true;

		if (error) {

			System.out.println("E-mail incorrecto");
		}

		else {

			System.out.println("E-mail correcto");
		}

	}
}

class LongitudMailException extends Exception {

	public LongitudMailException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LongitudMailException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
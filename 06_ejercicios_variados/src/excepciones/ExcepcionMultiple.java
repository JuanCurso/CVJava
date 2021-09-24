package excepciones;

import javax.swing.JOptionPane;

public class ExcepcionMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			division();
		}
		
		catch (NumberFormatException e) {
			System.out.println("Debes introducir números!!");
			e.printStackTrace();
		}
		
		catch (ArithmeticException e) {
			System.out.println("No es posible la división por cero!!");
			e.printStackTrace();
		}
	}

	public static void division() {
		int num1=Integer.parseInt(JOptionPane.showInputDialog("Numerador: "));
		int num2=Integer.parseInt(JOptionPane.showInputDialog("Denominador: "));
		
		System.out.println("El resultado de dividir " + num1 + " entre " + num2 + " es " +
				num1/num2);
		
	}
}

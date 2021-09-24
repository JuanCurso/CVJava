package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UsoFinally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int figura=0;
		double area=0;
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Elige una opción:\n1: Cuadrado.\n2: Rectangulo.\n3: Triangulo.");
		
		try {
			figura=entrada.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("Ha ocurrido un error.");
		}
		
		finally {
			entrada.close();
		}
		
		switch (figura) {
			case 1:
				area=Math.pow(Integer.parseInt(JOptionPane.showInputDialog("Dime longitud lado:")),2);
				System.out.println("El área del cuadrado es: " + area);
				break;
			case 2:
				area=Integer.parseInt(JOptionPane.showInputDialog("Dime longitud base:")) *
						Integer.parseInt(JOptionPane.showInputDialog("Dime longitud altura:"));
				System.out.println("El área del rectángulo es: " + area);
				break;
				
			case 3:
				area=(Integer.parseInt(JOptionPane.showInputDialog("Dime longitud base:")) *
				Integer.parseInt(JOptionPane.showInputDialog("Dime longitud altura:"))) / 2;
				
				System.out.println("El área del triangulo es: " + area);
				break;
			default:
				System.out.println("Opción seleccionada incorrecta.");
				break;
		}
		

		//---------------------------------------------------------------------------------
		
		int altura=Integer.parseInt(JOptionPane.showInputDialog("Dime altura en cm."));
		
		System.out.println("El peso ideal si eres hombre es de " + (altura-110) + " kg.");
		System.out.println("El peso ideal si eres mujer es de " + (altura-120) + " kg.");
		
	}

}

import java.util.Scanner;

import javax.swing.JOptionPane;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if (Integer.parseInt("4")==Integer.valueOf("4")) {
			System.out.println("Iguales");
		}
		
		try {
			int i=Integer.valueOf(JOptionPane.showInputDialog("Dime el número 1:")) + 
				Integer.valueOf(JOptionPane.showInputDialog("Dime el número 2:"));
			
			System.out.println(i);
	}
		catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Introduce un número!!!", "Error",
						JOptionPane.ERROR_MESSAGE);
		}
		
		System.out.print("Dime tu nombre: ");

		System.out.println(new Scanner(System.in).nextLine());
	}

}

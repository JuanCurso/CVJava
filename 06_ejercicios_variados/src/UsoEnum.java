

import java.util.Scanner;


public class UsoEnum {
	
	enum Talla {
		PEQUEÑA('S'), MEDIANA('M'), GRANDE('X');
		
		private char abreviatura;
	
		Talla(char abreviatura) {
			this.abreviatura=abreviatura;
		}
		
		public char getAbreviatura() {
			return this.abreviatura;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		
		System.out.println("Dime talla");
		
		String myTalla=s.nextLine().toUpperCase();
		
		Talla t=Enum.valueOf(Talla.class, myTalla);
		
		System.out.println(t.getAbreviatura());

		Empleado e[]=new Empleado[2];
		
		e[0]=new Jefatura();
		e[1]=new Empleado();
		
		if (e[0] instanceof Jefatura) System.out.println("Guay");
		if (e[1] instanceof Jefatura) System.out.println("No Guay");

	}

}

class Empleado {
	
	
}


class Jefatura extends Empleado {
	
}
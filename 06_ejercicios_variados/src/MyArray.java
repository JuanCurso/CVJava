
public class MyArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double acumulado=10000;
		double interes=0.10;
		
		double saldo[][]=new double[6][5];
		
//		System.out.println(saldo.length);
//		System.out.println(+saldo[1].length);
		
		for (int i=0; i<saldo.length; i++) {
			saldo[i][0]=10000;
		}
		

		
		for (int i=0; i<saldo.length; i++) {
			for (int j=1; j<saldo[i].length; j++) {
				acumulado=acumulado+(acumulado*interes);
				saldo[i][j]=acumulado;
//				System.out.print("i="+i+" j="+j+" acumulado="+acumulado+" ");

			}
			
			acumulado=10000;
			interes+=0.01;
//			System.out.println("acumulado="+acumulado+" interes="+interes);
		}
		
		for (int i=0; i<saldo[i].length; i++) {

			System.out.println();

			for (int j=0; j<saldo.length; j++) {
				System.out.printf("%1.2f", saldo[j][i]);
				System.out.print(" ");
			}
		}
	}

}

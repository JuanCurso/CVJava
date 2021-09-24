package programaciongenerica;

public class MetodosGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] i = {1, 2, 3, -3};

		String[] s= {"Jose", "Juan", "Ana", "Maria", "Luis"};

		System.out.println(MiMatriz.getLongitud(i));

		System.out.println(MiMatriz.getLongitud(s));

		
		System.out.println(MiMatriz.getMenor(i));

		System.out.println(MiMatriz.getMenor(s));

	}
}


class MiMatriz {

	public static <T> String getLongitud(T[] m) {
		return "La matriz tiene una longitud de " + m.length;
	}
	
	public static <T extends Comparable> T getMenor(T[] a) {
		if (a==null || a.length==0) return null;
		
		T elemMenor = a[0];
		
		for (int i=1; i<a.length; i++) {
			if (elemMenor.compareTo(a[i])>0) elemMenor=a[i];
		}
		
		return elemMenor;
	}
}
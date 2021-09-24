package introspeccion;

import java.lang.reflect.*;
import java.util.Scanner;

public class InformacionClases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Introduce el nombre de la clase: ");
		
		String clase=entrada.nextLine();

//		String clase="java.lang.Boolean";
		
		Class c=null;
		try {
			c=Class.forName(clase);
			Class superC=c.getSuperclass();
			
			System.out.println("Clase " + clase);
			
			if(superC!=null && superC!=Object.class) {
				System.out.println("Hereda de " + superC.getName());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		imprimirConstructores(c);
		
		System.out.println();
		imprimirMetodos(c);
		
		System.out.println();
		imprimirCampos(c);
		

	}



	public static void imprimirConstructores(Class c) {
		
		Constructor[] constructores=c.getDeclaredConstructors();
		
		if (constructores.length>0)
			System.out.println("La clase tiene los siguientes constructores:");
		
		for (Constructor constructor : constructores) {
			
			StringBuilder cadena=new StringBuilder(Modifier.toString(constructor.getModifiers()));
			cadena.append(" ");
			cadena.append(InformacionClases.getClase(constructor.getName()));
			cadena.append("(");
			
			// obtener los parametros del constructor
			Class[] parametros=constructor.getParameterTypes();
//			Parameter[] parametro=constructor.getParameters();
			
			for (int i=0; i<parametros.length; i++) {
//				Type t=parametros[i].getParameterizedType();
//				cadena.append(InformacionClases.getClase(t.getTypeName()) + " " + parametros[i].getName());
				if (i>0)
					cadena.append(", ");

				cadena.append(InformacionClases.getClase(parametros[i].getName()));
			}
			
			cadena.append(")");
			
			
			System.out.println(cadena);
			
		}
		
	}
	
	public static void imprimirMetodos(Class c) {
		System.out.println("La clase tiene los siguientes métodos:");
		
		Method[] metodos=c.getDeclaredMethods();
		
		for (Method metodo : metodos) {
			StringBuilder cadena=new StringBuilder(Modifier.toString(metodo.getModifiers()));
					
			cadena.append(" ");
			cadena.append(InformacionClases.getClase(metodo.getReturnType().getName()));
			
			cadena.append(" ");
			cadena.append(metodo.getName());

			cadena.append("(");

			Class[] parametros=metodo.getParameterTypes();

			for (int i=0; i<parametros.length; i++) {
				if (i>0)
					cadena.append(", ");
			
				cadena.append(InformacionClases.getClase(parametros[i].getName()));
			}
			cadena.append(")");

			System.out.println(cadena);
		}
		
	}
	
	public static void imprimirCampos(Class c) {
		System.out.println("La clase tiene los siguientes atributos:");
		
		Field[] campos=c.getDeclaredFields();
		
		for (Field campo : campos) {
			StringBuilder cadena=new StringBuilder(Modifier.toString(campo.getModifiers()));
			
			cadena.append(" ");
			
			cadena.append(InformacionClases.getClase(campo.getType().getName()));
			
			cadena.append(" ");
			
			cadena.append(campo.getName());
			
			System.out.println(cadena);

		}
		

	}
	
	public static String getClase(String c) {
		
		return c.substring(c.lastIndexOf(".") + 1, c.length());
	}
}

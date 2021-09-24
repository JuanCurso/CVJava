package Eventos;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class Evento3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana3 miVentana1=new MiVentana3();
		MiVentana3 miVentana2=new MiVentana3();

		miVentana1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		miVentana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		miVentana1.setVisible(true);
		miVentana2.setVisible(true);

		EscribirConsola miConsola=new EscribirConsola();
		miVentana1.addWindowListener(miConsola);
		miVentana1.addWindowStateListener(miConsola);
		miVentana2.addWindowListener(miConsola);
		miVentana2.addWindowStateListener(miConsola);
		
	}
}

class MiVentana3 extends JFrame {
	
	public static int numVentanas=0;
	
	MiVentana3() {
		numVentanas++;
		
		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
//		this.setResizable(false);
		

	}
}

class EscribirConsola implements WindowListener, WindowStateListener {
	
	public void windowStateChanged(WindowEvent e) {
		System.out.println("CAMBIE DE ESTADO!!!!!!!");
		
		
		if (e.getNewState()==Frame.MAXIMIZED_BOTH) {
			System.out.println("Ventana maximizada!!!!");
		}
	}

	public void windowActivated(WindowEvent e) {
		System.out.println("Ventana activada");

	}
	
	public void windowClosed(WindowEvent e) {
		System.out.println("Ventana cerrada");
		
		MiVentana3.numVentanas--;
		
		if (MiVentana3.numVentanas==0) {
			System.exit(0);
		}
		else {
			MiVentana3 ventanaCerrar=(MiVentana3) e.getSource();
			ventanaCerrar.dispose();
		}
	}
	
	
	public void windowClosing(WindowEvent e) {
		System.out.println("Ventana cerrando");

	}
	
	
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Ventana desactivada");
	}
	
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Ventana maximizada");

	}
	
	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana minimizada");

	}
	
	public void windowOpened(WindowEvent e) {
		System.out.println("Ventana abierta");

	}
}
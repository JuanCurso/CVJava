package Eventos;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Evento4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana4 miVentana1=new MiVentana4();

		miVentana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana1.addKeyListener(new EscribirTeclaConsola());
		
	}

}

class MiVentana4 extends JFrame {
	
	MiVentana4() {
		
		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
//		this.setResizable(false);
		this.setVisible(true);
		

	}
}

class EscribirTeclaConsola implements KeyListener {
	
	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_NUM_LOCK) {
			System.out.println("Teclado numerico bloqueado");
		}
		//System.out.println(e.getKeyCode());

	}

	public void keyTyped(KeyEvent e) {


	}

}
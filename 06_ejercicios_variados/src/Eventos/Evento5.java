package Eventos;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Evento5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MiVentana5 miVentana1=new MiVentana5();

		miVentana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana1.addMouseListener(new EventosRaton());
		miVentana1.addMouseMotionListener(new EscribirCoordenadas());
		
	}

}

class MiVentana5 extends JFrame {
	
	MiVentana5() {
		
		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
//		this.setResizable(false);
		this.setVisible(true);
		

	}
}

class EventosRaton implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("He hecho click" + e.getButton());
		System.out.println("X= " + e.getX() + " Y= " + e.getY());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Boton apretado");
		if (e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK) {

			System.out.println("Boton derecho pulsado.");
		}
		else if (e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK) {
				System.out.println("Boton izquierdo pulsado.");
			}
			else {
				System.out.println("Otron boton pulsado");
			}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Boton soltado");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("He entrado en la ventana");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("He salido en la ventana");
	}
	
}

class EscribirCoordenadas implements MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		//System.out.println("X=" + e.getX() + " Y=" + e.getY());
	}
	


}
package Eventos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Evento2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana2 miVentana=new MiVentana2();
		
		miVentana.add(new MiPanel2());
	}

}

class MiVentana2 extends JFrame {
	MiVentana2() {
		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setResizable(false);
		this.setVisible(true);
		
	}
}

class MiPanel2 extends JPanel {
	
	private JButton jbRojo=new JButton("Rojo");
	private JButton jbVerde=new JButton("Verde");
	private JButton jbAzul=new JButton("Azul");

	
	MiPanel2() {
		add(jbRojo);
		add(jbVerde);
		add(jbAzul);
		

		jbRojo.addActionListener(new ColorFondo(Color.RED));
		jbVerde.addActionListener(new ColorFondo(Color.GREEN));
		jbAzul.addActionListener(new ColorFondo(Color.BLUE));
	}
	

		
	private class ColorFondo implements ActionListener {

		private Color colorFondo;
		ColorFondo(Color c) {
			colorFondo=c;
		}

		public void actionPerformed(ActionEvent e) {
				setBackground(colorFondo);
		}
	}
}

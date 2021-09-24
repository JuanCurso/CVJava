package Eventos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Evento8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana8 miVentana=new MiVentana8();

		miVentana.add(new MiPanel8());
	}

}

class MiVentana8 extends JFrame {
	MiVentana8() {
		this.setVisible(true);

		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setResizable(false);

	}
}

class MiPanel8 extends JPanel {

	private JButton jbCerrarTodo;


	MiPanel8() {

		JButton jbNuevo=new JButton("Nuevo");
		jbCerrarTodo=new JButton("Cerrar Todo");
		add(jbNuevo);
		add(jbCerrarTodo);

		OyenteNuevo miMarcoOyente=new OyenteNuevo();
		jbNuevo.addActionListener(miMarcoOyente);
	}

	private class OyenteNuevo implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

				new VentanaEmergente(jbCerrarTodo);
		}
	}

}

class VentanaEmergente extends JFrame {

	private static int contador=0;

	VentanaEmergente(JButton botonCerrar) {

		contador++;
		this.setTitle("Ventana " + contador);
		this.setBounds(40*contador, 40*contador, 400, 100);

		this.setVisible(true);

		
		botonCerrar.addActionListener(new OyenteCerrar());

	}

	private class OyenteCerrar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			dispose();
			contador=0;
		}

		/*	public void setContador0() {
		contador=0;
	}
		 */
	}
}


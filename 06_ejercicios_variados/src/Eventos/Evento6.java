package Eventos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Evento6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiVentana6 miVentana=new MiVentana6();
		
		miVentana.add(new MiPanel6());
		

	}

}

class MiVentana6 extends JFrame {
	MiVentana6 () {

		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setResizable(false);
		this.setVisible(true);

	}
}

class MiPanel6 extends JPanel {
	

	private JTextField jtNombre;
	private JTextField jtApellido;


	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		setLayout(null);

		jtNombre=new JTextField();
		jtApellido=new JTextField();
		
		jtNombre.setBounds(120, 10, 150, 20);
		jtApellido.setBounds(120, 50, 150, 20);

		add(jtNombre);
		add(jtApellido);
		
		jtNombre.addFocusListener(new ControlFoco());
//		jtApellido.addFocusListener(this);
	}

	private class ControlFoco implements FocusListener {
		
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
			jtNombre.setForeground(Color.BLACK);

			//		JTextField tmp= (JTextField) e.getSource();
			//		tmp.setText("foco ganado");
		}



		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub

			
			boolean error=false;
			String cadena=jtNombre.getText();
			System.out.println(cadena);

			char letra;
			int arroba=0;
			int punto=0;

			for (int i=0; i<cadena.length() && !error; i++) {
				letra=cadena.charAt(i);

				switch (letra) {

				case '@':
					arroba++;
					if (arroba>1) error=true;
					break;
				case '.':
					punto++;
					break;
				}
			}

			if (punto==0) error=true;

			if (error) {
//				jtNombre.setBackground(Color.RED);
//				jtNombre.setText(cadena);
				
				jtNombre.setForeground(Color.RED);
			}


			//		JTextField tmp= (JTextField) e.getSource();
			//		tmp.setText("foco perdido");
		}
	}
	
}

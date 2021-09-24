package Eventos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Evento1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana7 miVentana=new MiVentana7();
		
		miVentana.add(new MiPanel7());
	}

}

class MiVentana extends JFrame {
	MiVentana () {
		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setResizable(false);
		this.setVisible(true);
		
	}
}

class MiPanel extends JPanel implements ActionListener{
	
	private JButton jbRandom=new JButton("Random");
	private JButton jbRojo=new JButton("Rojo");
	private JButton jbVerde=new JButton("Verde");
	private JButton jbAzul=new JButton("Azul");

	
	MiPanel() {
		add(jbRandom);
		add(jbRojo);
		add(jbVerde);
		add(jbAzul);
		
		jbRandom.addActionListener(this);
		jbRojo.addActionListener(this);
		jbVerde.addActionListener(this);
		jbAzul.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(jbRandom)) {
			int r=(int)(Math.random()*255);
			int g=(int)(Math.random()*255);
			int b=(int)(Math.random()*255);

			System.out.println("r= "+r+" g= "+g+" b= "+b);
			this.setBackground(new Color(r,g,b));
		}
		else {
			if (e.getSource().equals(jbRojo)) {
				this.setBackground(Color.RED);
			}
			else {
				if (e.getSource().equals(jbVerde)) {
					this.setBackground(Color.GREEN);
				}
				else {
					this.setBackground(Color.BLUE);

				}
			}

		}
	}
}

package layouts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Layout1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana1 miVentana=new MiVentana1();

		miVentana.add(new MiPanel1_1(), BorderLayout.NORTH);
		miVentana.add(new MiPanel1_2(), BorderLayout.CENTER);
	}

}

class MiVentana1 extends JFrame {
	MiVentana1() {
		this.setVisible(true);

		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setResizable(false);

	}
}

class MiPanel1_1 extends JPanel {



	MiPanel1_1() {

		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		add(new JButton("Boton 1"));
		add(new JButton("Boton 2"));


	}

}

class MiPanel1_2 extends JPanel {



	MiPanel1_2() {

		this.setLayout(new BorderLayout(30, 30));
		add(new JButton("Boton 3"), BorderLayout.WEST);
		add(new JButton("Boton 4"), BorderLayout.CENTER);
		add(new JButton("Boton 5"), BorderLayout.EAST);

	}

}
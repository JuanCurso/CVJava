package componentes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class Compo9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiVentana9 miVentana=new MiVentana9();

		miVentana.setVisible(true);

	}

}

class MiVentana9 extends JFrame {
	MiVentana9 () {


		this.setTitle("Mi Ventanita");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(400, 300, 1000, 200);
		//		this.setResizable(false);

		MiPanel9 miPanel=new MiPanel9();
		
		this.add(miPanel);
	}
}

class MiPanel9 extends JPanel {
	
	public MiPanel9() {
		
		JButton boton1=new JButton("Boton 1");
		JButton boton2=new JButton("Boton 2");
		JButton boton3=new JButton("Boton 3");
		
		SpringLayout miLayout=new SpringLayout();
		Spring miSpring=Spring.constant(0, 10, 100);
		Spring miSpringRigido=Spring.constant(10);

		miLayout.putConstraint(SpringLayout.WEST, boton1, miSpring, SpringLayout.WEST, this);
		miLayout.putConstraint(SpringLayout.WEST, boton2, miSpringRigido, SpringLayout.EAST, boton1);
		miLayout.putConstraint(SpringLayout.WEST, boton3, miSpringRigido, SpringLayout.EAST, boton2);
		miLayout.putConstraint(SpringLayout.EAST, this, miSpring, SpringLayout.EAST, boton3);
		
		this.setLayout(miLayout);
		
		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		
	}
}




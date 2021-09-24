package componentes;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Compo10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiVentana10 miVentana=new MiVentana10();

		miVentana.setVisible(true);

	}

}

class MiVentana10 extends JFrame {
	MiVentana10 () {


		this.setTitle("Mi Ventanita");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(400, 300, 1000, 200);
		//		this.setResizable(false);

		MiPanel10 miPanel=new MiPanel10();
		
		this.add(miPanel);
	}
}

class MiPanel10 extends JPanel {
	
	public MiPanel10() {
		
		this.setLayout(new miLayout());
		JLabel jlNombre=new JLabel("Nombre: ");
		JLabel jlApellido=new JLabel("Apellido: ");
		
		JTextField jtfNombre=new JTextField(20);
		JTextField jtfApellido=new JTextField(20);
		

		this.add(jlNombre);
		this.add(jtfNombre);
		this.add(jlApellido);
		this.add(jtfApellido);

	}
}


class miLayout implements LayoutManager {

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layoutContainer(Container parent) {
		// TODO Auto-generated method stub
		
		int initx=(int)(parent.getWidth()/2)-100;
		x=initx;
		
		for (int i=0; i<parent.getComponentCount(); i++) {
			System.out.println("x=" + x + " y=" + y);

			Component c=parent.getComponent(i);
			
			c.setBounds(x, y, 100, 20);
			
			if (i%2==0) {
				x+=100;
			}
			else {
				x=initx;
				y+=40;
			}
			
		}
	}
	
	private int x=20;
	private int y=20;
}

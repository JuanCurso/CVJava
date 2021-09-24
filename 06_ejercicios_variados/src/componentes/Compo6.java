package componentes;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Compo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiVentana6 miVentana=new MiVentana6();

		miVentana.setVisible(true);

	}

}

class MiVentana6 extends JFrame {
	
	MiVentana6 () {


		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setResizable(false);
		
		MiLamina6 miLamina=new MiLamina6();
		
		this.add(miLamina);
		
	}
}

class MiLamina6 extends JPanel {
	
	public MiLamina6() {
		
		JSpinner miSpinner=new JSpinner(new SpinnerNumberModel(0, -10, 10, 2) {
			
			public Object getPreviousValue() {
				
				return super.getNextValue();
			}

			public Object getNextValue() {
				
				return super.getPreviousValue();
			}

		});
		
		miSpinner.setPreferredSize(new Dimension(50, 20));
		
		this.add(miSpinner);
		
	}
	
}


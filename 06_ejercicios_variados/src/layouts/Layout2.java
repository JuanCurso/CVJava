package layouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Layout2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana2 miVentana=new MiVentana2();

		miVentana.add(new MiPanel2_1());
	}

}

class MiVentana2 extends JFrame {
	MiVentana2() {
		this.setVisible(true);

		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setResizable(false);

	}
}

class MiPanel2_1 extends JPanel {

	private JPanel panel2_2;
	private JButton display;
	
	private boolean nuevoNum=true;

	private double operador=0;
	private char operacion='=';

	MiPanel2_1() {

		this.setLayout(new BorderLayout(20, 20));

		display=new JButton("0");
		display.setEnabled(false);
		display.setBackground(Color.WHITE);
		add(display, BorderLayout.NORTH);

		panel2_2=new JPanel();
		panel2_2.setLayout(new GridLayout(4, 4, 20, 20));

		ActionListener num=new NumeroCal();
		ActionListener ope=new OperacionCal();
		
		creaBoton("7", num);
		creaBoton("8", num);
		creaBoton("9", num);
		creaBoton("-", ope);
		creaBoton("4", num);
		creaBoton("5", num);
		creaBoton("6", num);
		creaBoton("+", ope);
		creaBoton("1", num);
		creaBoton("2", num);
		creaBoton("3", num);
		creaBoton("*", ope);
		creaBoton("0", num);
		creaBoton(".", num);
		creaBoton("=", ope);
		creaBoton("/", ope);

		add(panel2_2, BorderLayout.CENTER);
	}

	private void creaBoton(String s, ActionListener o) {

		JButton boton=new JButton(s);
		boton.addActionListener(o);
		panel2_2.add(boton);
	}

	class NumeroCal implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String cadDisplay=e.getActionCommand();
			
			if ((!nuevoNum || !cadDisplay.equals("0"))) {
				if (nuevoNum) {
	  				display.setText("");
	  				nuevoNum=false;
				}

				display.setText(display.getText() + cadDisplay);
			}
		}
	}

	class OperacionCal implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			nuevoNum=true;
			
			String cadena=e.getActionCommand();

			calcular();

			display.setText(String.valueOf(operador));
			operacion=cadena.charAt(0);

		}
		
		private void calcular() {
			switch (operacion) {
			case '+':
				operador+=Double.parseDouble(display.getText());
				break;
			case '-':
				operador-=Double.parseDouble(display.getText());
				break;
			case '*':
				operador*=Double.parseDouble(display.getText());
				break;
			case '/':
				operador/=Double.parseDouble(display.getText());
				break;
			case '=':
				operador=Double.parseDouble(display.getText());
				break;
			}
			
		}
		
	}

}
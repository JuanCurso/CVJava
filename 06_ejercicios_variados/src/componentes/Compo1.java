package componentes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class Compo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiVentana1 miVentana=new MiVentana1();

		miVentana.add(new MiPanel1());

		miVentana.setVisible(true);

	}

}

class MiVentana1 extends JFrame {
	MiVentana1 () {


		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setResizable(false);

	}
}

class MiPanel1 extends JPanel {


	private JTextField jtEMail;
	private JLabel jlResultado;
	private Document miDocumento;


	public MiPanel1() {
		setLayout(new BorderLayout());

		JPanel panel1_1=new JPanel();
		panel1_1.setLayout(new FlowLayout());

		JLabel jlEMail=new JLabel("E-Mail: ");
		panel1_1.add(jlEMail);

		jtEMail=new JTextField(20);
		miDocumento=jtEMail.getDocument();
		panel1_1.add(jtEMail);

		JButton jbComprobar=new JButton("Comprobar");
		panel1_1.add(jbComprobar);

		add(panel1_1, BorderLayout.NORTH);

		PanelResultado miResultado=new PanelResultado();

		jlResultado=new JLabel("", JLabel.CENTER);
		miResultado.add(jlResultado);
		miDocumento.addDocumentListener(miResultado);

		add(jlResultado, BorderLayout.CENTER);
	}

	private class PanelResultado extends JPanel implements DocumentListener {


		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			comprobarEMail();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			comprobarEMail();
		}

		private void comprobarEMail() {
			// TODO Auto-generated method stub

			boolean error=false;
			String cadena=jtEMail.getText();
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
				jlResultado.setText("Incorrecto");
			}
			else {
				jlResultado.setText("Correcto");
			}		
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub

		}
	}
}


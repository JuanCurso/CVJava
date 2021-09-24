package componentes;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Compo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiVentana2 miVentana=new MiVentana2();

		miVentana.add(new MiPanel2());

		miVentana.setVisible(true);

	}

}

class MiVentana2 extends JFrame {
	MiVentana2 () {


		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setResizable(false);

	}
}

class MiPanel2 extends JPanel {


	private JTextArea jtaDesc;

	public MiPanel2() {

		jtaDesc=new JTextArea(8, 20);
		JScrollPane miScroll=new JScrollPane(jtaDesc);
		
		jtaDesc.setLineWrap(true);
		JButton jbCapturar=new JButton("Capturar Texto");
		ConsolaTexto miConsolaTexto=new ConsolaTexto();
		
		jbCapturar.addActionListener(miConsolaTexto);
		
		add(miScroll);
		add(jbCapturar);
	}

	private class ConsolaTexto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			System.out.println(jtaDesc.getText());
		}
	}

}


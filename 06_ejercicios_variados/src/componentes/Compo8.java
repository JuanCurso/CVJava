package componentes;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Compo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiVentana8 miVentana=new MiVentana8();

		miVentana.setVisible(true);

	}

}

class MiVentana8 extends JFrame {
	MiVentana8 () {


		this.setTitle("Mi Ventanita");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(500, 400, 200, 200);
		//		this.setResizable(false);

		JLabel jlUsuario=new JLabel("Usuario: ");
		JTextField jtfUsuario=new JTextField(10);
		jtfUsuario.setMaximumSize(jtfUsuario.getPreferredSize());
		
		Box cajaH1=Box.createHorizontalBox();
		
		cajaH1.add(jlUsuario);
		cajaH1.add(Box.createHorizontalStrut(5));
		cajaH1.add(jtfUsuario);
		
		JLabel jlPassword=new JLabel("Password: ");
		JTextField jtfPassword=new JTextField(10);
		jtfPassword.setMaximumSize(jtfPassword.getPreferredSize());
		
		Box cajaH2=Box.createHorizontalBox();
		
		cajaH2.add(jlPassword);
		cajaH2.add(Box.createHorizontalStrut(5));
		cajaH2.add(jtfPassword);
		
		JButton jbAceptar=new JButton("Aceptar");
		JButton jbCancelar=new JButton("Cancelar");
		
		Box cajaH3=Box.createHorizontalBox();
		
		cajaH3.add(jbAceptar);
		cajaH3.add(Box.createGlue());
		cajaH3.add(jbCancelar);
		
		Box cajaV1=Box.createVerticalBox();
		cajaV1.add(cajaH1);
		cajaV1.add(cajaH2);
		cajaV1.add(cajaH3);
		
		add(cajaV1, BorderLayout.CENTER);
		
	}
}




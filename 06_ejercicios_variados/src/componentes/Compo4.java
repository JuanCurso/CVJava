package componentes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Compo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiVentana4 miVentana=new MiVentana4();

		miVentana.setVisible(true);

	}

}

class MiVentana4 extends JFrame {
	
	private JLabel miLabel;
	
	private JComboBox jcbFuentes;
	
	MiVentana4 () {


		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setResizable(false);
		
		this.setLayout(new BorderLayout());
		
		String fuentes[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		JPanel panelNorte=new JPanel();
		
		jcbFuentes=new JComboBox(fuentes);
		jcbFuentes.addItem("Sólo sé que no sé nada...");
		
		jcbFuentes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				miLabel.setFont(new Font(fuentes[jcbFuentes.getSelectedIndex()], Font.PLAIN, 36));
			}
			
		});
		
		panelNorte.add(jcbFuentes);
		
		JPanel panelSur=new JPanel();
		miLabel=new JLabel("Texto de prueba");
		miLabel.setFont(new Font(fuentes[0], Font.PLAIN, 36));

		panelSur.add(miLabel, BorderLayout.CENTER);
		
		this.add(panelNorte, BorderLayout.NORTH);
		this.add(panelSur, BorderLayout.CENTER);
	}		
	
}


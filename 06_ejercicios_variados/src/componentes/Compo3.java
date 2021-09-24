package componentes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class Compo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiVentana3 miVentana=new MiVentana3();

		miVentana.setVisible(true);

	}

}

class MiVentana3 extends JFrame {
	
	private int tipo=0;
	private int tamano=12;

	private JLabel miLabel;
	
	private JRadioButton jrbTam12;
	private JRadioButton jrbTam24;
	private JRadioButton jrbTam36;
	
	MiVentana3 () {


		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setResizable(false);
		
		this.setLayout(new BorderLayout());
		
		JPanel panelNorte=new JPanel();
		
		miLabel=new JLabel("Texto de prueba");
		miLabel.setFont(new Font("Courier", tipo, tamano));
		panelNorte.add(miLabel);
		
		this.add(panelNorte, BorderLayout.NORTH);
		
		JPanel panelSur=new JPanel();
		panelSur.setLayout(new GridLayout(1, 2));
		
		JPanel panelSur1=new JPanel();
		panelSur1.setBorder(new TitledBorder("Estilo"));
		
		JPanel panelSur2=new JPanel();
		panelSur2.setBorder(new TitledBorder("Tamaño"));

		panelSur.add(panelSur1);
		panelSur.add(panelSur2);
		
		
		
		JCheckBox jcbNegrita=new JCheckBox("Negrita");
		
		jcbNegrita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (jcbNegrita.isSelected())
					tipo+=Font.BOLD;
				else
					tipo-=Font.BOLD;
				
				System.out.println(tipo);
				miLabel.setFont(new Font("Courier", tipo , tamano));
			}
			
		});
		
		JCheckBox jcbCursiva=new JCheckBox("Cursiva");
		
		jcbCursiva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				

				if (jcbCursiva.isSelected())
					tipo+=Font.ITALIC;
				else
					tipo-=Font.ITALIC;
				
				System.out.println(tipo);
				miLabel.setFont(new Font("Courier", tipo , tamano));
			}
			
		});
		panelSur1.add(jcbNegrita);
		panelSur1.add(jcbCursiva);

		ButtonGroup miGrupo=new ButtonGroup();
		jrbTam12=new JRadioButton("12",true);
		jrbTam24=new JRadioButton("24",false);
		jrbTam36=new JRadioButton("36",false);
		
		miGrupo.add(jrbTam12);
		miGrupo.add(jrbTam24);
		miGrupo.add(jrbTam36);
		
		RadioAccion miRadioAccion=new RadioAccion();
		
		jrbTam12.addActionListener(miRadioAccion);
		jrbTam24.addActionListener(miRadioAccion);
		jrbTam36.addActionListener(miRadioAccion);
		
		panelSur2.add(jrbTam12);
		panelSur2.add(jrbTam24);
		panelSur2.add(jrbTam36);
		
		this.add(panelNorte, BorderLayout.NORTH);
		this.add(panelSur, BorderLayout.SOUTH);

	}
	
	private class RadioAccion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			tamano=Integer.parseInt(e.getActionCommand());
			miLabel.setFont(new Font("Courier", tipo, tamano));
		}
		
	}
}


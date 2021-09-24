package componentes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Compo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiVentana5 miVentana=new MiVentana5();

		miVentana.setVisible(true);

	}

}

class MiVentana5 extends JFrame {
	
	private int tipo=0;
	private int tamano=12;

	private JLabel miLabel;
	
	private JSlider miSlider;

	
	MiVentana5 () {


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

		miSlider=new JSlider(12,36,12);

		miSlider.setMajorTickSpacing(12);
		miSlider.setMinorTickSpacing(5);
		
		miSlider.setPaintTicks(true);
		
		miSlider.setFont(new Font("Sans", Font.ITALIC,10));
		miSlider.setPaintLabels(true);
		
		miSlider.setSnapToTicks(true);
		
		SliderAccion miSliderAccion=new SliderAccion();
		
		miSlider.addChangeListener(miSliderAccion);
		
		panelSur2.add(miSlider);

		
		this.add(panelNorte, BorderLayout.NORTH);
		this.add(panelSur, BorderLayout.SOUTH);

	}
	
	private class SliderAccion implements ChangeListener {



		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			tamano=miSlider.getValue();
			miLabel.setFont(new Font("Courier", tipo, tamano));
		}
		
	}
}


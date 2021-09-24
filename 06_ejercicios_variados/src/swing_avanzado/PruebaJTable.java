package swing_avanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PruebaJTable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana3 miVentana=new MiVentana3();

		miVentana.setVisible(true);
	}

}


class MiVentana3 extends JFrame {

	public MiVentana3 () {
		this.setBounds(400, 300, 400, 200);
		this.setTitle("Los Planetas");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTable miTabla=new JTable(filas, columnas);
		

		add(new JScrollPane(miTabla), BorderLayout.CENTER);
		
		JButton miBoton=new JButton("Imprimir");
		
		miBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					miTabla.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		add(miBoton, BorderLayout.SOUTH);

	}

	private String[] columnas= {"Nombre", "Radio", "Lunas", "Gaseoso"};

	private Object[][] filas= {
			{"Mercurio",2440.0,0,false},
			{"Venus",6052.0,0,false},
			{"Tierra",6378.0,1,false},
			{"Mate",3397.0,2,false},
			{"Jupiter",71492.0,0,true},
			{"Saturno",60268.0,0,true},
			{"Urano",25559.0,17,true},
			{"Neptuno",24766.0,8,true},
			{"Pluton",1137.0,1,false}
	};
}

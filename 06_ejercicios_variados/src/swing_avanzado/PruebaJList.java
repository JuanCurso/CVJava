package swing_avanzado;

import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PruebaJList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana1 miVentana=new MiVentana1();

		miVentana.setVisible(true);
	}

}


class MiVentana1 extends JFrame {

	public MiVentana1 () {
		this.setBounds(400, 300, 400, 300);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setResizable(false);

		String[] meses= {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", 
				"Septiembre", "Octubre", "Noviembre", "Diciembre"};

		jlMiLista=new JList<String>(meses);
		jlMiLista.setVisibleRowCount(4);
		
		jlMiLista.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				StringBuilder texto=new StringBuilder("Meses seleccionados: ");
				List<String> listaSeleccion=jlMiLista.getSelectedValuesList();
				
				Iterator seleccion=listaSeleccion.iterator();
				
				while (seleccion.hasNext()) {
					texto.append(seleccion.next());
					texto.append(" ");
				}
				
				jlMiLabel.setText(texto.toString());
			}
			
		});
		
		JScrollPane miScrollPane=new JScrollPane(jlMiLista);
		
		laminaNorte=new JPanel();
		laminaNorte.add(miScrollPane);
		
		jlMiLabel=new JLabel("Meses seleccionados: ");
		
		laminaCentro=new JPanel();
		laminaCentro.add(jlMiLabel);
		
		add(laminaNorte, BorderLayout.NORTH);
		add(laminaCentro, BorderLayout.CENTER);
		
		
	}

	private JList<String> jlMiLista;
	private JLabel jlMiLabel;
	private JPanel laminaNorte, laminaCentro;
}


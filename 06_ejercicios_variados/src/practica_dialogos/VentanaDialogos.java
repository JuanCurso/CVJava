package practica_dialogos;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VentanaDialogos extends JFrame {

	VentanaDialogos() {
		this.setBounds(400, 200, 600, 400);
		this.setTitle("Práctica Cuadro de Dialogos");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setResizable(false);
		

		JPanel panelCentro=new JPanel();
		panelCentro.setLayout(new GridLayout(2, 3));

		//FILA 1
		PanelRadio panelTipo=new PanelRadio();
		
		JRadioButton miRadioButton[][] = new JRadioButton[6][];
		String tipo[] = {"Mensaje", "Confirmar", "Opción", "Entrada"};

		PanelRadio panelTMensaje=new PanelRadio();
		String tMensaje[]= {"ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE",
				"QUESTION_MESSAGE", "PLAIN_MESSAGE"};

		PanelRadio panelMensaje=new PanelRadio();
		String mensaje[]= {"Cadena", "Icono", "Componente",	"Otros", "Object[]"};

		miRadioButton[0]=panelTipo.creaPanel("Tipo", tipo);
		miRadioButton[1]=panelTMensaje.creaPanel("Tipo de Mensaje", tMensaje);
		miRadioButton[2]=panelMensaje.creaPanel("Mensaje", mensaje);
		
		
		panelCentro.add(panelTipo);
		panelCentro.add(panelTMensaje);
		panelCentro.add(panelMensaje);
		
		//FILA 2
		PanelRadio panelConfirmar=new PanelRadio();
		String confirmar[] = {"DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"};

		PanelRadio panelOpcion=new PanelRadio();
		String opcion[]= {"String[]", "Icon[]", "Object[]"};

		PanelRadio panelEntrada=new PanelRadio();
		String entrada[]= {"Campo de texto", "Combo"};

		miRadioButton[3]=panelConfirmar.creaPanel("Confirmar", confirmar);
		miRadioButton[4]=panelOpcion.creaPanel("Opción", opcion);
		miRadioButton[5]=panelEntrada.creaPanel("Entrada", entrada);
		
		
		panelCentro.add(panelConfirmar);
		panelCentro.add(panelOpcion);
		panelCentro.add(panelEntrada);

		//BOTON
		JPanel panelSur=new JPanel();
		JButton jbMostrar=new JButton("Mostrar");
		
		AccionMostrar miMostrar = new AccionMostrar(miRadioButton);
		jbMostrar.addActionListener(miMostrar);
		
		panelSur.add(jbMostrar);
		
		this.add(panelCentro,BorderLayout.CENTER);
		this.add(panelSur, BorderLayout.SOUTH);
		//JPanel panelNorte=new JPanel();
	}
}

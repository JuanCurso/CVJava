

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AccionMostrar implements ActionListener {
	
	private JRadioButton[][] miRadioButton;
	
	private final String titulo;
	private final String cadena;
	private final ImageIcon icono;
	private final JPanel componente;
	private final Date fecha;
	private final String[] cadenaArray = {"Rojo", "Amarillo", "Azul"};
	private final ImageIcon[] iconoArray = {new ImageIcon("src/practica_dialogos/rojo.png"),
			new ImageIcon("src/practica_dialogos/amarillo.png"),
			new ImageIcon("src/practica_dialogos/azul.png")};

	private int tipoMensaje;
	private Object mensaje;
	
	AccionMostrar (JRadioButton[][] miRadioButton) {

		this.miRadioButton=miRadioButton;

		titulo = "Titulo";    
		cadena = "Mensajeeee";
		icono = new ImageIcon("src/practica_dialogos/azul.png");
		componente = new JPanel();
		componente.setBackground(Color.YELLOW);
		fecha = new Date();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		tipoMensaje=this.getTipoMensaje();
		mensaje=this.getMensaje();
		
		if (miRadioButton[0][0].isSelected()) {
			this.mensajePane(mensaje, titulo, tipoMensaje);
		}
		else {
			if (miRadioButton[0][1].isSelected()){
				this.confirmarPane(mensaje, titulo, this.getConfirmar(),tipoMensaje);

			}
			else {
				if (miRadioButton[0][2].isSelected()) {
					this.opcionPane(mensaje, titulo, tipoMensaje, this.getOpcion());
				}
				else {
					if (miRadioButton[5][0].isSelected())
						this.entradaPane(mensaje, titulo, tipoMensaje);
					else
						this.entradaPane(mensaje, titulo, tipoMensaje, cadenaArray);

				}

			}
		}
	}
	
	private void mensajePane(Object message, String title, int messageType) {
		JOptionPane.showMessageDialog(null, message, title, messageType);
	}
	
	private void confirmarPane(Object message, String title, int optionType, int messageType) {
		JOptionPane.showConfirmDialog(null, message, title, optionType, messageType);
	}
	
	private void opcionPane(Object message, String title, int messageType, Object[] options) {
		JOptionPane.showOptionDialog(null, message, title, 0, messageType, null,
				options, null);
	}
	
	private void entradaPane(Object message, String title, int messageType) {
		JOptionPane.showInputDialog(null, message, title, messageType);
	}
	
	private void entradaPane(Object message, String title, int messageType, Object[] selectionValues) {
		JOptionPane.showInputDialog(null, message, title, messageType, null, selectionValues, null);
	}
	
	private int getTipoMensaje() {
		
		switch (this.getBotonSelecionado(miRadioButton[1])) {
			case 0:
				return JOptionPane.ERROR_MESSAGE;
			case 1:
				return JOptionPane.INFORMATION_MESSAGE;
			case 2:
				return JOptionPane.WARNING_MESSAGE;
			case 3:
				return JOptionPane.QUESTION_MESSAGE;
			default:
				return JOptionPane.PLAIN_MESSAGE;
		}
	}

	private Object getMensaje() {

		Object[] objeto = {cadena, icono, componente, fecha};
		switch (this.getBotonSelecionado(miRadioButton[2])) {
		case 0:
			return cadena;
		case 1:
			return icono;
		case 2:
			return componente;
		case 3:
			return fecha;
		default:
			return objeto;
		}		
	}
	
	private int getConfirmar() {

		switch (this.getBotonSelecionado(miRadioButton[3])) {
		case 0:
			return JOptionPane.DEFAULT_OPTION;
		case 1:
			return JOptionPane.YES_NO_OPTION;
		case 2:
			return JOptionPane.YES_NO_CANCEL_OPTION;
		default:
			return JOptionPane.OK_CANCEL_OPTION;
	}
}	
	
	private Object[] getOpcion() {

		Object[] objeto = {cadena, icono, componente, fecha};

		switch (this.getBotonSelecionado(miRadioButton[4])) {
		case 0:
			return cadenaArray;
		case 1:
			return iconoArray;
		default:
			return objeto;
		}		
	}
	
	private int getBotonSelecionado(JRadioButton[] radio) {
		boolean noEncontrado=true;
		int contador=0;
		for (int i=0; i<radio.length && noEncontrado; i++) {
			if (radio[i].isSelected())
				noEncontrado=false;
			else
				contador++;
		}
		
		System.out.println(contador);
		
		return contador;
	}
}

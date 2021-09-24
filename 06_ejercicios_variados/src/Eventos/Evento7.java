package Eventos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;



public class Evento7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana7 miVentana=new MiVentana7();

		miVentana.add(new MiPanel7());

		miVentana.setVisible(true);

	}

}

class MiVentana7 extends JFrame {
	MiVentana7 () {

		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		this.setResizable(false);

	}
}

class MiPanel7 extends JPanel {


	MiPanel7() {
		
		AccionColor aRandom=new AccionColor("Random",new ImageIcon("src/Eventos/star0.png"),
				KeyEvent.VK_M, null);
		AccionColor aRojo=new AccionColor("Rojo",new ImageIcon("src/Eventos/star1.png"),
				KeyEvent.VK_R, Color.RED);
		AccionColor aVerde=new AccionColor("Verde",new ImageIcon("src/Eventos/star2.png"),
				KeyEvent.VK_V, Color.GREEN);
		AccionColor aAzul=new AccionColor("Azul",new ImageIcon("src/Eventos/star3.png"),
				KeyEvent.VK_A, Color.BLUE);
		
		InputMap mapaEntrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		KeyStroke teclaRandom=KeyStroke.getKeyStroke("M");
		mapaEntrada.put(teclaRandom, "teclaRandom");
		KeyStroke teclaRojo=KeyStroke.getKeyStroke("R");
		mapaEntrada.put(teclaRojo, "teclaRojo");
		KeyStroke teclaVerde=KeyStroke.getKeyStroke("V");
		mapaEntrada.put(teclaVerde, "teclaVerde");
		KeyStroke teclaAzul=KeyStroke.getKeyStroke("A");
		mapaEntrada.put(teclaAzul, "teclaAzul");
		
		ActionMap mapaRandom=getActionMap();
		
		mapaRandom.put("teclaRandom", aRandom);
		mapaRandom.put("teclaRojo", aRojo);
		mapaRandom.put("teclaVerde", aVerde);
		mapaRandom.put("teclaAzul", aAzul);
		

		JButton jbRandom=new JButton(aRandom);
		JButton jbRojo=new JButton(aRojo);
		JButton jbVerde=new JButton(aVerde);
		JButton jbAzul=new JButton(aAzul);
		
		add(jbRandom);
		add(jbRojo);
		add(jbVerde);
		add(jbAzul);

//		jbRandom.add(this);
//		jbRojo.addActionListener(this);
//		jbVerde.addActionListener(this);
//		jbAzul.addActionListener(this);
	}

	private class AccionColor extends AbstractAction {
		
		public AccionColor(String nom, Icon ico, int key, Color col) {
			this.putValue(Action.NAME, nom);
			this.putValue(Action.SMALL_ICON, ico);
			this.putValue(Action.SHORT_DESCRIPTION, "Cambia color del fondo a "+ nom);
			this.putValue(Action.MNEMONIC_KEY, key);
			this.putValue("colorFondo", col);
		}

		public void actionPerformed(ActionEvent e) {

			Color miColor=(Color)this.getValue("colorFondo");
			
			if (miColor==null) {
				int r=(int)(Math.random()*255);
				int g=(int)(Math.random()*255);
				int b=(int)(Math.random()*255);

				System.out.println("r= "+r+" g= "+g+" b= "+b);
				miColor=new Color(r,g,b);
			}

			setBackground(miColor);
			
			
			
//			if (e.getSource().equals(jbRandom)) {
//				int r=(int)(Math.random()*255);
//				int g=(int)(Math.random()*255);
//				int b=(int)(Math.random()*255);
//
//				System.out.println("r= "+r+" g= "+g+" b= "+b);
//				this.setBackground(new Color(r,g,b));
//			}
//			else {
//				if (e.getSource().equals(jbRojo)) {
//					this.setBackground(Color.RED);
//				}
//				else {
//					if (e.getSource().equals(jbVerde)) {
//						this.setBackground(Color.GREEN);
//					}
//					else {
//						this.setBackground(Color.BLUE);
//
//					}
//				}
//
//			}
		}
	}
}


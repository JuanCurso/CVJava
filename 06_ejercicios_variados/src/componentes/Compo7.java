package componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;



public class Compo7 {

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
		
		AccionColor aRandom=new AccionColor("Random",new ImageIcon("src/Eventos/star0.png"), null);
		AccionColor aRojo=new AccionColor("Rojo",new ImageIcon("src/Eventos/star1.png"), Color.RED);
		AccionColor aVerde=new AccionColor("Verde",new ImageIcon("src/Eventos/star2.png"), Color.GREEN);
		AccionColor aAzul=new AccionColor("Azul",new ImageIcon("src/Eventos/star3.png"), Color.BLUE);
		
		JMenu miMenu=new JMenu("Color");
		
		miMenu.add(aRandom);
		miMenu.add(aRojo);
		miMenu.add(aVerde);
		miMenu.add(aAzul);
		
		JMenuBar jmbColor=new JMenuBar();
		jmbColor.add(miMenu);
		
		this.add(jmbColor);

		//Barra de herramientas
		
		JToolBar jtbHerramienta=new JToolBar("Colores");
		
		jtbHerramienta.add(aRandom);
		jtbHerramienta.addSeparator();
		jtbHerramienta.add(aRojo);
		jtbHerramienta.add(aVerde);
		jtbHerramienta.add(aAzul);
		
		this.add(jtbHerramienta);
		
		
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
	}

	private class AccionColor extends AbstractAction {
		
		public AccionColor(String nom, Icon ico, Color col) {
			this.putValue(Action.NAME, nom);
			this.putValue(Action.SMALL_ICON, ico);
			this.putValue(Action.SHORT_DESCRIPTION, "Cambia color del fondo a "+ nom);
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
			
		}
	}
}


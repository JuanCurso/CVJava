package graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.*;

public class EscribirPanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fuentes[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for (String e:fuentes) {
			System.out.println(e);
		}
		
		
		MiVentana miVentana=new MiVentana();
		
		miVentana.add(new MiPanel(Color.CYAN, SystemColor.windowBorder));
	}

}

class MiVentana extends JFrame {
	MiVentana () {
		Dimension resolucion=Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(resolucion.width/4,resolucion.height/4,resolucion.width/2,resolucion.height/2);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setResizable(false);
		this.setVisible(true);
		
	}
}

class MiPanel extends JPanel {
	
	MiPanel(Color colorDelante, Color colorFondo) {
		this.setForeground(colorDelante);
		this.setBackground(colorFondo);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g;

		g2.setFont(new Font("Vivaldi",Font.BOLD,40));
		g2.drawString("Hola", 100, 100);
		g2.drawLine(75, 100, 145, 100);
		
		g2.draw(new Rectangle2D.Double(20, 20, 100, 50));
		g2.setPaint(Color.RED);
		g2.fill(new Ellipse2D.Double(20, 20, 100, 50));
		
		try {
			miImagen=ImageIO.read(new File("src/graficos/star0.png"));
		}
		catch (IOException e) {
			System.out.println("No veo la imagen.");
		}
		
		g.drawImage(miImagen, 0, 120, null);
		
		int imgAlto=miImagen.getHeight(null);
		int imgAncho=miImagen.getWidth(null);
		
		for (int i=0; i<300; i++) {
			for (int j=0; j<200; j++) {
				g.copyArea(0, 120, imgAncho, imgAlto,
						imgAncho*i, imgAlto*j);
			}
		}
	}
	
	private Image miImagen;
}
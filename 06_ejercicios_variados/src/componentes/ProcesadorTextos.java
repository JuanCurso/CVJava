package componentes;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ProcesadorTextos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FrameProce miVentana=new FrameProce();

		miVentana.setVisible(true);
	}

}

class FrameProce extends JFrame {

	FrameProce () {


		this.setBounds(500,200,500,400);
		this.setTitle("MiVentana");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setResizable(false);

		LaminaProce miLaminaPrincipal=new LaminaProce();

		this.add(miLaminaPrincipal);

	}
}

class LaminaProce extends JPanel {

	private JTextPane jtaTexto;
	
	private String fuente;
	private int estilo;
	private int tamano;

	LaminaProce() {

		fuente="Arial";
		estilo=Font.ITALIC;
		tamano=12;
		
		this.setLayout(new BorderLayout());

		JPanel laminaNorte=new JPanel();

		JMenuBar jmbMenuBar=new JMenuBar();
		
		JMenu jmMenu[]=new JMenu[4];
		jmMenu[0]=creaMenu(jmbMenuBar, "Fuente");
		jmMenu[1]=creaMenu(jmbMenuBar, "Estilo");
		jmMenu[2]=creaMenu(jmbMenuBar, "Tamaño");
		jmMenu[3]=creaMenu(jmbMenuBar, "Edición");

		
		FuenteAccion miFuenteOyente=new FuenteAccion();
		JMenuItem jmiFuente[]=new JMenuItem[3];
		jmiFuente[0]=creaMenu(jmMenu[0], "Arial", miFuenteOyente, null);
		jmiFuente[1]=creaMenu(jmMenu[0], "Courier", miFuenteOyente, null);
		jmiFuente[2]=creaMenu(jmMenu[0], "Verdana", miFuenteOyente, null);

		EstiloAccion miEstiloOyente=new EstiloAccion();
		JMenuItem jmiEstilo[]=new JMenuItem[2];
		jmiEstilo[0]=creaMenu(jmMenu[1], "Negrita", miEstiloOyente, "src/componentes/negrita.png");
		jmiEstilo[1]=creaMenu(jmMenu[1], "Cursiva", miEstiloOyente, "src/componentes/cursiva.png");
		
		TamanoAccion miTamanoOyente=new TamanoAccion();
		JMenuItem jmiTamano[]=new JMenuItem[4];
		jmiTamano[0]=creaMenu(jmMenu[2], "12", miTamanoOyente, null);
		jmiTamano[1]=creaMenu(jmMenu[2], "16", miTamanoOyente, null);
		jmiTamano[2]=creaMenu(jmMenu[2], "20", miTamanoOyente, null);
		jmiTamano[3]=creaMenu(jmMenu[2], "24", miTamanoOyente, null);

		JMenuItem jmiEdicion[]=new JMenuItem[3];
		jmiEdicion[0]=new JMenuItem("Cortar", new ImageIcon("src/componentes/cut.gif"));
		jmiEdicion[1]=new JMenuItem("Copiar", new ImageIcon("src/componentes/copy.gif"));
		jmiEdicion[2]=new JMenuItem("Pegar", new ImageIcon("src/componentes/paste.gif"));

		jmMenu[3].add(jmiEdicion[0]);
		jmMenu[3].add(jmiEdicion[1]);
		jmMenu[3].add(jmiEdicion[2]);
		jmMenu[3].addSeparator();
		
		JMenu jmSubmenuOpc=new JMenu("Opciones");
		jmMenu[3].add(jmSubmenuOpc);
		
		JMenuItem jmiOpc[]=new JMenuItem[2];
		jmiOpc[0]=new JMenuItem("Opción 1");
		jmiOpc[1]=new JMenuItem("Opción 2");
		
		jmSubmenuOpc.add(jmiOpc[0]);
		jmSubmenuOpc.add(jmiOpc[1]);
		
		laminaNorte.add(jmbMenuBar);

		JPanel laminaCentro=new JPanel();
		laminaCentro.setLayout(new BorderLayout());

		jtaTexto=new JTextPane();
		jtaTexto.setFont(new Font(fuente, estilo, tamano));
		//jtaTexto.setLineWrap(true);

		laminaCentro.add(jtaTexto);


		this.add(laminaNorte, BorderLayout.NORTH);
		this.add(laminaCentro, BorderLayout.CENTER);
		

	}

	private JMenu creaMenu(JMenuBar menubar, String cadena) {

		JMenu menu=new JMenu(cadena);
		menubar.add(menu);
		
		return menu;
	}

	private JMenuItem creaMenu(JMenu menu, String cadena, ActionListener oyente,String ico) {
		JMenuItem menuItem=new JMenuItem(cadena,new ImageIcon(ico));
		menuItem.addActionListener(oyente);
		menu.add(menuItem);
		
		return menuItem;
	}
	
	private class FuenteAccion implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			fuente=e.getActionCommand();
			jtaTexto.setFont(new Font(fuente, estilo, tamano));		}
	}
	
	private class EstiloAccion implements ActionListener {

		private TratarEstilo miEstilo;
		EstiloAccion() {
			miEstilo=new TratarEstilo();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String estiloSeleccionado=e.getActionCommand();
			int nuevoEstilo;
			
			if (estiloSeleccionado.equals("Negrita")) {
				nuevoEstilo=miEstilo.setEstilo(Font.BOLD);
			}
			else {
				nuevoEstilo=miEstilo.setEstilo(Font.ITALIC);
			}
			
			estilo=nuevoEstilo;
			jtaTexto.setFont(new Font(fuente, estilo, tamano));
		}
	}
	
	private class TratarEstilo {

		private int estiloTratado;
		private boolean isNegrita;
		private boolean isCursiva;
		
		public TratarEstilo() {
			estiloTratado=estilo;
			
			isNegrita=(estilo==Font.BOLD || estilo==(Font.BOLD + Font.ITALIC));
			isCursiva=(estilo==Font.ITALIC || estilo==(Font.BOLD + Font.ITALIC));

		}
		public int setEstilo(int s) {
			
			if (s==Font.BOLD) {
				if (isNegrita) {
					isNegrita=false;
					estiloTratado-=Font.BOLD;
				}
				else {
					isNegrita=true;
					estiloTratado+=Font.BOLD;
				}
			}
			else {
				if (isCursiva) {
					isCursiva=false;
					estiloTratado-=Font.ITALIC;
				}
				else {
					isCursiva=true;
					estiloTratado+=Font.ITALIC;
				}
			}
			
			return estiloTratado;
		}
	}
	
	private class TamanoAccion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			tamano=Integer.parseInt(e.getActionCommand());
			jtaTexto.setFont(new Font(fuente, estilo, tamano));
		}
	}
}

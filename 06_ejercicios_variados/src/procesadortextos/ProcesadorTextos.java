package procesadortextos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.StyledTextAction;

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
		estilo=Font.PLAIN;
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

		//MENU ESTILO
		JCheckBoxMenuItem jmiEstilo[]=new JCheckBoxMenuItem[2];
		jmiEstilo[0]=new JCheckBoxMenuItem("Negrita", new ImageIcon("src/componentes/cut.gif"));
		jmiEstilo[1]=new JCheckBoxMenuItem("Cursiva", new ImageIcon("src/componentes/cut.gif"));
		
		jmiEstilo[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		jmiEstilo[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		
		jmiEstilo[0].addActionListener(new StyledEditorKit.BoldAction());
		jmiEstilo[1].addActionListener(new StyledEditorKit.ItalicAction());
		
		jmMenu[1].add(jmiEstilo[0]);
		jmMenu[1].add(jmiEstilo[1]);
		
		
		//MENU TAMAÑO
		ButtonGroup bgTamano=new ButtonGroup();
		JMenuItem jmiTamano[]=new JMenuItem[4];
		jmiTamano[0]=new JRadioButtonMenuItem("12", true);
		jmiTamano[1]=new JRadioButtonMenuItem("16");
		jmiTamano[2]=new JRadioButtonMenuItem("20");
		jmiTamano[3]=new JRadioButtonMenuItem("24");
		
		bgTamano.add(jmiTamano[0]);
		bgTamano.add(jmiTamano[1]);
		bgTamano.add(jmiTamano[2]);
		bgTamano.add(jmiTamano[3]);
		
		jmiTamano[0].addActionListener(new StyledEditorKit.FontSizeAction(null, 12));
		jmiTamano[1].addActionListener(new StyledEditorKit.FontSizeAction(null, 16));
		jmiTamano[2].addActionListener(new StyledEditorKit.FontSizeAction(null, 20));
		jmiTamano[3].addActionListener(new StyledEditorKit.FontSizeAction(null, 24));
		
		jmMenu[2].add(jmiTamano[0]);
		jmMenu[2].add(jmiTamano[1]);
		jmMenu[2].add(jmiTamano[2]);
		jmMenu[2].add(jmiTamano[3]);
		
		//MENU EDICION
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

		//POPUP MENU
		JPopupMenu miPopup=new JPopupMenu();
		JMenuItem popEstilo[]=new JMenuItem[2];
		
		popEstilo[0]=new JMenuItem("Negrita");
		popEstilo[1]=new JMenuItem("Cursiva");

		popEstilo[0].addActionListener(new StyledEditorKit.BoldAction());
		popEstilo[1].addActionListener(new StyledEditorKit.ItalicAction());

		miPopup.add(popEstilo[0]);
		miPopup.add(popEstilo[1]);
		
		jtaTexto.setComponentPopupMenu(miPopup);
		
		//Barra de Herramientas
		JToolBar jtbEstilo=new JToolBar(SwingConstants.VERTICAL);
		
		this.creaToolBar(jtbEstilo, "negrita", new StyledEditorKit.BoldAction());
		this.creaToolBar(jtbEstilo, "cursiva", new StyledEditorKit.ItalicAction());
		this.creaToolBar(jtbEstilo, "underline", new StyledEditorKit.UnderlineAction());
		
		jtbEstilo.addSeparator();
		
		this.creaToolBar(jtbEstilo, "rojo", new StyledEditorKit.ForegroundAction(null, Color.RED));
		this.creaToolBar(jtbEstilo, "azul", new StyledEditorKit.ForegroundAction(null, Color.BLUE));
		this.creaToolBar(jtbEstilo, "amarillo", new StyledEditorKit.ForegroundAction(null, Color.YELLOW));

		jtbEstilo.addSeparator();
		
		this.creaToolBar(jtbEstilo, "izquierda", new StyledEditorKit.AlignmentAction(null, 0));
		this.creaToolBar(jtbEstilo, "derecha", new StyledEditorKit.AlignmentAction(null, 2));
		this.creaToolBar(jtbEstilo, "centrado", new StyledEditorKit.AlignmentAction(null, 1));
		this.creaToolBar(jtbEstilo, "justificado", new StyledEditorKit.AlignmentAction(null, 3));

		
/*		JButton jbNegrita=new JButton(new ImageIcon("src/componentes/negrita.png"));
		JButton jbCursiva=new JButton(new ImageIcon("src/componentes/cursiva.png"));
		JButton jbUnderline=new JButton(new ImageIcon("src/componentes/underline.png"));
		
		jbNegrita.addActionListener(new StyledEditorKit.BoldAction());
		jbCursiva.addActionListener(new StyledEditorKit.ItalicAction());
		jbUnderline.addActionListener(new StyledEditorKit.UnderlineAction());
		
		jtbEstilo.add(jbNegrita);
		jtbEstilo.add(jbCursiva);
		jtbEstilo.add(jbUnderline); */
		
		this.add(jtbEstilo, BorderLayout.WEST);
		

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
	
	private void creaToolBar(JToolBar barra, String nom, StyledTextAction kit) {
		JButton boton=new JButton(new ImageIcon("src/componentes/" + nom + ".png"));
		boton.addActionListener((StyledTextAction) kit);
		barra.add(boton);

	}
	
	private class FuenteAccion implements ActionListener {


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			fuente=e.getActionCommand();
			jtaTexto.setFont(new Font(fuente, estilo, tamano));		}
	}
	
}

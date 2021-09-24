package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controlador.CCargaMenusPracticaGuiadaJDBC;
import controlador.CRealizaConsultaPracticaGuiadaJDBC;


public class VMarcoPracticaGuiadaJDBC extends JFrame {
	
	public JComboBox secciones;
	
	public JComboBox paises;
	
	public JTextArea resultado;	
	
	public VMarcoPracticaGuiadaJDBC(){

		setTitle ("Consulta BBDD MVC");

		setBounds(500,300,400,400);

		setLayout(new BorderLayout());

		JPanel menus=new JPanel();

		menus.setLayout(new FlowLayout());

		//--------------------------------------------------------------
		secciones=new JComboBox();

		secciones.setEditable(false);

		secciones.addItem("Todos");


		paises=new JComboBox();

		paises.setEditable(false);

		paises.addItem("Todos");


		resultado= new JTextArea(4,50);

		resultado.setEditable(false);

		add(resultado);

		menus.add(secciones);

		menus.add(paises);	

		add(menus, BorderLayout.NORTH);

		add(resultado, BorderLayout.CENTER);

		JButton botonConsulta=new JButton("Consulta");	

		botonConsulta.addActionListener(new CRealizaConsultaPracticaGuiadaJDBC(this));
		add(botonConsulta, BorderLayout.SOUTH);
		
		addWindowListener(new CCargaMenusPracticaGuiadaJDBC(this));

	}

}

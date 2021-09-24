package bbdd_jdbc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class PracticaGuiada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());

		//--------------------------------------------------------------
		secciones=new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		//---------CONEXIÓN CON BBDD------------------------
		
		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_sql", "root", "");
			Statement miStatement=miConexion.createStatement();
			
			ResultSet miResultSet=miStatement.executeQuery("SELECT DISTINCT SECCIÓN FROM PRODUCTOS");
			
			while (miResultSet.next()) {
				secciones.addItem(miResultSet.getString("SECCIÓN"));

			}
			
			miResultSet.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//---------FIN-CONEXIÓN CON BBDD---------------------
		//----------------------------------------------------------------------
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		//---------CONEXIÓN CON BBDD------------------------
		
		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_sql", "root", "");
			Statement miStatement=miConexion.createStatement();
			
			ResultSet miResultSet=miStatement.executeQuery("SELECT DISTINCT PAÍSDEORIGEN FROM PRODUCTOS");
			
			while (miResultSet.next()) {
				paises.addItem(miResultSet.getString("PAÍSDEORIGEN"));

			}
			
			miResultSet.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//---------FIN-CONEXIÓN CON BBDD---------------------
		//----------------------------------------------------------------------
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
		
		botonConsulta.addActionListener(new EjecutarConsulta());
		add(botonConsulta, BorderLayout.SOUTH);
		
		//-----------CONEXIÓN CON BBDD---------------------

		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_sql", "root", "");
			miPreparedStatement=miConexion.prepareStatement("SELECT NOMBREARTÍCULO, SECCIÓN, " +
					"PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN LIKE ? AND PAÍSDEORIGEN LIKE ?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//---------FIN-CONEXIÓN CON BBDD---------------------
		
	}	
		
	private class EjecutarConsulta implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			resultado.setText("");
			
			String miSeccion=(String)secciones.getSelectedItem();
			if (miSeccion.equals("Todos")) miSeccion="%";
			
			String miPais=(String)paises.getSelectedItem();
			if (miPais.equals("Todos")) miPais="%";
			
			
			try {
				miPreparedStatement.setString(1, miSeccion);
				miPreparedStatement.setString(2, miPais);
				
				ResultSet miResultSet=miPreparedStatement.executeQuery();
				
				while (miResultSet.next()) {
					
				resultado.append(miResultSet.getString("NOMBREARTÍCULO") + " " +
							miResultSet.getString("SECCIÓN") + " " +
							miResultSet.getString("PAÍSDEORIGEN") + "\n");
				

				}
				
				miResultSet.close();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	private JComboBox secciones;
	
	private JComboBox paises;
	
	private JTextArea resultado;	
	
	private PreparedStatement miPreparedStatement;
	
}



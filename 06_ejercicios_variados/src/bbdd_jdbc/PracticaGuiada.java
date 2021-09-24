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
		
		//---------CONEXI�N CON BBDD------------------------
		
		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_sql", "root", "");
			Statement miStatement=miConexion.createStatement();
			
			ResultSet miResultSet=miStatement.executeQuery("SELECT DISTINCT SECCI�N FROM PRODUCTOS");
			
			while (miResultSet.next()) {
				secciones.addItem(miResultSet.getString("SECCI�N"));

			}
			
			miResultSet.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//---------FIN-CONEXI�N CON BBDD---------------------
		//----------------------------------------------------------------------
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		//---------CONEXI�N CON BBDD------------------------
		
		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_sql", "root", "");
			Statement miStatement=miConexion.createStatement();
			
			ResultSet miResultSet=miStatement.executeQuery("SELECT DISTINCT PA�SDEORIGEN FROM PRODUCTOS");
			
			while (miResultSet.next()) {
				paises.addItem(miResultSet.getString("PA�SDEORIGEN"));

			}
			
			miResultSet.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//---------FIN-CONEXI�N CON BBDD---------------------
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
		
		//-----------CONEXI�N CON BBDD---------------------

		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_sql", "root", "");
			miPreparedStatement=miConexion.prepareStatement("SELECT NOMBREART�CULO, SECCI�N, " +
					"PA�SDEORIGEN FROM PRODUCTOS WHERE SECCI�N LIKE ? AND PA�SDEORIGEN LIKE ?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//---------FIN-CONEXI�N CON BBDD---------------------
		
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
					
				resultado.append(miResultSet.getString("NOMBREART�CULO") + " " +
							miResultSet.getString("SECCI�N") + " " +
							miResultSet.getString("PA�SDEORIGEN") + "\n");
				

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



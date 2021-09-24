package bbdd_jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ProcedAlmacenados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			int precio=Integer.parseInt(JOptionPane.showInputDialog("Dime el precio"));
			String articulo=JOptionPane.showInputDialog("Dime el nombre del Articulo");
			
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/pruebas", "root", "");
			
			CallableStatement miSentencia=miConexion.prepareCall("{call ACTUALIZA_PROD(?, ?)}");
			
			miSentencia.setInt(1, precio);
			miSentencia.setString(2, articulo);
			
			miSentencia.execute();
			
			
/*			ResultSet rs=miSentencia.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " ");
			}

			rs.close();*/
			miSentencia.close();
			miConexion.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

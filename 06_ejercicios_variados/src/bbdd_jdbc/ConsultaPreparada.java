package bbdd_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaPreparada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_sql", "root", "");
			PreparedStatement miStatement=miConexion.prepareStatement("SELECT * FROM PRODUCTOS WHERE SECCI�N=? AND PA�SDEORIGEN=?");
			
			miStatement.setString(1, "CONFECCI�N");
			miStatement.setString(2, "ITALIA");
			
			ResultSet miResultSet=miStatement.executeQuery();
			
			while (miResultSet.next()) {
				
			System.out.println(miResultSet.getString("C�DIGOART�CULO") + " " +
						miResultSet.getString("NOMBREART�CULO") + " " +
						miResultSet.getDate("FECHA"));
			}
			
			miStatement.setString(1, "CONFECCI�N");
			miStatement.setString(2, "ESPA�A");
			
			miResultSet=miStatement.executeQuery();
			
			while (miResultSet.next()) {
				
			System.out.println(miResultSet.getString("C�DIGOART�CULO") + " " +
						miResultSet.getString("NOMBREART�CULO") + " " +
						miResultSet.getDate("FECHA"));
			

			}
			
			miResultSet.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package bbdd_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_sql", "root", "");
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultSet=miStatement.executeQuery("SELECT * FROM PRODUCTOS");
			
			while (miResultSet.next()) {
				
				if (!miResultSet.isLast())	System.out.println(miResultSet.getString("CÓDIGOARTÍCULO") + " " +
						miResultSet.getString("NOMBREARTÍCULO") + " " +
						miResultSet.getDate("FECHA"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MConexionPracticaGuiadaJDBC {

	private Connection miConexion;
	
	public Connection dameConexion() {
		try {
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_sql?serverTimezone=UTC", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return miConexion;
	}
}

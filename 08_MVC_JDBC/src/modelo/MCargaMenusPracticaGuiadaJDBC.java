package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MCargaMenusPracticaGuiadaJDBC {

	private Statement miStatement;

	public MCargaMenusPracticaGuiadaJDBC() {
		MConexionPracticaGuiadaJDBC miConexion=new MConexionPracticaGuiadaJDBC();
		Connection accesoBBDD=miConexion.dameConexion();
		try {
			miStatement=accesoBBDD.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public ResultSet consultaSecciones() {


		try {
			return miStatement.executeQuery("SELECT DISTINCT SECCIÓN FROM PRODUCTOS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public ResultSet consultaPaises() {


		try {
			return miStatement.executeQuery("SELECT DISTINCT PAÍSDEORIGEN FROM PRODUCTOS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}

package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MRealizaConsultaPracticaGuiadaJDBC {

	private PreparedStatement miPreparedStatement;

	public MRealizaConsultaPracticaGuiadaJDBC() {
		MConexionPracticaGuiadaJDBC miConexion=new MConexionPracticaGuiadaJDBC();
		Connection accesoBBDD=miConexion.dameConexion();
		try {
			miPreparedStatement=accesoBBDD.prepareStatement("SELECT NOMBREARTÍCULO, SECCIÓN, " +
					"PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN LIKE ? AND PAÍSDEORIGEN LIKE ?");		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public ResultSet realizaConsulta(String seccion, String paises) {
		try {
			miPreparedStatement.setString(1, seccion);
			miPreparedStatement.setString(2, paises);

			return miPreparedStatement.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

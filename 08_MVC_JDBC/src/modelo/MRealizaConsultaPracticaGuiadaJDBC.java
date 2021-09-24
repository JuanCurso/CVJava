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
			miPreparedStatement=accesoBBDD.prepareStatement("SELECT NOMBREART�CULO, SECCI�N, " +
					"PA�SDEORIGEN FROM PRODUCTOS WHERE SECCI�N LIKE ? AND PA�SDEORIGEN LIKE ?");		} catch (SQLException e) {
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

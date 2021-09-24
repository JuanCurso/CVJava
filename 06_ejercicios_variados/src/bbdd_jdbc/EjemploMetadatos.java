package bbdd_jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemploMetadatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection miConexion=null;
		ResultSet rs=null;
		
		try {
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/pruebas", "root", "");
			
			DatabaseMetaData miMetaData=miConexion.getMetaData();
			
/*			// MUESTRA INFORMACION DEL GESTOR DE LA BBDD
			System.out.println(miMetaData.getDatabaseProductName());
			System.out.println(miMetaData.getDatabaseProductVersion());
			
			System.out.println(miMetaData.getDriverName());
			System.out.println(miMetaData.getDriverVersion());
			
			// MUESTRA INFORMACION DE LAS TABLAS
			rs=miMetaData.getTables("pruebas", null, null, null);
			
			while (rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}
*/			
			rs=miMetaData.getColumns("pruebas", null, "clientes", null);
			
			while (rs.next()) {
				System.out.println(rs.getString("COLUMN_NAME"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

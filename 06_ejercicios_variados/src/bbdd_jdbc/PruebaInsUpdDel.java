package bbdd_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaInsUpdDel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection miConexion;
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/curso_sql", "root", "");
			Statement miStatement=miConexion.createStatement();

//			String sentenciaSQL="INSERT INTO PRODUCTOS (C�DIGOART�CULO,NOMBREART�CULO,PRECIO) VALUES('AR77','PANTALON',25.35)";
//			String sentenciaSQL="UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE C�DIGOART�CULO='AR77'";
			String sentenciaSQL="DELETE FROM PRODUCTOS WHERE C�DIGOART�CULO='AR77'";

			miStatement.executeUpdate(sentenciaSQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

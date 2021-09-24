package bbdd_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserta_Clientes_Pedidos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		Connection miConexion=null;
		try{					
				
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3308/pruebas", "root", "");				
			
			miConexion.setAutoCommit(false);
			
			Statement miStatement =miConexion.createStatement();
			
		    String instruccionSql_1="INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";
			    
		    miStatement.executeUpdate(instruccionSql_1);
			    
		    String instruccionSql_2="INSERT INTO PEDIDOS (NÚMERODEPEDIDO, CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";
			    
		    miStatement.executeUpdate(instruccionSql_2);
		    				    
		    miConexion.commit();
		    System.out.println("Datos INSERTADOS correctamente");
				
		}catch(Exception e){
				
			try {
				miConexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
				
			
			e.printStackTrace();	
				
				
			}

		}

	}

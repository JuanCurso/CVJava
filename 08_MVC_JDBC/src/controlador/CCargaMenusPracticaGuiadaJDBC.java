package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.MCargaMenusPracticaGuiadaJDBC;
import vista.VMarcoPracticaGuiadaJDBC;

public class CCargaMenusPracticaGuiadaJDBC extends WindowAdapter {
	
	public CCargaMenusPracticaGuiadaJDBC(VMarcoPracticaGuiadaJDBC miMarco) {
		super();
		this.miMarco = miMarco;
	}
	
	public void windowOpened(WindowEvent e) {
		
		MCargaMenusPracticaGuiadaJDBC miCargaMenuss=new MCargaMenusPracticaGuiadaJDBC();
		
		ResultSet miResultSet= miCargaMenuss.consultaSecciones();
		
		try {
			while (miResultSet.next()) {
				miMarco.secciones.addItem(miResultSet.getString("SECCIÓN"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		miResultSet= miCargaMenuss.consultaPaises();
		
		try {
			while (miResultSet.next()) {
				miMarco.paises.addItem(miResultSet.getString("PAÍSDEORIGEN"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			miResultSet.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}



	private VMarcoPracticaGuiadaJDBC miMarco;
}

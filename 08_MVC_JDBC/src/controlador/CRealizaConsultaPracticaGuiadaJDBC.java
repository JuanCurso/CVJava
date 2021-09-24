package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.MRealizaConsultaPracticaGuiadaJDBC;
import vista.VMarcoPracticaGuiadaJDBC;

public class CRealizaConsultaPracticaGuiadaJDBC implements ActionListener {

	private VMarcoPracticaGuiadaJDBC miMarco;
	private MRealizaConsultaPracticaGuiadaJDBC miConsulta;

	public CRealizaConsultaPracticaGuiadaJDBC(VMarcoPracticaGuiadaJDBC miMarco) {
		super();
		this.miMarco = miMarco;
		miConsulta=new MRealizaConsultaPracticaGuiadaJDBC();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		miMarco.resultado.setText("");

		String miSeccion=(String)miMarco.secciones.getSelectedItem();
		if (miSeccion.equals("Todos")) miSeccion="%";
		
		String miPais=(String)miMarco.paises.getSelectedItem();
		if (miPais.equals("Todos")) miPais="%";
		
		ResultSet miResultSet=miConsulta.realizaConsulta(miSeccion, miPais);
		
		try {
			while (miResultSet.next()) {
				
			miMarco.resultado.append(miResultSet.getString("NOMBREARTÍCULO") + " " +
						miResultSet.getString("SECCIÓN") + " " +
						miResultSet.getString("PAÍSDEORIGEN") + "\n");
			

			}
			
			miResultSet.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}

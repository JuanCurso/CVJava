package swing_avanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;




public class AplicacionUniversalJTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoBBDD mimarco=new MarcoBBDD();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mimarco.setVisible(true);

	}

}

class MarcoBBDD extends JFrame{

	public MarcoBBDD(){

		setBounds(400,50,700,700);

		LaminaBBDD milamina=new LaminaBBDD(this);

		add(milamina);


	}	

}

class LaminaBBDD extends JPanel{

	public LaminaBBDD(MarcoBBDD miMarco){

		setLayout(new BorderLayout());

		comboTablas=new JComboBox();

		comboTablas.addActionListener(new ConsultaTabla());

		miScrollTabla=new JScrollPane();

		add(comboTablas, BorderLayout.NORTH);
		
		add(miScrollTabla,BorderLayout.CENTER);		


		miMarco.addWindowListener(new CargarDatosIniciales());


	}

	private class CargarDatosIniciales extends WindowAdapter {

		public void windowOpened(WindowEvent e) {

			conexionBBDD(leerConfiguracion());

			rellenaComboBox();

		}

		//------------LEE CONFIGURACION DEL FICHERO----------------------
		private String[] leerConfiguracion() {

			String nombreFichero="src/swing_avanzado/configuracion.txt";
			String[] conexion=new String[3];
			FileReader miFichero=null;
			try {

				miFichero=new FileReader(new File(nombreFichero));

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(LaminaBBDD.this, "No he encontrado el fichero");

				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"Archivo de texto", "txt");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(LaminaBBDD.this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					nombreFichero=chooser.getSelectedFile().getAbsolutePath();
				}
			}

			try {
				miFichero=new FileReader(new File(nombreFichero));

				BufferedReader miBuffer = new BufferedReader(miFichero);

				conexion[0]=miBuffer.readLine();
				conexion[1]=miBuffer.readLine();
				conexion[2]=miBuffer.readLine();

				miBuffer.close();
				miFichero.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			return conexion;
		}

		//-------------FIN--LEE CONFIGURACION DEL FICHERO----------------------

		//-------------REALIZA CONEXION CON BBDD--------------------------

		private void conexionBBDD(String[] s) {
			try {
				miConexion=DriverManager.getConnection(s[0], s[1], s[2]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//-------------FIN-REALIZA CONEXION CON BBDD--------------------------

		//-------------RELLENA EL COMBOBOX CON LAS TABLAS---------------------

		private void rellenaComboBox() {
			try {
				DatabaseMetaData miMetaData=miConexion.getMetaData();

				ResultSet rs=miMetaData.getTables(miConexion.getCatalog(), null, null, null);

				while (rs.next()) {
					comboTablas.addItem(rs.getString("TABLE_NAME"));
				}

				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//-------------FIN-RELLENA EL COMBOBOX CON LAS TABLAS---------------------

		//-------------CIERRA LA CONEXION AL SALIR DE LA APLICACION----------------

		public void windowClosing(WindowEvent e) {
			try {
				miConexion.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				System.out.println("Adios!!!!!!!");
				System.exit(0);
			}

		}
		//-------------FIN-CIERRA LA CONEXION AL SALIR DE LA APLICACION----------------

	}


	private class ConsultaTabla implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String tablaSeleccionada=(String)comboTablas.getSelectedItem();
			obtenerDatos(tablaSeleccionada);
		}

		private void obtenerDatos(String tabla) {

			try {
				Statement miStatement = miConexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);

				ResultSet rs=miStatement.executeQuery("SELECT * FROM "+tabla);

				TableModel miModeloDatos=new TablaDatos(rs);
				
				remove(miScrollTabla);
				
				miScrollTabla=new JScrollPane(new JTable(miModeloDatos));
				
				add(miScrollTabla,BorderLayout.CENTER);		
				
				validate();

//				rs.close();
//				miStatement.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	}



	private JComboBox comboTablas;

	private JScrollPane miScrollTabla=null;

	private Connection miConexion;

}

class TablaDatos extends AbstractTableModel {

	ResultSet miRS;
	ResultSetMetaData miRSMetaData;
	
	public String getColumnName(int n) {
		try {
			return miRSMetaData.getColumnName(n+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public TablaDatos(ResultSet miRS) {
		super();
		try {
			this.miRS = miRS;
//			this.miRS.setFetchDirection(ResultSet.FETCH_UNKNOWN);

			miRSMetaData = miRS.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
		try {
			miRS.last();
			
			return miRS.getRow();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			return miRSMetaData.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		try {
			miRS.absolute(rowIndex + 1);
			return miRS.getObject(columnIndex + 1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}




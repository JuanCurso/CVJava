package bbdd_jdbc;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;




public class AplicacionUniversal {

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

		areaInformacion=new JTextArea();

		add(areaInformacion,BorderLayout.CENTER);		

		add(comboTablas, BorderLayout.NORTH);

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

		private int obtenerNumColumnas(String tabla) {
			int contador=0;

			try {
				DatabaseMetaData miMetaData=miConexion.getMetaData();

				ResultSet rs=miMetaData.getColumns(miConexion.getCatalog(), null, tabla, null);

				while (rs.next()) {
					contador++;
				}

				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return contador;
		}

		private void obtenerDatos(String tabla) {

			try {
				Statement miStatement = miConexion.createStatement();

				ResultSet rs=miStatement.executeQuery("SELECT * FROM "+tabla);

				ResultSetMetaData rsMetaData=rs.getMetaData();

				areaInformacion.setText("");

				while (rs.next()) {
					for (int i=1; i<=rsMetaData.getColumnCount(); i++) {
						areaInformacion.append(rs.getString(i) + " ");
					}

					areaInformacion.append("\n");
				}

				rs.close();
				miStatement.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	}



	private JComboBox comboTablas;

	private JTextArea areaInformacion;

	private Connection miConexion;

}




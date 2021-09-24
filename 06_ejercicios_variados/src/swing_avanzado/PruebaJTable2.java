package swing_avanzado;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class PruebaJTable2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana4 miVentana=new MiVentana4();

		miVentana.setVisible(true);
	}

}


class MiVentana4 extends JFrame {

	public MiVentana4 () {
		this.setBounds(400, 300, 400, 200);
		this.setTitle("Tabla Personalizada");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TableModel miModelo=new ModeloTabla();
		
		JTable miTabla=new JTable(miModelo);
		
		add(new JScrollPane(miTabla), BorderLayout.CENTER);
		
	}
}

class ModeloTabla extends AbstractTableModel {

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return (rowIndex+1) + " " + (columnIndex+1);
	}
	
	public String getColumnName(int c) {
		return "Columna " + (c+1);
	}
}

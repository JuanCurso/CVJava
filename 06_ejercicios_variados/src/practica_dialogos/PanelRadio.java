package practica_dialogos;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class PanelRadio extends JPanel {

	public PanelRadio() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public JRadioButton[] creaPanel(String titulo, String radio[]) {
		
		this.setBorder(new TitledBorder(titulo));

		ButtonGroup miButtonGroup=new ButtonGroup();
		
		JRadioButton miRadioButton[]=new JRadioButton[radio.length];
		
		for (int i=0; i<radio.length; i++) {
			miRadioButton[i]=new JRadioButton(radio[i]);
			
			miRadioButton[i].setSelected(i==0);
			
			miButtonGroup.add(miRadioButton[i]);

			this.add(miRadioButton[i]);
		}
		
		
		return miRadioButton;
		
	}
}

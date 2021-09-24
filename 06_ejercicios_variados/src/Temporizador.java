import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Temporizador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ActionListener miEvento=new Evento();
		Timer miTemporizador=new Timer(5000, miEvento);
		
		miTemporizador.start();
		
		new JOptionPane().showMessageDialog(null, "Pulsa Aceptar para parar!!!!");
		
		System.exit(0);
	}

}

 class Evento implements ActionListener {
	 
	 public void actionPerformed(ActionEvent e) {
		 System.out.println(new Date());
		 
		 Toolkit.getDefaultToolkit().beep();
	 }
 }
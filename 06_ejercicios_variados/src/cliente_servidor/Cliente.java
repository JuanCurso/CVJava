package cliente_servidor;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoCliente mimarco=new MarcoCliente();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{

	public MarcoCliente(){

		setBounds(600,300,280,350);

		LaminaMarcoCliente milamina=new LaminaMarcoCliente();

		add(milamina);

		setVisible(true);

		this.addWindowListener(new EnvioOnline(milamina.getNick().getText()));
	}	

}

class EnvioOnline extends WindowAdapter {
	private String nick;

	public EnvioOnline(String nick) {
		this.nick=nick;
	}

	public void windowOpened(WindowEvent e) {

		try {

			Socket miSocket=new Socket("localhost", 9999);
			InetAddress miLocalIp = miSocket.getLocalAddress();

			MensajeChat miMensaje=new MensajeChat(nick,miLocalIp.getHostAddress(), "online");

			ObjectOutputStream miOOS = new ObjectOutputStream(miSocket.getOutputStream());

			miOOS.writeObject(miMensaje);

			miOOS.close();
			miSocket.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}

class LaminaMarcoCliente extends JPanel implements Runnable{

	public LaminaMarcoCliente(){

		add(new JLabel("Nick: "));

		nick=new JLabel();
		nick.setText(JOptionPane.showInputDialog(this, "Dime tu nick"));
		add(nick);

		add(new JLabel("Online: "));

		ip=new JComboBox();

		add(ip);

		textoRecibido=new JTextArea(12,20);
		textoRecibido.setEditable(false);

		add(textoRecibido);

		campo1=new JTextField(20);

		add(campo1);		

		miboton=new JButton("Enviar");

		EnviarTexto eventoBoton=new EnviarTexto();

		miboton.addActionListener(eventoBoton);
		add(miboton);	


		Thread hiloSocket=new Thread(this);

		hiloSocket.start();

	}


	private class EnviarTexto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub


			try {
				Socket miSocket=new Socket("localhost", 9999);


				MensajeChat miMensaje=new MensajeChat(nick.getText(),(String)ip.getSelectedItem(), campo1.getText());

				ObjectOutputStream miOOS=new ObjectOutputStream(miSocket.getOutputStream());

				miOOS.writeObject(miMensaje);

				miOOS.close();
				miSocket.close();

				/*				DataOutputStream flujoSalida=new DataOutputStream(miSocket.getOutputStream());
				flujoSalida.writeUTF(campo1.getText());
				 */

				textoRecibido.append("Yo: " + campo1.getText() + "\n");
				campo1.setText("");

			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
		}

	}



	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {

			ServerSocket miServerSocket=new ServerSocket(9090);

			while (true) {

				Socket miSocket=miServerSocket.accept();

				ObjectInputStream miOIS=new ObjectInputStream(miSocket.getInputStream());

				Object miObjeto=miOIS.readObject();

				if (miObjeto.getClass().getName().equals("java.util.ArrayList")) {
					InetAddress miIpLocal=miSocket.getLocalAddress();
					
					ip.removeAllItems();
					
					ArrayList<String> misIp=(ArrayList)miObjeto;
					for (String string : misIp) {
						if (!miIpLocal.getHostAddress().equals(string))
							ip.addItem(string);
					}
				}
				else {
					MensajeChat miMensaje=(MensajeChat)miObjeto;

					/*				DataInputStream flujoEntrada=new DataInputStream(miSocket.getInputStream());

				String cadena=flujoEntrada.readUTF();*/

					textoRecibido.append(miMensaje.getNick() + ": " + miMensaje.getTexto() + "\n");
				}
				miOIS.close();
				miSocket.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private JLabel nick;
	private JComboBox ip;
	private JTextField campo1;
	private JTextArea textoRecibido;

	private JButton miboton;

	public JLabel getNick() {
		return nick;
	}

}
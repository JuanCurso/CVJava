package cliente_servidor;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoServidor mimarco=new MarcoServidor();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	
}

class MarcoServidor extends JFrame implements Runnable {

	public MarcoServidor(){

		setBounds(1200,300,280,350);				

		JPanel milamina= new JPanel();

		milamina.setLayout(new BorderLayout());

		areatexto=new JTextArea();

		milamina.add(areatexto,BorderLayout.CENTER);

		add(milamina);

		setVisible(true);

		Thread hiloSocket=new Thread(this);

		hiloSocket.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		ArrayList<String> misClientes = new ArrayList<String>();
		
		try {

			ServerSocket miServerSocket=new ServerSocket(9999);

			while (true) {

				Socket miSocket=miServerSocket.accept();

				//--------Detecta la ip de los usuarios que se conectan
				InetAddress direccionOnline=miSocket.getInetAddress();
				System.out.println(direccionOnline.getHostAddress());
				//--------Fin ip usuario que se conectan


				ObjectInputStream miOIS=new ObjectInputStream(miSocket.getInputStream());

				MensajeChat miMensaje=(MensajeChat)miOIS.readObject();

				areatexto.append(miMensaje.getNick() + ": " + miMensaje.getTexto() + " para el cliente " +
						miMensaje.getIp() + "\n");
				
				/*				DataInputStream flujoEntrada=new DataInputStream(miSocket.getInputStream());

				String cadena=flujoEntrada.readUTF();*/

				//Si el origen y el destino del mensaje es la misma ip, es un mensaje de inicio del cliente
				//Enviamos al nuevo cliente la lista con el resto de clientes
				if (direccionOnline.getHostAddress().equals(miMensaje.getIp())) {
					misClientes.add(direccionOnline.getHostAddress());

					for (String string : misClientes) {
						Socket miSocketOut=new Socket(string, 9090);

						ObjectOutputStream miOOS=new ObjectOutputStream(miSocketOut.getOutputStream());
						
						miOOS.writeObject(misClientes);
						

						miOOS.close();
						miSocketOut.close();						
					}



				}
				else {
					Socket miSocketOut=new Socket(miMensaje.getIp(), 9090);

					ObjectOutputStream miOOS=new ObjectOutputStream(miSocketOut.getOutputStream());

					miOOS.writeObject(miMensaje);

					miOOS.close();
					miSocketOut.close();

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

	private	JTextArea areatexto;


}

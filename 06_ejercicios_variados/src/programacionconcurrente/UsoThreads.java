package programacionconcurrente;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame marco=new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}




//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota{
	
	// Mueve la pelota invirtiendo posición si choca con límites
	
	public void mueve_pelota(Rectangle2D limites){
		
		x+=dx;
		
		y+=dy;
		
		if(x<limites.getMinX()){
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			
			y=limites.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posición inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final int TAMX=15;
	
	private static final int TAMY=15;
	
	private double x=0;
	
	private double y=0;
	
	private double dx=1;
	
	private double dy=1;
	
	
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{
	
	//Añadimos pelota a la lámina
	
	public void add(Pelota b){
		
		semaforo.lock();
		try {
			pelotas.add(b);
		}
		
		finally {semaforo.unlock();}
	}
	
	public void paintComponent(Graphics g){

		super.paintComponent(g);

		Graphics2D g2=(Graphics2D)g;

		semaforo.lock();
		try {
			for(Pelota b: pelotas){

				g2.fill(b.getShape());
			}
		}
		finally {semaforo.unlock();}

		//		Toolkit.getDefaultToolkit().sync();

	}
	
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
	private ReentrantLock semaforo=new ReentrantLock();
}


//Marco con lámina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame{
	
	public MarcoRebote(){
		
		h=new Thread[100];
		
		setBounds(600,300,400,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				comienza_el_juego();
			}
			
		});
		
		
		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				System.exit(0);
				
			}
			
		});
		
		ponerBoton(laminaBotones, "Detener", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				System.out.println("Detener");

				if (MarcoRebote.contador>0) {
					MarcoRebote.contador--;
					h[MarcoRebote.contador].interrupt();
				}
			}
			
		});
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	
	//Ponemos botones
	
	public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
		JButton boton=new JButton(titulo);
		
		c.add(boton);
		
		boton.addActionListener(oyente);
		
	}
	
	//Añade pelota y la bota 1000 veces
	
	public void comienza_el_juego (){
		
					
			Pelota pelota=new Pelota();
			
			lamina.add(pelota);
			
			Runnable r=new HiloPelotas(pelota, lamina);
			h[MarcoRebote.contador]=new Thread(r);
			
			h[MarcoRebote.contador].start();

			MarcoRebote.contador++;
		
		
	}
	
	private LaminaPelota lamina;
	private Thread[] h;
	private static int contador=0;
	
}

class HiloPelotas implements Runnable {
	
	private Pelota pelota;
	private Component lamina;
	
	public HiloPelotas(Pelota p, Component c) {
		pelota=p;
		lamina=c;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//for (int i=1; i<=3000; i++){
			
		while (!Thread.currentThread().isInterrupted()) {
			
			pelota.mueve_pelota(lamina.getBounds());
			
			lamina.paint(lamina.getGraphics());
			
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
			}
			
		}
	}
	
	
}

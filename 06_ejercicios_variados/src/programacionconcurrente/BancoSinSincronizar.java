package programacionconcurrente;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Banco banco=new Banco(100,2000);
		
		for (int i=0; i<100; i++) {
				Runnable r=new RealizacionTransf(banco, i, 2000);
				Thread t=new Thread(r);
				t.start();
				
		}
	}

}

class Banco {
	
	private final double[] cuentas;
//	private ReentrantLock semaforo=new ReentrantLock();
//	private Condition saldoSuficiente;
	
	public Banco(int n, double s) {
		
		cuentas=new double[n];
		
		for (int i=0; i<n; i++) {
			cuentas[i]=s;
		}
	}

	public synchronized void traspaso(int o, int d, double c) throws InterruptedException {

//		semaforo.lock();

//		try {
			while (cuentas[o]<c) {
//				saldoSuficiente.await();
				wait();
			}
			System.out.println(Thread.currentThread().getName());

			cuentas[o]-=c;

			System.out.printf("Cantidad %10.2f de %d a %d", c,o,d);
			cuentas[d]+=c;

			System.out.printf(" Saldo total es: %10.2f%n", this.getSaldoTotal());
			notifyAll();
//			saldoSuficiente.signalAll();
//		}
//		finally {semaforo.unlock();}
	}
	
	public double getSaldoTotal() {
		
		double suma=0;
		
		for (double e:cuentas) {
			suma+=e;
		}
		
		return suma;
	}
}

class RealizacionTransf implements Runnable {

	private Banco banco;
	private int origen;
	private double cantidadMAX;
	
	public RealizacionTransf(Banco b, int o, double cMAX) {
		banco=b;
		origen=o;
		cantidadMAX=cMAX;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			int destino=(int)(Math.random()*100);
			double cantidad=(double)(Math.random()*cantidadMAX);
			try {
				banco.traspaso(origen, destino, cantidad);
				Thread.sleep((int)(Math.random()*10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

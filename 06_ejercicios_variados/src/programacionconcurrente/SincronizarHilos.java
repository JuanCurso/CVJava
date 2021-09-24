package programacionconcurrente;

public class SincronizarHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hilo hilo1=new Hilo();
		Hilos hilo2=new Hilos(hilo1);
		Hilos hilo3=new Hilos(hilo1);

		hilo1.start();
		
		//Con esto hacemos que no se ejecuten más hilos hasta que termine el hilo1
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hilo2.start();
		hilo3.start();
		
	}

}

class Hilo extends Thread {
	
	
	public void run() {
		for (int i=1; i<=15; i++) {
			System.out.println("Hilo " + this.getName() + " contador " + i);
		}
	}
}

class Hilos extends Thread {
	
	private Thread h;
	
	public Hilos(Thread h) {
		this.h=h;
	}
	public void run() {
		
		try {
			h.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i=1; i<=15; i++) {
			System.out.println("Hilo " + this.getName() + " contador " + i);
		}
	}
}

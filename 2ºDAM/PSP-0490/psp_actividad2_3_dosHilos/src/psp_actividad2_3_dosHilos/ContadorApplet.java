package psp_actividad2_3_dosHilos;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("removal")
public class ContadorApplet extends Applet 
implements Runnable, ActionListener{
	
	class HiloContador extends Thread{
		//atributos y métodos
		long contador;

		public HiloContador(long Contador) {
			super();
			contador = Contador;
		}

		public long getContador() {
			return contador;
		}
		@Override
		public void run() {

			Thread hiloActual = Thread.currentThread();
			while(h1 == hiloActual || h2 == hiloActual) {
				try {
					Thread.sleep(600);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
				if(h1.isAlive()) {
				hilo1.contador++;
				}
				if (h2.isAlive()) {
				hilo2.contador++;
				}
				}
		}
	}//fin clase HiloContador
	
	HiloContador hilo1 = new HiloContador(10);//Hilo 1 empieza a contar en 10
	HiloContador hilo2 = new HiloContador(2);//Hilo 2 empieza a contar en 2
	//new Thread(hilo1).start();
	//Thread hilo = new Thread(hilo1);
	//hilo.start();
	
	Thread h1 = new Thread(hilo1);
	Thread h2 = new Thread(hilo2);
	long CONTADOR = 0;
	//private boolean parar;
	private Font fuente;
	private Button b1, b2;
	
	//inicia los dos hilos
	public void start() {
		h1.start();
		h2.start();
	}
	
	public void run() {}
	
	//prepara la pantalla
	public void init() {
		setBackground(Color.yellow);
		add(b1= new Button("Finalizar hilo 1"));
		b1.addActionListener(this);
		add(b2=new Button("Finalizar hilo 2"));
		b2.addActionListener(this);
		fuente = new Font("Verdana", Font.BOLD, 26);
	}
	
	//Manejador de los botones
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==b1) {
			b1.setLabel("Hilo 1 finalizado");
			if(h1 != null && h1.isAlive()) {
				h1.stop();
			}
			else {
			}
		}else if(e.getSource() == b2) {
			b2.setLabel("Hilo 2 finalizado");
			if(h2 != null && h2.isAlive()) {
				h2.stop();
			}
			else {}
		}
	}

	
	
	public void paint(Graphics g) {
		g.clearRect(0,0, 400,400);
		g.setFont(fuente);
		g.drawString("Hilo 1: " + Long.toString((long) hilo1.getContador()), 80, 100);
		g.drawString("Hilo 2: " + Long.toString((long) hilo2.getContador()), 80, 150);
	}
	
//	public void stop() {
//		h1 = null;
//	}	
}




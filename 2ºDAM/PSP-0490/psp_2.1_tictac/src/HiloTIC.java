
public class HiloTIC extends Thread{
public void run() {
	try {
		for (int i = 0; i< 1000; i++) {
		System.out.println("TIC");
		
		Thread.sleep(1000);
		}
	}catch(InterruptedException ex ) {
		
	}
}
}


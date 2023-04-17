
public class HiloTAC extends Thread{
public void run() {
	try {
		for (int i = 0; i< 1000; i++) {
			System.out.println("TAC");
			
			Thread.sleep(1000);
			}
	}catch(InterruptedException ex) {
		
	}
}
}

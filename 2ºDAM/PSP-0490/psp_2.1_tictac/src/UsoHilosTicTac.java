
public class UsoHilosTicTac {

	public static void main(String[] args) {
		
		ThreadGroup hilosTICTAC = new ThreadGroup("Grupo de hilos");
		HiloTIC hI = new HiloTIC();
		HiloTAC hA = new HiloTAC();
			
		Thread h1 = new Thread(hilosTICTAC, hI);
		Thread h2 = new Thread(hilosTICTAC, hA);
		
		
		h1.start();
		h2.start();
	}	

}

/* en el segundo array no se vale de repetir yno se vale de repetir tampoco del primer array no te creas*/

import java.util.Scanner;


public class ejercicio3 {

	public static void main(String[] args) {
		//variables
		int[] casillero = new int[5];
		int[] casillerox = new int[5];

		boolean ajo = false, ajo2 = false;
		
	     //pedir 5 números e introducirlos en un array
	     System.out.println("Introduce 5 números enteros entre 0 y 10:");
	     Scanner dime = new Scanner(System.in);
	     for (int i=0; i<5; i++){ 
	         casillero[i] = dime.nextInt();
	          if (casillero[i]<1 || casillero[i]>10){
	          System.out.println("Entre 1 y 10, ni más ni menos:");
	          i = i - 1;}
	     }
	     //vamos con el segundo array y sus restricciones
	     
	     for (int i=0; i<5; i++){ 
         System.out.println("Elemento " + (i+1) + " de un segundo array-->");
         casillerox[i] = dime.nextInt();
         int z = casillerox[i];
         	for (int c=i-1; c>=0 && ajo == false; c--){
             	ajo = (z == casillerox[c]) ? true: false;};    
         	for (int c=0; c<5 && ajo2 == false; c++){
             	ajo2 = (z == casillero[c]) ? true: false;};  
         if (ajo == true || ajo2 == true){
         System.out.println("Importante: que no se repitan del array anterior ni de este:");
         i = i - 1;};
         ;     
         ajo = false;
         ajo2 = false;
     }
	     System.out.println("Los dos arrays quedan así:");
	     for (int i=0; i<5; i++){
	    	 System.out.print(casillero[i] + "/");
	     }
	     System.out.println("\n");
	     for (int i = 0; i<5; i++) {
	    	 System.out.print(casillerox[i] + "/");
	     }
	     
	     
	     
	     
	}

}

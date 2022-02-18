
/* 5 números en un array que menores que 10 mayores que -1 y que  me mire si son capicua
 * 
 */
import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		// variables
		boolean capicua = true;
		int[] casillero = new int[5];
	     //pedir 5 números e introducirlos en un array
	     System.out.println("Introduce 5 números enteros entre 0 y 9:");
	     Scanner dime = new Scanner(System.in);
	     for (int i=0; i<5; i++){ 
	         casillero[i] = dime.nextInt();
	          if (casillero[i]<0 || casillero[i]>9){
	          System.out.println("Entre 0 y 9:");
	          i = i - 1;}
	     }
	     for (int j= 0; j<5 && capicua == true; j++) {
	    	 if (casillero[j]== casillero[4-j]) {
	    		 capicua = true;
	    	 }else {
	    		 capicua = false;
	    	 }
	     }
	     System.out.println("¿Es capicua?" + capicua);
	     
	}
}


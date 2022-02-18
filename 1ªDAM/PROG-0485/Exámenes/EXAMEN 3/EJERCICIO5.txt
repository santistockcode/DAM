/*pedir número filas y columnas de matriz
 * rellenar
 * decir cuantas de los valores son menores de 5 agrupado por columnas
 */

import java.util.Scanner;

public class ejercicio5 {

	public static void main(String[] args) {
		// variables
		int nf, nc, contador;
		Scanner sc = new Scanner(System.in);
		
	    System.out.print("Número de filas:");
	     nf = sc.nextInt();
		System.out.print("Número de columnas:");
	     nc = sc.nextInt();
	     
		int[][] m1 = new int[nf][nc];


	     
	     //Que se rellene la matriz
	     System.out.print("Rellena la matriz ");
	     for (int i = 0; i < nf; i++) {
	    	 System.out.print("\n");
	    	 for(int j= 0; j<nc; j++) {
	    		 System.out.println("Elemento (" + i + "," + j + ")");
	    		 m1[i][j] = sc.nextInt();
	    		 if (m1[i][j]<1 || m1[i][j]>10){
	   	          System.out.println("Entre 1 y 10 please:");
	   	          j = j - 1;
	   	          }
	   	     }
	     }
	     
	     //Mostrar la matriz por pantalla
	        for (int i=0; i<nf; i++){

             for (int j=0; j<nc; j++){

            System.out.print ( m1[i][j]+" ");

          }

             System.out.println();

            }
	     
	     
	     
	     //Que en las columnas de 0<nc cuantos menores de 5?
	     contador = 0;
	     for (int j = 0; j < nc; j++) {
	    	 for(int i= 0; i<nf; i++) {
	    		 if (m1[i][j]<5) {
	    			 contador = contador + 1;
	    		 }
	   	      }
    		 System.out.println("En la columna " + (j+1) + " hay " + contador + " menores de 5");
    		 contador = 0;
	     }

	}

}

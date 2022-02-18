/*pedir un array y comprobar que haga bingo en una matriz */
/*variantes: si está en más de una fila,columna, si está en una diagonal*/


import java.util.Scanner;

public class ejercicio4{

	public static void main(String[] args) {
		// variables
				int[] casillero = new int[3];
				int matrid[][]= {{3,45,50},
								{15,6,79},
								{10,20,20}};
				boolean vertical = false, horizontal = false;	
				int contador_fila = 0;
				int contador_columna = 0;
				
				//Mostrar la matriz por pantalla para comprobar
		        for (int i=0; i<3; i++){

	             for (int j=0; j<3; j++){

	            System.out.print ( matrid[i][j]+" ");

	          }

	             System.out.println();

	            }
				
			     //pedir 3 números para un array
			     System.out.println("¿qué tres números lleva el array?");
			     Scanner dime = new Scanner(System.in);
			     for (int i=0; i<3; i++){ 
			         casillero[i] = dime.nextInt();
			     }
			     
			     //coincide alguna fila iz/derec?
			     for (int i = 0; i < 3 && horizontal == false; i++) {
			    	 for(int j= 0; j<3; j++) {
			    		 if (casillero[j] == matrid[i][j]){
			    			 contador_columna = contador_columna + 1;
			    			 
			    		 };
			    		 if (contador_columna==3) {
			    			 contador_fila = i+1;
			    			 horizontal = true;
			    			 break;
			    		 };
			    		 
			    	} 
			     contador_columna =0;
			    }
			    if (horizontal == true) {
			    	System.out.println("Está al menos en una fila , la " + contador_fila);
			    }
			    contador_columna = 0;
			    contador_fila = 0;
			    
			     //coincide alguna fila arriba abajo
			     for (int j = 0; j < 3 && vertical == false; j++) {
			    	 for(int i= 0; i<3; i++) {
			    		 if (casillero[i] == matrid[i][j]) {
			    			 contador_fila = contador_fila + 1;
			    			 
			    		 }
			    		 if (contador_fila ==3) {
			    			 contador_columna = i+1;
			    			 vertical = true;
			    			 break;
			    		 }
			    		 
			    	} 
				     contador_fila =0;

			    }
			     if (vertical == true) {
			     System.out.println("Está al menos en una columna , la " + contador_columna);
			     }	
			     if (vertical == false && horizontal == false) {
			    	 System.out.println("No mi ciela");
			     }
			     
	}

}

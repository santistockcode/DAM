/*pedir un array y comprobar que haga bingo en una matriz */
/*variantes: si está en más de una fila,columna, si está en una diagonal*/


import java.util.Scanner;

public class probationon {

	public static void main(String[] args) {
		// variables
				int[] casillero = new int[3];
				int matri[][]= {{3,45,50},
								{15,6,79},
								{10,20,20}};
				boolean vertical = false, horizontal = false;				
				
			     //pedir 3 números para un array
			     System.out.println("¿qué tres números lleva el array?");
			     Scanner dime = new Scanner(System.in);
			     for (int i=0; i<3; i++){ 
			         casillero[i] = dime.nextInt();
			     }
			     //coincide alguna fila iz/derec o der/izq
			     for (int i = 0; i < 3 && horizontal == false; i++) {
			    	 for(int j= 0; j<3; j++) {
			    		 horizontal = (casillero[j] == matri[i][j]) ? true: false;
			    		 horizontal = (casillero[j] == matri[3-i][j]) ? true: false;
			    	} 
			    }
			    //coincide alguna columna de arriba/abajo u abajo/arriba
				for (int j = 0; j < 3 && vertical == false; j++) {
					 for(int i= 0; i<3; i++) {
					 vertical = (casillero[i] == matri[i][j]) ? true: false;; 
					 vertical = (casillero[i] == matri[3-i][j]) ? true: false;; 
						}
				}
				if (vertical == true || horizontal == true){
			         System.out.println("Sí, este array se encuentra en una fila o columna de la matriz");
				}
			     
	}

}

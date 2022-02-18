/* llenar 3 arrays por teclado y hacer una matriz en la que contenerlos*/

import java.util.Scanner;

public class probatio2 {

	public static void main(String[] args) {
		// variables
		int[] casilleroa = new int[4];
	    int[] casillerob = new int[4];
	    int[] casilleroc = new int[4];
	    int[][] m1 = new int [4][3];
	     
	     Scanner dime = new Scanner(System.in);

	     System.out.println("Rellena el array 1/3:");
	     for (int i=0; i<casilleroa.length; i++){ 
	     System.out.println("-->");
	     casilleroa[i] = dime.nextInt();}
	     System.out.println("Rellena el array 2/3:");
	     for (int i=0; i<casillerob.length; i++){ 
	     System.out.println("-->");
	     casillerob[i] = dime.nextInt();}
	     System.out.println("Rellena el array 3/3:");
	     for (int i=0; i<casilleroc.length; i++){ 
	     System.out.println("-->");
	     casilleroc[i] = dime.nextInt();}
	     
	     for (int j = 0; j < 3; j++) {
	    	 for(int i= 0; i<4; i++) {
	    		 if (j == 0) {
	    		 m1[i][j]= casilleroa[j];}
	    		 if (j == 1) {
		    	 m1[i][j]= casillerob[j];}
	    		 if (j ==2) {
		    		 m1[i][j]= casilleroc[j];}
	    		 }
	    	 		
	    	 }
	   //Mostrar la matriz por patnatlla
	        for (int i=0; i<4; i++){

             for (int j=0; j<4; j++){

            System.out.print ( m1[i][j]+" ");

          }

             System.out.println();

            }
	     }

	     

	}


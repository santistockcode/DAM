
/**
 * Write a description of class probatio5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class probatio5
{
    public static void main(String[] args){
   int[][] m1 = new int[4][8];
   		Scanner sc = new Scanner(System.in);
   

         
 //Que se rellene la matriz
 System.out.print("Rellena la matriz ");
         for (int i = 0; i < 4; i++) {
             System.out.print("\n");
             for(int j= 0; j<8; j++) {
                 System.out.println("Elemento (" + i + "," + j + ")");
                 m1[i][j] = sc.nextInt();
                 
                 if (m1[i][j]<0 || m1[i][j]>9){
                  System.out.println("Entre 0 y 9:");
                  j = j - 1;
                  }
             }
    }
}
}

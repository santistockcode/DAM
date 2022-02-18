import java.util.Scanner;
public class arrays_4
{
     public static void main(String[] args){
     int[] casillero = new int[10];
     System.out.println("Introduce 10 números enteros:");
     Scanner dime = new Scanner(System.in);
     for (int i=0; i<10; i++){ 
         casillero[i] = dime.nextInt();
    }
    
   
    for(int j = 0; j < 5; j++){
        int m = j;
        System.out.println(casillero[m]);
        m = 9 - j;
        System.out.println(casillero[m]);
    }}}

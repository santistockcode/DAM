import java.util.Scanner;
public class arrays_5
{
     public static void main(String[] args){
     int[] casillero1 = new int[10];
     System.out.println("Introduce 10 números enteros:");
     Scanner dime = new Scanner(System.in);
     for (int i=0; i<10; i++){ 
         casillero1[i] = dime.nextInt();
    }
     int[] casillero2 = new int[10];
     System.out.println("Introduce 10 números enteros:");
     for (int i=0; i<10; i++){ 
         casillero2[i] = dime.nextInt();
    }
   int[] casillero3 = new int[20];
   for(int i =0, m; i < casillero1.length; i++){
       m = i * 2;
       casillero3[m] = casillero1[i];};
   for (int i= 0, m; i < casillero2.length; i++){
        m = (i * 2) + 1;
        casillero3[m]= casillero2[i];
    };
   System.out.println("Quedaría así:");
    for(int j = 0; j < 20; j++){
        System.out.println(casillero3[j]);}
    
}}

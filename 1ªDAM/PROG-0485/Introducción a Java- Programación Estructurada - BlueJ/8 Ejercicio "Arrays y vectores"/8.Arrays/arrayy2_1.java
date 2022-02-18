import java.util.Scanner;
public class arrayy2_1
{
     public static void main(String[] args){
     int[] casillero1 = new int[12];
     System.out.println("Introduce 12 números enteros:");
     Scanner dime = new Scanner(System.in);
     for (int i=0; i<12; i++){ 
         casillero1[i] = dime.nextInt();
    }
     int[] casillero2 = new int[12];
     System.out.println("Introduce 12 números enteros:");
     for (int i=0; i<12; i++){ 
         casillero2[i] = dime.nextInt();
    }
   int[] casillero3 = new int[24];
   //Tengo dos casilleros de 12 y uno de 24. Sin embargo las ultimas 3 posiciones no entran
    for(int i = 0, m = 0, c = 0; i < 12;i++, c++){
       m = c * 6;
       casillero3[m] = casillero1[i];
       i += 1;
       m += 1;
       casillero3[m] = casillero1[i];
       i += 1;
       m += 1;
       casillero3[m] = casillero1[i];
       };
    for(int i = 0, m = 0, c = 0; i < 12; i++, c++){
       m = (c * 6) + 3;
       casillero3[m] = casillero2[i];
       i += 1;
       m += 1;
       casillero3[m] = casillero2[i];
       i += 1;
       m += 1;
       casillero3[m] = casillero2[i];
       };
     System.out.println("Quedaría así:");
     for(int j = 0; j < 24; j++){
     System.out.println(casillero3[j]);
     };}}
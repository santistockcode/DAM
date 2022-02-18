
/**
 * Write a description of class arrays2_3SINTERMINAR here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;
public class arrays2_3
{
    public static void main(String[] args){
    //declarar el array
     int[] casillero1 = new int[10];
     //pedir 9 números e introducirlos
     System.out.println("Introduce 9 números enteros:");
     Scanner dime = new Scanner(System.in);
     for (int i=0; i<9; i++){ 
         casillero1[i] = dime.nextInt();
    }
    // pedir el número 10
    System.out.println("Ahora introduce un número más:");
    int x = dime.nextInt();
    // pedir una posición 
    System.out.println("¿En qué posición lo quieres rey?");
    int k = dime.nextInt();
    int p = k;
    //mover los números de un array a otro (o el mismo) con la excepción del numero x y desplazados
   int[] casillero3 = new int[20];
    for(int i =0, m = 0; i < (p - 1); i++, m++){
       casillero1[m] = casillero1[i];};
   for(int i =8, m = 9;i >= (p-1); i--, m--){
       casillero1[m] = casillero1[i];};
       casillero1[k - 1] = x;
    //sacar por pantalla el array
   System.out.println("Quedaría así:");
    for(int j = 0; j < casillero1.length; j++){
        System.out.println(casillero1[j]);}
}}


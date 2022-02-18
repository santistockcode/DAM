
/**
 * Write a description of class arrays2_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;
public class arrays2_4
{
    public static void main(String[] args){
    //declarar el array
     int[] casillero1 = new int[10];
     //pedir 10 números e introducirlos
     System.out.println("Introduce 10 números enteros:");
     Scanner dime = new Scanner(System.in);
     for (int i=0; i<10; i++){ 
         casillero1[i] = dime.nextInt();}
    //los intento desplazar
   int k = 1;
   k = casillero1[9];
   for(int l = 8, m = 9;l >= 0; l--, m--){
       casillero1[m] = casillero1[l];}
       ;
   casillero1[0] = k;
   //sacar por pantalla el array
   //Corrección a Javier array1[contador]= array1[contador - 1]; 
  
   System.out.println("Quedaría así:");
    for(int j = 0; j < casillero1.length; j++){
        System.out.println(casillero1[j]);}
}}


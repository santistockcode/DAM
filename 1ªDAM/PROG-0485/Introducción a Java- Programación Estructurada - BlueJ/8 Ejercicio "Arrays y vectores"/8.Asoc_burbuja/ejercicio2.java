
/**
 *2. Realiza un programa que compruebe si un array está o no ordenado de forma ascendente.
 *¿Qué cambiarías para que comprobara si está ordenado de forma descendente?
 */

import java.util.Scanner;
public class ejercicio2
{
     public static void main(String[] args){
    
     System.out.println("Dado el array con número de elementos:");
     Scanner dime = new Scanner(System.in);
     int num= dime.nextInt();
     int[] casillero = new int[num];
    System.out.println(" cuyos elementos son  ");
    for (int i=0; i<casillero.length; i++){ 
    casillero[i] = (int)(Math.random()*100);
    }
    for (int l = 0; l<casillero.length; l++){
     System.out.print(casillero[l] + "/");};
    int[] casillerox = new int[num];
    for (int l = 0; l < casillero.length; l++){
        casillerox[l] = casillero[l];}
    int auxiliar;
     for (int i=0; i<(casillero.length - 1); i++){
         for (int j=0; j<(casillero.length - 1); j++){
             if (casillero[j] > casillero[j+1]){
                 auxiliar = casillero[j];
                 casillero[j] = casillero[j+1];
                 casillero[j+1] = auxiliar;
                }
            }
        }; 
    boolean comprobante = true;
    for (int n=0; n< casillero.length && comprobante == true; n++){
        comprobante = (casillero[n] == casillerox[n]) ? true : false; 
    }
    if (comprobante == true){
        System.out.println("Están ordenados");
    }else{System.out.println("No lo están");
    }
    //COMPROBAR SI LO ESTÁN DE FORMA DESCENDENTE
    int[] casilleroy = new int[num];
    for (int l = 0; l < casillero.length; l++){
        casillero[l] = casilleroy[casillero.length-1-l];}
    //los ordendo descendentemente en casilleroy
        for (int n=0; n< casillero.length && comprobante == true; n++){
        comprobante = (casilleroy[n] == casillerox[n]) ? true : false; 
    }
    if (comprobante == true){
        System.out.println("Están ordenados descendentement");
    }else{System.out.println("No lo están");
    }
}}



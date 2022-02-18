/*
 * 6. Hacer un programa que pida por pantalla 3 notas, calcule su media y lo redondee.
 */
import java.util.Scanner;
public class Ejercicio6
{
public static void main (String[] args){
    Scanner dime = new Scanner(System.in);
    // declaro las variables
    double media, num, sumatorio;
    int c; //c de contador
System.out.print("Introduce 3 números para saber su media: \n");
    num = dime.nextDouble();   
    sumatorio = num;
    for (c = 1; c < 3; c++){
    System.out.print("Siguiente: \n");
    num = dime.nextDouble();
    sumatorio = sumatorio + num;
}  
media = sumatorio / 3;
media = Math.round(media);
System.out.print("Su media es " + media);
}}

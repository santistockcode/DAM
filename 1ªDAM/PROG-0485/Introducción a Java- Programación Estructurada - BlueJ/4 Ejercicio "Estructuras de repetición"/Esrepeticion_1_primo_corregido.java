


import java.util.Scanner;
public class Esrepeticion_1_primo_corregido
{
    public static void main(String[] args){
    //Declaro el Scanner "dime"
    Scanner dime = new Scanner(System.in);
    int n;
    System.out.println("Introduce un número n positivo distinto de 1 y te diré si es primo");
    n = dime.nextInt();
    int divisor;
    divisor = n - 1; /*Va a empezar a dividir desde n - 1*/
     do {divisor--;
        }while (divisor > 1 && n % divisor != 0);
    if (divisor == 1){ /*divisor-- ha llegado a 1 sin ser n divisible entre otros números */
        System.out.println("Sí, " + n + " es un número primo");
    }else{ System.out.println ("No, " + n + " no es primo"); 
        /*ha sido divisible entre otros números*/
    }
}}




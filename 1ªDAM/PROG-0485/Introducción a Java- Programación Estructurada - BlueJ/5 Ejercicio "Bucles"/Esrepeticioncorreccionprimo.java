


import java.util.Scanner;
public class Esrepeticioncorreccionprimo
{
    public static void main(String[] args){
    Scanner dime = new Scanner(System.in);
    int n;
    System.out.println("Introduce un número n positivo distinto de 1 y te diré si es primo");
    n = dime.nextInt();
    int divisor;
    divisor = n - 1; /*inicializo la variable divisor fuera del bucle*/
     do {divisor--;
        }while (divisor > 1 && n % divisor != 0);
    if (divisor == 1){ /*divisor-- ha llegado a 1 sin ser n divisible entre otros números */
        System.out.println("Sí, " + n + " es un número primo");
    }else{ System.out.println ("No, " + n + " no es primo"); /*ha sido divisible entre otros números*/
    }
}}




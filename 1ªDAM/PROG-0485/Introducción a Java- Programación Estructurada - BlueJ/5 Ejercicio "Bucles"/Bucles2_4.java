import java.util.Scanner;
public class Bucles2_4
{
    public static void main (String[] args){
    Scanner dime = new Scanner (System.in);
    //variables
    int a, b;
    b = 0;
    //petición de datos
    do {
    System.out.println("Número:");
    a = dime.nextInt();
    b = b + a;
    System.out.println("--->" + b);
    }while (a != 0);
    System.out.println("Has introducido un 0");
}}

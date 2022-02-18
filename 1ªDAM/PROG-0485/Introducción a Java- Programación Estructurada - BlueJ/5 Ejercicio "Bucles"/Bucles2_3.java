
import java.util.Scanner;
public class Bucles2_3
{
public static void main(String args[]){
    int a, b;
    Scanner dime = new Scanner(System.in);
    System.out.println("Introduce números");
    a = dime.nextInt();
    while (a >= 0){
    b = a % 2;
    if (b == 0){
         System.out.println("Es par");
    }else{
        System.out.println("Es impar");
    }
    a = dime.nextInt();}
    System.out.println("Has introducido un número negativo");
}}

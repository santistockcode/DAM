
import java.util.Scanner;
public class Estcontrol_5_cualesmayor
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
//Variables
    int x;
//Pido los números al usuario
    System.out.println("Introduce un número x");
    x = dime.nextInt();
    int y;
    System.out.println("Introduce un segundo número y");
    y = dime.nextInt();
//Comparo los dos números y doy la posibilidad de que sean el mismo
    if (x > y){
        System.out.println("El número " + x + " es mayor que el número " + y);
    }else if (y > x){
        System.out.println("El número " + y + " es mayor que el número " + x);
    }else if (y == x){
        System.out.println("Se trata del mismo número");
    }
}
}

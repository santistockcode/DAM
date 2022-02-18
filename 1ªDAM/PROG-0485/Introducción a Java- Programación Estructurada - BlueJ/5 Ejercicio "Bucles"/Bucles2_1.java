
import java.util.Scanner;
public class Bucles2_1
{
    public static void main(String args[]){
    int a, b;
    Scanner dime = new Scanner(System.in);
    System.out.println("Introduce un número:");
    a = dime.nextInt();
    // va a ir calculando el cuadrado del número que introduzca hasta que introduzca un número negativo
    while (a >= 0){
        b = a * a;
        System.out.println(b + "\nIntroduce otro número");
        a = dime.nextInt();
    }
    System.out.println("Has introducido un número negativo");
}
}

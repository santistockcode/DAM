//out of calculus solo masibon
//creo que lo he leido mal
import java.util.Scanner;
public class Estrepeticion2_1_cuadrado
{
    public static void main(String args[]){
    int a, b;
    Scanner dime = new Scanner(System.in);
    a = dime.nextInt();
    while (a >= 0){
        b = a * a;
        System.out.println(b);
        a = dime.nextInt();
    }
    System.out.println("Has introducido un número negativo");
}
}

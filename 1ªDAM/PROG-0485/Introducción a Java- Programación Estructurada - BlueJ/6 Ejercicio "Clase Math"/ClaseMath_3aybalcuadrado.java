
/**
 * A + b todo ello al cuadrado
 * idealmente trabajo solo con las variables  a, b y resultado final.
 *  
 */
import java.util.Scanner;
public class ClaseMath_3aybalcuadrado
{
    public static void main (String args[]){
    Scanner dime = new Scanner(System.in);
    double a, b, resultado;
    System.out.println("Calculadora de (a + b) al cuadrado");
    System.out.println("Introduce un número a");
    a = dime.nextDouble();
    System.out.println("Introduce un número b");
    b = dime.nextDouble();
    resultado = Math.pow(a, 2) + (2*a*b) + Math.pow (b, 2);
    System.out.println("El resultado es " + resultado);
}
}

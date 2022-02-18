
/**
 * vamos a pedir un número
 * en cada vuelta de un bucle habrá que multiplicar ese número por el número del bucle hasta llegar a 10 idealmente que lo calcule dentro
 * Santi
 */
import java.util.Scanner;
public class Bucles2_9
{
    public static void main(String[] args){
    int num, contador;
    Scanner dime = new Scanner(System.in);
    System.out.print("¿De qué numero quieres saber la tabla de multiplicar?");
    num = dime.nextInt();
    for (contador = 1; contador <= 10; contador++){
    System.out.println(num + " x " + contador + " = " + (num*contador));
}  
}}

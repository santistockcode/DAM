
import java.util.Scanner;
public class Bucles2_7
{
    public static void main(String[] args){
    /*que los sume que eso es importante y luego
     * me pide que además si alguno es mayor de 10000 
    */
    Scanner dime = new Scanner(System.in);

    int contador, sueldo, sumatorio, ricos;
    System.out.println("Introduce 10 sueldos: ");
    sueldo = dime.nextInt();
    /*se me ocurre que haya dos contadores uno para si eres rico y otro
     * para ir sumando.
     */
    if (sueldo > 10000){
        ricos = 1;
    }else{ ricos = 0;
    }
    for (contador = 1, sumatorio = 0; contador < 10; contador++){
    sumatorio = sumatorio + sueldo;
    sueldo = dime.nextInt();
    if (sueldo > 10000){
        ricos = ricos + 1;
    }
    }   System.out.println("La suma de todos es " + sumatorio + " y hay " + ricos
+ " con sueldo de más de 10000");

}}

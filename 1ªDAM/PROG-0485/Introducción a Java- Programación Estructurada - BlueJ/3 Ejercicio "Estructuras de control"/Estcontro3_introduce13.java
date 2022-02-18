
import java.util.Scanner;
public class Estcontro3_introduce13
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
//Inicializo variables
    int n;
//Pido el número al usuario
    System.out.println("Introduce un número, a ser posible el 13");
    n = dime.nextInt();
    if (n == 13){
        System.out.println("Eso es, el número 13");
    }else{
        System.out.println("Prueba otra vez");
    }
}
}


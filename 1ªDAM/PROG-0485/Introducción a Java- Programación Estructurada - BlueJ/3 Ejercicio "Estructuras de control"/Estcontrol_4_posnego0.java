
import java.util.Scanner;
public class Estcontrol_4_posnego0
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
    int n;
    System.out.println("Introduce un número");
    n = dime.nextInt();
    if (n > 0){
        System.out.println("El número es positivo");
    }else if (n == 0){
        System.out.println("El número es 0");
    }else if (n < 0){
        System.out.println("El número es negativo");
    }
}
}




import java.util.Scanner;
public class apuntesEstrepeticion1_primo
{
    public static void main(String[] args){
    //Declaro el Scanner "dime"
    Scanner dime = new Scanner(System.in);
    int n;
    //Pido el número a evaluar
    System.out.println("Introduce un número x positivo distinto de 1 y te diré si es primo");
    n = dime.nextInt();
    int resto;
    int divisor;
    for (divisor= n- 1, resto = n% divisor; divisor > 1 && resto != 0; divisor--){
        resto = n % divisor;
    }
    if (divisor == 1 && resto != 0){
        System.out.println("Sí, es primo");
    }else if (n == 2) { System.out.println ("Sí, es primo");
    }else { System.out.println ("No, no es primo");
    }
}
} /*CORREGIDO EN CLASE Y REESCRITO EN OTRA CLASE */




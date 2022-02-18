import java.util.Scanner;
public class Estcontrol_6_multiplo3
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
    int x;
    System.out.println("Introduce un número cualquiera");
    x = dime.nextInt();
    int resto;
    resto = x % 3;
    if (resto == 0){
        System.out.println("El número " + x + " es múltiplo de 3");
    }else{
        System.out.println("El número " + x + " no es múltiplo de 3");
    }
}
}
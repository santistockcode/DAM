import java.util.Scanner;
public class Estcontrol_7_impar
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
    int x;
    System.out.println("Introduce un número cualquiera");
    x = dime.nextInt();
    int resto;
    resto = x % 2;
    if (resto == 0){
        System.out.println("El número " + x + " no es impar");
    }else{
        System.out.println("El número " + x + " es impar");
    }
}
}
import java.util.Scanner;
public class Estcontro_13_nombresnumero
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
    int x;
    System.out.println("Introduce un número del 1 al 10");
    x = dime.nextInt();
    switch (x){
    case 1: System.out.println("Uno"); break;
    case 2: System.out.println("Dos"); break;
    case 3: System.out.println("Tres"); break;
    case 4: System.out.println("Cuatro"); break;
    case 5: System.out.println("Cinco"); break;
    case 6: System.out.println("Seis"); break;
    case 7: System.out.println("Siete"); break;
    case 8: System.out.println("Ocho"); break;
    case 9: System.out.println("Nueve"); break;
    case 10: System.out.println("Diez"); break;
    default: System.out.println("No es un número del 1 al 10"); break;
    }
}
}
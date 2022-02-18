import java.util.Scanner;
public class Estcontrol_9_cualessonpares
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
    int x;
    System.out.println("Introduce un número cualquiera x distinto a 0");
    x = dime.nextInt();
    int y;
    System.out.println("Introduce un número cualquiera y distinto a 0");
    y = dime.nextInt();
   
    if (y > 0 || x > 0){
        System.out.println("Has introducido al menos un número positivo");
}else{
        System.out.println("No has introducido ningún número positivo");
    }
}
}
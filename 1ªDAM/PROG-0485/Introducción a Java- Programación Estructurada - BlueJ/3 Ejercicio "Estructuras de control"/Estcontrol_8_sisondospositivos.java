import java.util.Scanner;
public class Estcontrol_8_sisondospositivos
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
    int x;
    System.out.println("Introduce un número cualquiera x distinto de 0");
    x = dime.nextInt();
    int y;
    System.out.println("Introduce un número cualquiera y distinto de 0");
    y = dime.nextInt();
    int resto;
    resto = x % 2;
    if (x > 0){
        if (y > 0){
        System.out.println("Los dos números son positivos");
    }else{
         System.out.println("No son dos números positivos");   
    }}else{
        System.out.println("No son dos números positivos");
    }
}
}
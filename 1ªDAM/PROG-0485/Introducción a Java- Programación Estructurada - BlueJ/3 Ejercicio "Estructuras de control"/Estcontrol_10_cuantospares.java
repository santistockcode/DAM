import java.util.Scanner;
public class Estcontrol_10_cuantospares
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
// Petición de números al usuario
    int x;
    System.out.println("Introduce un número cualquiera x");
    x = dime.nextInt();
    int y;
    System.out.println("Introduce un número cualquiera y");
    y = dime.nextInt();
//Declaro variables para usar el operando %
    int restox;
    int restoy;
    restox = x % 2;
    restoy = y % 2;
    if (restox == 0 && restoy == 0){
        System.out.println("Los dos números son pares");
    }else if (restox ==0 || restoy == 0){
        System.out.println("Has introducido solo un número par");
    }else{
        System.out.println("No has introducido ningún número par");
    }
}
}
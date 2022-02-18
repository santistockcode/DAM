
import java.util.Scanner;
public class Estrepeticion2_2_positivornegativ
{
    public static void main(String args[]){
    int a;
    Scanner dime = new Scanner(System.in);
    a = dime.nextInt();
    while (a != 0){
    if (a > 0){
         System.out.println("Es positivo");
    }else{
        System.out.println("Es negativo");
    }
    a = dime.nextInt();}
    System.out.println("Has introducido un 0");
}
}

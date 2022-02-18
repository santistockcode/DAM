import java.util.Scanner;
public class ejercicio3
{
     public static void main (String[] args){
    Scanner dime = new Scanner (System.in);
    int num, c, fact;
    System.out.println("Introduce un número para saber su factorial:");
    num = dime.nextInt();
    // contador empieza en 1 y por cada vez que va el bucle multiplica
    System.out.print(num);
    for (c = num, fact=num; c > 1; c--){
    System.out.print(" * ");
    num = num - 1; //k es el par que corresponde en cada caso
    fact = fact * num;
    System.out.print(num); //que coja esa k cada vez que pase por aquí en sumapares
    }
    System.out.print( " = ");
    System.out.println(fact);
    //Ha salido del bucle al llegar c a n veces.   
}}
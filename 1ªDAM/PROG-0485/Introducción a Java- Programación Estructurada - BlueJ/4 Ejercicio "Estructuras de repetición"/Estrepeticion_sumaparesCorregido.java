
import java.util.Scanner;
public class Estrepeticion_sumaparesCorregido
{
    public static void main (String[] args){
    Scanner dime = new Scanner (System.in);
    //variables
    int n, c, sumapares, k; //que multiplique 2 * n veces y que muestre el proceso  
    //petición de datos
    System.out.println("Introduce x para saber la suma de los x primeros pares:");
    n = dime.nextInt();
    c = 1; //contador empieza en 1 hasta llegar a n
    sumapares = 0;
    System.out.print(" 0");
    for (c = 1; c <= n; c++){
    System.out.print(" + ");
    k = c * 2; //k es el par que corresponde en cada caso
    System.out.print(k); //que coja esa k cada vez que pase por aquí en sumapares
    sumapares = sumapares + k;
    }
    System.out.print( " = ");
    System.out.println(sumapares);
    //Ha salido del bucle al llegar c a n veces.   
}}
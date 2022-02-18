import java.util.Scanner;
public class Estcontrol15_ordenar3
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
    int x;
    int y;
    int z;
    System.out.println("Introduce tres números distintos");
    x = dime.nextInt();
    y = dime.nextInt();
    z = dime.nextInt();
    /* hemos definido las 3 variables según nos las da el usuario y ahora las 
     * comparamos para saber su orden
     */
    if (y > x && x > z){
         System.out.println("El orden es "+ z + x + y);
    }else if (x > y && y > z){
         System.out.println("El orden es" + z + y + x);
    }else if (z > x && x > y){
         System.out.println("El orden es" + y + x + z);
    }else if (z > y && y > x){
         System.out.println("El orden es" + x + y + z);
    }else if (y > z && z > x){
         System.out.println("El orden es" + x + z + y); 
    }else if (x > z && z > y){
         System.out.println("El orden es" + y + z + x); 
         
    }else{ 
         System.out.println("No has introducido 3 números distintos");
}
}}
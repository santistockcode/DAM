
/**
 * Los datos que introduce el usuario son: número de coches vendidos (es decir ir metiendo coches hasta que pulses algo)
 * y de cada coche calcular el 5% y sumarlo.Puedo preguntar los coches 
 * vendidos quiero tener un sumatorio de las comisiones por coche quiero tener un valor final que añada los 1000 euros de sueldo base.
   */
import java.util.Scanner;
public class ClaseMath_2sueldovendedor
{
    public static void main(String[] args){
    Scanner dime = new Scanner(System.in);
    //declaro las variables necesarias
    int n, c; 
    double sumatorioporc, comisiontotal, sueldofinal, sueldoparcial; 
    System.out.println("--------");
    System.out.println("¿Cuantos coches ha vendido el vendedor en cuestión?");
    n = dime.nextInt();
    System.out.println("--------");
    System.out.print("Introduce el valor del coche número 1: ");
    sueldoparcial = dime.nextDouble()* 0.05;   
    comisiontotal = n * 50;
    sueldofinal = sueldoparcial;
    for (c = 1; c < n; c++){
    System.out.print("Introduce el valor del coche número " + (c+1) + " : ");
    sueldoparcial = dime.nextDouble() * 0.05;
    sueldofinal = sueldofinal + sueldoparcial;
}  
    sueldoparcial = Math.round(sueldoparcial*100.0)/100.0;
    /*Al ser dinero, esta es la solución que he encontrado en internet para 
    sacar el double con dos decimales */
    System.out.print("El sueldo del vendedor es " + (1000 + comisiontotal + sueldofinal) + " €");
}
}

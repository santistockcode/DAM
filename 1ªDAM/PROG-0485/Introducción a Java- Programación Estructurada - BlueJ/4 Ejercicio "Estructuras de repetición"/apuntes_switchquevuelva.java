
/**
 * que haya una opción que vuelva a empezar el switch, es eso posible? 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class apuntes_switchquevuelva
{
  public static void main(String[] args){
    Scanner dime = new Scanner(System.in);
    char opcion;
    System.out.println(" A.If - else.\n B.While \n C.Do-while \n D.For \n E.Exit");
    opcion = dime.next().charAt(0);
    boolean otravez;
    otravez = true;
    do{
    otravez = false;    
    switch (opcion){
        case ('a'| 'A'):   
    System.out.println(opcion + ".ruruduloasol");
        break;
        case ('b' | 'B'):
    System.out.println(opcion + ".ñalskjdfjfj}");
        break;
        case ('c' | 'C'):
    System.out.println(opcion + ".asñdklfjjfjjjfj");
        break;
    default: System.out.println("No has introducido un carácter válido"); otravez = true; break;
}
}while(otravez);
}}


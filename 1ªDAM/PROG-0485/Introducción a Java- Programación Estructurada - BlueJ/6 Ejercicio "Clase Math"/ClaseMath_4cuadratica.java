
/**
 * Para esto hay una formula que obtiene dos soluciones o hay posibilidad de que no hay soluciones
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ClaseMath_4cuadratica
{
    public static void main (String args[]){
    Scanner dime = new Scanner(System.in);
    double a, b, c, resultadoa, resultadob;
    System.out.println("Calculadora ax^2+bx+c=0");
    System.out.println("Introduce un número a");
    a = dime.nextDouble();
    System.out.println("Introduce un número b");
    b = dime.nextDouble();
    System.out.println("Introduce un número c");
    c = dime.nextDouble();
    //resultadoa = ((-b + Math.sqrt((b*b)-(4*a*c))) / (2*a));
    //hay una opcion que es esta funcion no tiene soluciones reales y otra que la segunda parte del numerador es 0, de ahí el if
    if (((b*b)-4*a*c) > 0){
    resultadob = Math.sqrt((b*b)-4*a*c);
    resultadob = -b - resultadob;
    resultadob = resultadob/(2*a);
    //al principio lo metí todo en una línea pero se veía muy mal
    resultadoa = Math.sqrt((b*b)-4*a*c);
    resultadoa = -b + resultadoa;
    resultadoa = resultadoa/(2*a);
    System.out.println("Para los valores " + a + ", " + b + " y " + c +
    ", las posibles soluciones son " +  resultadoa + " y " + resultadob);
    }else if (((b*b)-4*a*c) == 0){
    resultadoa = -b;
    resultadoa = resultadoa/(2*a);
    System.out.println("La solución es " + resultadoa);
    }else{ 
    System.out.println("No tiene solución");
}
} 
}

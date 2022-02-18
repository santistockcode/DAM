/*
 * 1. Calcula la cantidad de euros que tienen 3 amigos, si Paco tiene N (este valor lo pediremos al usuario),
Bartolo tiene la mitad que Paco, y Lucía tiene la mitad de lo que tiene Paco y Bartolo juntos.
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class Ejercicio1
{
public static void main(String args[]){
    float nPaco;
    Scanner dime = new Scanner(System.in);
    System.out.println("¿Cuántos euros tiene Paco?");
    nPaco = dime.nextFloat();
    float nBartolo = nPaco / 2;
    float nLucia = (nPaco + nBartolo) / 2;
    /* Como n Lucía puede salir con muchos decimales y la unidad menor son los céntimos:
    nLucia = Math.round(nLucia); Pero queremos dos decimales.
    Para un double podemos usar round, pero para un float he encontrado en internet
    esta solución de dar formato*/
    DecimalFormat solucion_formato = new DecimalFormat("#.00");
    //System.out.println(solucion_formato.format(nLucia)); (internet)
    System.out.println("Bartolo tiene " + solucion_formato.format(nBartolo) + " € y Lucía " + solucion_formato.format(nLucia) + " €");
}
}

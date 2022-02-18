package provisional_estructurasrepeticion;

import java.util.Scanner;
public class Estrepeticion2_8
{
    public static void main(String[] args){
    Scanner dime = new Scanner(System.in);
    int num, n, mayor, contador, suplente; 
    System.out.println("XXXXXXXX");
    System.out.println("¿Cuantos números quieres introducir?");
    num = dime.nextInt();
    System.out.println("XXXXXXXX");
    System.out.print("Introduce el número 1");
    n = dime.nextInt();
    mayor = n;
    for (contador = 1; contador < num; contador++){
    mayor = Math.max(mayor, n);
    suplente = contador + 1;
    System.out.print("Introduce el número " + suplente + " : ");
    n = dime.nextInt();
}   System.out.print("El mayor es: " + mayor);

}}

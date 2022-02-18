import java.util.Scanner;
public class Bucles2_ochoJavi
{
    public static void main(String[] args){
    Scanner teleo = new Scanner(System.in);
    int numnum, n, mayor, contador, suplente; 
    System.out.println("XXXXXXXX");
    System.out.println("¿Cuantos números quieres introducir? Te diré cual es mayor");
    numnum = teleo.nextInt();
    System.out.println("XXXXXXXX");
    System.out.print("introduce un número:");
    n = teleo.nextInt();
    mayor = n;
    for (contador = 1; contador < numnum; contador++){
    if (n > mayor){
        mayor = n;
    }
    //mayor = Math.max(mayor, n); (esto se vió en clase).
    System.out.print("introduce un número: ");
    n = teleo.nextInt();
}   System.out.print("El mayor es: "+ mayor);

}}


import java.util.Scanner;
public class Estrepeticion2_numeropares
{
    public static void main (String[] args){
    Scanner dime = new Scanner (System.in);
    int a;
    System.out.println("La suma de los x primeros números:");
    a = dime.nextInt();
    int b, vez, x, c, rp, sumapares;
    c = a + 1;
    /* primero he buscado como sumar los x primeros números; la corrección ha sido que mola más como lo ha hecho javier */
    for(b = 1, rp = 0; b <= a; b++){
        for (x = b, vez = 1; vez <= (c / 2); vez++){
            rp = c * (x / 2);
        }}
        int rf;
        if (a % 2 != 0){
            rf = rp + ((a/2) + 1);
        }else{
            rf = rp;
        }System.out.println("la suma de los " + a + " primeros numeros es " + rf);
        System.out.println("la suma de los " + a + " primeros pares es " + rf*2);
}}
/*corrección ha sido que mejor multiplicar por dos tantas veces y sacarlo*/

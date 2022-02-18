
import java.util.Scanner;
public class Estrepeticion_sumaparesCORRECT
{
    public static void main (String[] args){
    Scanner dime = new Scanner (System.in);
    //variables
    int a;
    int b, vez, x, c, rp, sumapares;
    //petición de datos
    System.out.println("La suma de los x primeros números:");
    a = dime.nextInt();
    c = 0;
    do {; c++;
    }while (c > a);
    System.out.println("pues serían " + a);
    /* primero he buscado como sumar los x primeros números; la corrección ha sido que mola más como lo ha hecho javier */
    //Inicializo el programa
       /* if (a % 2 != 0){
            rf = rp + ((a/2) + 1);
        }else{
            rf = rp;
        }System.out.println("la suma de los " + a + " primeros numeros es " + rf);*/
}}
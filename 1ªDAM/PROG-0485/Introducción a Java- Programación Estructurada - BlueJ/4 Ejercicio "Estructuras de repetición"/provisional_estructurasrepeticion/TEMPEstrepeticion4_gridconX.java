


import java.util.Scanner;
public class TEMPEstrepeticion4_gridconX
{
    public static void main(String[] args){
    int a, b;
    int nfila, ncolumna;
    Scanner dime = new Scanner(System.in);
    System.out.println("Introduce el número de columnas");
    a = dime.nextInt();
    System.out.println("Introduce el número de filas");
    b = dime.nextInt();
    /*mi estrategia es meter un bucle que repita una x un número de veces
     * (columnas) dentro de un bucle que lo repita tantas veces (filas)
     */
    char signo = 'X';
    for (nfila = 1; nfila <= b; nfila++){
        for (ncolumna = 1; ncolumna < a; ncolumna++){
        System.out.print(signo);}
        System.out.println(signo + "\n");
    }

}
}





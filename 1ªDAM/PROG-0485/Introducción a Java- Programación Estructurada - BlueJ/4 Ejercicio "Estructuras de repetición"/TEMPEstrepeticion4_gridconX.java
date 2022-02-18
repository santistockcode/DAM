


import java.util.Scanner;
public class TEMPEstrepeticion4_gridconX
{
    public static void main(String[] args){
    //Declaro las variables
    int a, b;
    int nfila, ncolumna;
    Scanner dime = new Scanner(System.in);
    System.out.println("Introduce el número de columnas");
    a = dime.nextInt();
    System.out.println("Introduce el número de filas");
    b = dime.nextInt();
    /*creo un bucle que repita una X un número de veces
     * (columnas) dentro de un bucle que lo repita tantas veces (filas)
     */
    char signo = 'X'; //que también se podría pedir
    for (nfila = 1; nfila <= b; nfila++){
        for (ncolumna = 1; ncolumna < a; ncolumna++){
        System.out.print(signo);}
        System.out.println(signo + "\n");
    }

}
}





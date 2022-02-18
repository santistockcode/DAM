
/**
 * 1. Implementa el código de ordenamiento burbuja visto en clase (“el kit de la cuestión”) son los 2 bucles for de “la transparencia 6”. Para ello, deberás:

*Pedir el número de elementos por ventana (JOptionPane).

*Pedir los elementos propiamente dichos por teclado (Scanner).

*Mostrar el array ordenado.

*¿Qué cambiarías para que se ordenara de mayor a menor? 

*¿Qué pasa si se encuentra 2 números con el mismo valor?

*2. Realiza un programa que compruebe si un array está o no ordenado de forma ascendente. ¿Qué cambiarías para que comprobara si está ordenado de forma descendente?




 */
import javax.swing.JOptionPane;
import java.util.Scanner;
public class ejercicio1
{
     public static void main(String[] args){
    Scanner dime = new Scanner(System.in);
    int num = Integer.parseInt(JOptionPane.showInputDialog("¿cuántos elementos?"));
    int[] casilleroc = new int[num];
   for (int i=0; i<casilleroc.length; i++){ 
         System.out.println("-->");
         casilleroc[i] = dime.nextInt(); 
        }
     //PONLO EN ORDEN.
     int auxiliar;
     for (int i=0; i<(casilleroc.length - 1); i++){
         for (int j=0; j<(casilleroc.length - 1); j++){
             if (casilleroc[j] > casilleroc[j+1]){
                 auxiliar = casilleroc[j];
                 casilleroc[j] = casilleroc[j+1];
                 casilleroc[j+1] = auxiliar;
                }
            }
        };     
   for (int l = 0; l<casilleroc.length; l++){
     System.out.print(casilleroc[l] + "/");};
     System.out.println("Y de mayor a menor:");
   // y de mayor a menor? 
   for (int i=0; i<(casilleroc.length - 1); i++){
         for (int j=0; j<(casilleroc.length - 1); j++){
             if (casilleroc[j] < casilleroc[j+1]){
                 auxiliar = casilleroc[j];
                 casilleroc[j] = casilleroc[j+1];
                 casilleroc[j+1] = auxiliar;
                }
            }
        };
   for (int l = 0; l<casilleroc.length; l++){
     System.out.print(casilleroc[l] + "/");};    
}
}

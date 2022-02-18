
/*
1. Implementa el código de ordenamiento por selección visto en clase, cumpliendo:

Pedir el número total de elementos por ventana (JOptionPane).

Pedir los elementos propiamente dichos por teclado (Scanner).

Añadir la “dupla” for y while de la última transparencia.

Mostrar el array ordenado.


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
        
  int aux, pos;
     //PONLO EN ORDEN.
   for(int i =0; i<casilleroc.length; i++ ){
       pos= i;
       aux= casilleroc[i];
       while ((pos>0) && (casilleroc [pos-1] > aux)){
           casilleroc[pos]=casilleroc[pos-1];
           pos--;
        }
        casilleroc[pos]=aux;
    }
    
   for (int l = 0; l<casilleroc.length; l++){
     System.out.print(casilleroc[l] + "/");};    
     
  //¿Qué cambiarías para que se ordenara de mayor a menor? 
  for(int i =0; i<casilleroc.length; i++ ){
       pos= i;
       aux= casilleroc[i];
       while ((pos>0) && (casilleroc [pos-1] < aux)){
           casilleroc[pos]=casilleroc[pos-1];
           pos--;
        }
        casilleroc[pos]=aux;
    }
    System.out.println("\n De mayor a menor quedaría: ");
    for (int l = 0; l<casilleroc.length; l++){
     System.out.print(casilleroc[l] + "/");};  
  //¿Qué pasa si se encuentra 2 números con el mismo valor? 
  //los intercambia pero al final van a aparecer ambos 
     

}
}


/**
3. Opcional, mejora el 2 haciendo que se compacta el array, poniendo todos los elementos al principio, y lo demás “borrado”.*/
import javax.swing.JOptionPane;
import java.util.Scanner;
public class ejercicio3
{
     public static void main(String[] args){
    
     System.out.println("Dado el array con número de elementos 10:");
     int[] casillero = new int[10];
    System.out.println(" cuyos elementos son  ");
    for (int i=0; i<casillero.length; i++){ 
    casillero[i] = (int)(Math.random()*100);
    }
    for (int l = 0; l<casillero.length; l++){
     System.out.print(casillero[l] + "/");};  
    //pide un elemento por ventana al usuario
    int k = Integer.parseInt(JOptionPane.showInputDialog("¿Qué número eliges?"));
    int pos, aux, cont;
    cont=0;
    for (int l = 0; l<casillero.length; l++){
        pos= l;
        if (casillero[l] == k){
            cont += 1;
            for (;l< (casillero.length-1);l++){    
            casillero[l] = casillero[l+1];
        }
        l = pos;
    }
}
int[] casillerob = new int[10-cont];
for (int i=0; i<casillerob.length; i++){
    casillero[i]= casillerob[i];
}
    System.out.println(cont + "\n Quedaría: ");
    for (int l = 0; l<casillerob.length; l++){
     System.out.print(casillerob[l] + "/");};  
 
}}



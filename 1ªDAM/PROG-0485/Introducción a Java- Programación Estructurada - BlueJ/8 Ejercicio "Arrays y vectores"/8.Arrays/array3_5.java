


/*
 * 5. Hacer un programa que pida 8 elementos que deben ser introducirse de forma creciente*. 
 * Estos datos los iremos almacenando en un array de 10 elementos. 
 * Después pedimos un número N y lo insertaremos en el array 
 * de forma que éste continúe ordenado
 */
import java.util.Scanner;
public class array3_5
{
     public static void main(String[] args){
     int[] casillero = new int[10];
     System.out.println("Introduce 10 números enteros en orden ascendente:");
     Scanner dime = new Scanner(System.in);
     boolean talcual = false;
     for (int i=0; i<10; i++){ 
     System.out.println("-->");
     casillero[i] = dime.nextInt();
     for (int j= i-1; j>=0 && talcual == false; j--){
         int k = casillero[i];
         if (casillero[j] >= k){
             System.out.println("Ese no, otro");
             i = i - 1;
             talcual = true;
             }
             talcual = false; 
            }
        };
     System.out.println("Quedaría así:");
     for (int l = 0; l<casillero.length; l++){
     System.out.print(casillero[l] + "/");};
     
     // he creado otro array de 11 y lo he ordenado
     int[] casillerox = new int[11];
     for(int m = 0; m<casillero.length; m++){
         casillerox[m] = casillero[m];}
     System.out.println("Introduce otro más -->");
     casillerox[11] = dime.nextInt();
     //método burbuja aplicado al array completo
     
     //corrección: mejor ir comparando de dos en dos y tener en cuenta que pueden ser iguales
     for (int z = 0; z<casiellox.length; z++){
         if (casillo[z] < casillerox[11] && casillero[z +1] > casillerox[11]){
             
     int auxiliar; 
     for (int i=0; i<(casillerox.length - 1); i++){
         for (int j=0; j<(casillerox.length - 1); j++){
             if (casillerox[j] > casillerox[j+1]){
                 auxiliar = casillerox[j];
                 casillerox[j] = casillerox[j+1];
                 casillerox[j+1] = auxiliar;
                }
            }
        }; 
      System.out.println("Quedaría así:");
        for (int l = 0; l<casillerox.length; l++){
     System.out.print(casillerox[l] + "/");};   
}
}
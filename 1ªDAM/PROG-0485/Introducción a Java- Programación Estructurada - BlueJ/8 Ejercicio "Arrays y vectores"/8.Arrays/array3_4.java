import java.util.Scanner;
public class array3_4
//ENUNCIADO: dado un array desordenado, ordénalo
{
     public static void main(String[] args){
     Scanner dime = new Scanner(System.in);
     int[] casillerox = new int[10];
     System.out.println("Mete 10 números en el array:");
     for (int i=0; i<casillerox.length; i++){ 
     System.out.println("-->");
     casillerox[i] = dime.nextInt();}
     int posicion; 
     do{
     System.out.println("¿Qué posición eliminamos? Entre 1 y 10:");
     posicion = dime.nextInt();
    } while (posicion < 1 || posicion > 10);
    posicion= posicion -1;
     //for(int m =posicion - 1, l = posicion - 1; l >= 0; l--, m--){
          //  casillerox[m] = casillero[l];};
     for(int m = posicion; m < 9; m++){
            casillerox[m] = casillerox[m + 1];};
            
     for (int l = 0; l<casillerox.length-1; l++){
     System.out.println(casillerox[l]);};
}
}
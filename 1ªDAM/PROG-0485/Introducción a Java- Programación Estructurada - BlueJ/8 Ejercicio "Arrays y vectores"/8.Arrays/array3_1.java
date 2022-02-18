import java.util.Scanner;
public class array3_1
{
     public static void main(String[] args){
     int[] casillero = new int[10];
     System.out.println("Introduce 10 números enteros diferentes:");
     Scanner dime = new Scanner(System.in);
     boolean talcual = true, talcual2 = false, talcual3 = false;
     int j;
     for (int i=0; i<10; i++){ 
         System.out.println("-->");
         casillero[i] = dime.nextInt();
         j = casillero[i];
         // para el 0
         if (i != 0){
         for (int c=(i-1); c>=0 && talcual2 == false; c--){
             talcual2 = (j == casillero[c]) ? true: false;};}   
         // para el que no es 0
         talcual = (i != 0) ? true : false;
         if (talcual2 == true){
         System.out.println("Ese ya lo has introducido");
         talcual = true;};
        
         if (talcual == true && i != 0 && talcual2 == true){ i = i - 1;};
         talcual = true;
         talcual2 = false;
     }
      System.out.println("Ahora escribe un número:");
      int k = dime.nextInt();
      int contador = 0;
      talcual = false;
    for (int i=0; i<10 && talcual == false; i++){ 
    talcual = (casillero[i] == k) ? true:false;
    contador += 1;
    }
    if (talcual == true){
    System.out.println("El número " + k + " está en la posición" + contador);
    }else{
    System.out.println("El número " + k + " no está en el array");
    }
}}
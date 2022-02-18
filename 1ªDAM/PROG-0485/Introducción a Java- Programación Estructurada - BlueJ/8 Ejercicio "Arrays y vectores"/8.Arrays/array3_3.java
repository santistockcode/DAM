import java.util.Scanner;
public class array3_3
{
     public static void main(String[] args){
     Scanner dime = new Scanner(System.in);
     System.out.println("¿cúantos números por array?:");
     int tantascasillas = dime.nextInt();
     int[] casilleroa = new int[tantascasillas];
     int[] casillerob = new int[tantascasillas];
     int[] casilleroc = new int[tantascasillas*2];
     System.out.println("Rellena el primer array con números decrecientes");
     boolean talcual = false;
     int z;
     System.out.println("-->");
     casilleroa[0] = dime.nextInt();
     for (int i=1; i<tantascasillas; i++){ 
         System.out.println("-->");
         casilleroa[i] = dime.nextInt();
         z = casilleroa[i];
         for (int c=(i-1); c>=0 && talcual == false; c--){
             talcual = (z >= casilleroa[c]) ? true: false;};   
         // para el que no es 0
         if (talcual == true){
         System.out.println("Ese es mayor o igual, tiene que ser menor:");
         i = i - 1;};
         ;     
         talcual = false;
     }
     System.out.println("Rellena el segundo array de la misma manera:");
     System.out.println("-->");
     talcual = false;
     casillerob[0] = dime.nextInt();
     for (int i=1; i<tantascasillas; i++){ 
         System.out.println("-->");
         casillerob[i] = dime.nextInt();
         z = casillerob[i];
        
         for (int c=(i-1); c>=0 && talcual == false; c--){
             talcual = (z >= casillerob[c]) ? true: false;};   
         // para el que no es 0
         if (talcual == true){
         System.out.println("Ese es mayor o igual, tiene que ser menor:");
         i = i - 1;};
         ;     
         talcual = false;
     }
     // con un sistema de ifs se pueden ir comparando , ver captura corrección de mario
     // y lo sacamos por pantalla
   for (int l = 0; l<casilleroc.length; l++){
     System.out.println(casilleroc[l]);};
}}

//

//que vaya pidiendo numeros todo el rato pero que cuando de un número con esas características se salga y dibuje
import java.util.Scanner;
public class Ejercicio6
{
   // ejercicio simplificado, dado un número de base de la columna, dibuja una pirámide
     public static void main(String[] args){
   int n;
   Scanner dime = new Scanner(System.in);
   System.out.println("Introduce el número");
   n = dime.nextInt();
    int c; // este va a ser el contador
   for (c = 0;n <= 0 || n >= 10; c++){
       System.out.println("Introduce otro número");
   n = dime.nextInt();
}
    // voy a usar el mismo contador ahora
   char visible;
   visible = 'X';
   // que dibuje primero n luego n-1 luego n-2 etc
    int cvis, puesto;
    puesto = 1;
    for (c = n; c > 0; c--){
        for (cvis = 0; cvis < c; cvis++){
        System.out.print(visible);};
        System.out.print("\n");
    }}}  
   
    



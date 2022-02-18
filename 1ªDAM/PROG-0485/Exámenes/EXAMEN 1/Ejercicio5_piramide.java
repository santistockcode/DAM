
//

//que vaya pidiendo numeros todo el rato pero que cuando de un número con esas características se salga y dibuje
import java.util.Scanner;
public class Ejercicio5_piramide
{
   // ejercicio simplificado, dado un número de base de la columna, dibuja una pirámide
     public static void main(String[] args){
   int n, resto;
   Scanner dime = new Scanner(System.in);
   System.out.println("Introduce el número");
   n = dime.nextInt();
   resto = (n%2);
    int c; // este va a ser el contador
   for (c = 0;n < 0 || n > 15 || resto == 0; c++){
       System.out.println("Introduce otro número");
   n = dime.nextInt();
   resto = (n%2);
}
    // voy a usar el mismo contador ahora !
   char invisible;
   char visible;
   invisible = ' ';
   visible = 'X';
    // voy a dibujar cada fila, calculando primero cuantos 0 cuantos x. 
    //ponemos el ejemplo de n= 7;
    // quiero que haya 3 invisibles , 1 visibles = 4
    // luego que haya 2 invisibles, 3 visibles = 5
    // luego que haya 1 invisibles, 5 visibles = 6
    // luego que haya 0 invisibles, 7 visibles = 7
    int cinvis, cvis, impar, puesto; // cinvis es contador de invisibles, cvis es contador de visibles 
    puesto = 1;
    impar = 1;
    for (c = (n+1)/2; c <= n; c++){
        for (cinvis = c - impar, puesto = 1; puesto <= cinvis; puesto++){
        System.out.print(invisible);};
        for (cvis = impar, puesto = 1; puesto <= cvis; puesto++){
        System.out.print(visible);};
        impar = impar + 2;
        System.out.print("\n");
    }}}  
   
    



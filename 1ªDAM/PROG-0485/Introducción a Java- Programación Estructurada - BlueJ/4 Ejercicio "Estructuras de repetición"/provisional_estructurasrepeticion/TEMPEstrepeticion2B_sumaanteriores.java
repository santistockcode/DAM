
import java.util.Scanner; 
public class TEMPEstrepeticion2B_sumaanteriores
{
    public static void main (String args[]){
    int a, b, c, d, e, f;
    Scanner dime = new Scanner(System.in);
   
    System.out.println("Introduce un número inicial e iré sumando números positivos que introduzcas");
    b = dime.nextInt();
    /*No sé como funcionar con valores absolutos así que de momento así se queda.
     */
    
    a = 0;
    d = 1;
    c = 0;
    c = c + b;
    for ( a = 0;; a++){
       b = dime.nextInt();
       c = c + b;
       System.out.println(c);
        a = a + 1;
        for (;a > 0; a--){
        } d = dime.nextInt();
        e = d + c;
        System.out.println(e);
        c = e;
        a = a - 1;
    }
}
} /*YA REESCRITO EN OTRA CLASE es un while simplemente que se pide un número fuera y se soluciona dentro hasta que metes un 0 (esto lo deduzco yo) que entonces se sale*/


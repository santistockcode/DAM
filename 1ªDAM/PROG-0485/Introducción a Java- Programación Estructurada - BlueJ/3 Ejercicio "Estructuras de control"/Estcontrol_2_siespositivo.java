

import java.util.Scanner;
public class Estcontrol_2_siespositivo
{
   public static void main(String[] args) {
   System.out.println("Introduce un número (distinto a 0) para saber si es positivo");
   Scanner read = new Scanner(System.in);
   int numerodelusuario;
   numerodelusuario = read.nextInt();
   if (numerodelusuario > 0){
       System.out.println("¡Es positivo!");
   }else{
       System.out.println("No es un número positivo");
    }
    }
}

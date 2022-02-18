
/**
 Se le pide al usuario un número de segundos y se convierte a Días, horas, minutos y segundos.
 */
import java.util.Scanner;
public class Operadores3_losdiaslashoras
{
    public static void main(String[] args) {
   Scanner read = new Scanner(System.in);
   /* voy a hacer que la pantalla pida al usuario los segundos */
   System.out.println("Introduzca el número de segundos");
   /* y declare lo que marque el usuario como precisamente una variable */
   /*usamos read.nextInt() para leer de la consola*/
   int tantossegundos;
   tantossegundos = read.nextInt();
   int diasquesean = tantossegundos / 86400;
   int restoseg1 = tantossegundos % 86400; /*restoseg1 es el resto una vez saquemos los días*/
   int horasquesean = restoseg1 / 3600;
   int restoseg2 = restoseg1 % 3600; /*mismo procedimiento */
   int minutosquesean = restoseg2 / 60;
   int restoseg3 = restoseg2 % 60;
   System.out.println(diasquesean  + " días " + horasquesean + " h " + 
   minutosquesean + " m " + restoseg3 + " s" );
}
 
}

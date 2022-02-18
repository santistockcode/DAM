
import java.util.Scanner;
public class EJercicio6_Monedas
{ public static void main(String[] args) {
   Scanner read = new Scanner(System.in);
   System.out.println("De cuanto dinero estamos hablando");
   /* y declare lo que marque el usuario como precisamente una variable */
   double dineros = (read.nextDouble()) * 100; //para leer de la consola*/
   int transformado =  (int)Math.round(dineros);
   
   int dedoseuros = transformado / 200;
   int restoscent1 = transformado % 200; /*restoseg1 es el resto una vez saquemos los días*/
   
   int deuneuro = restoscent1 / 100;
   int restoscent2 = restoscent1 % 100;
   
   int de50centimos = restoscent2 / 50;
   int restocent3 = restoscent2 % 50; /*mismo procedimiento */
   
   int de20centimos = restocent3 / 20;
   int restocent4 = restocent3 % 20; /*mismo procedimiento */
   
   int de10centimos = restocent4 / 10;
   int restocent5 = restocent4 % 10; /*mismo procedimiento */
   
   int de5centimos = restocent5 / 5;
   int restocent6 = restocent5 % 5; /*mismo procedimiento */
   
   int de2centimos = restocent6 / 2;
   int restocent7 = restocent6 % 2; /*mismo procedimiento */
   
   System.out.println( " monedas de--> " +
   "\ndos euros: " + dedoseuros + 
   "\nun euro: " + deuneuro + 
   "\n50 cents: " + de50centimos + 
   "\n 20 cents: " + de20centimos + 
   "\n 10 cents: " + de10centimos + 
   "\n 5 centimos: " + de5centimos + 
   "\n 2 centimos: " + de2centimos +
   "\n y de 1 centimo: " + restocent7); 
}}

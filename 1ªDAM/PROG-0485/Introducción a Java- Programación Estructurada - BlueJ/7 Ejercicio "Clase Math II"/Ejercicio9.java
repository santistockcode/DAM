
/*
 * 9. Mejorar el programa al ejercicio 6, para que muestre su valor en “literal”, es decir:
Mostrará:
“muy deficiente” si el valor es 0, 1 ó 2
“deficiente” si el valor es 3 ó 4.
“suficiente” si el valor es 5.
“bien” si el valor es 6.
“notable” si el valor es 7 ó 8.
“sobresaliente” si el valor es 9.
“LA REOSTIA” si el valor es 10.
 */
import java.util.Scanner;
public class Ejercicio9
{
public static void main (String[] args){
    Scanner dime = new Scanner(System.in);
    // declaro las variables
    double media, num, sumatorio;
    int c; //c de contador
System.out.print("Introduce 3 números para saber su media: \n");
    num = dime.nextDouble();   
    sumatorio = num;
    for (c = 1; c < 3; c++){
    System.out.print("Siguiente: \n");
    num = dime.nextDouble();
    sumatorio = sumatorio + num;
}  
media = sumatorio / 3;
media = Math.round(media);
int m = (int)media;
switch(m)
{
    case 0: System.out.println("Muy deficiente"); break;
    case 1: System.out.println("Muy deficiente"); break;
    case 2: System.out.println("Muy deficiente"); break;
    case 3: System.out.println("Deficiente"); break;
    case 4: System.out.println("Deficiente"); break;
    case 5: System.out.println("Suficiente"); break;
    case 6: System.out.println("Bien"); break;
    case 7: System.out.println("Notable"); break;
    case 8: System.out.println("Notable"); break;
    case 9: System.out.println("Sobresaliente"); break;
    case 10: System.out.println("Sobresaliente"); break;      
}
}
}

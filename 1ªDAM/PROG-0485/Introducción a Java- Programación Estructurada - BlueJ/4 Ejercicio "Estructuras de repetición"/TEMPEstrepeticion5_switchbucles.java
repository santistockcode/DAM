
import java.util.Scanner;
public class TEMPEstrepeticion5_switchbucles
{
  public static void main(String[] args){
    Scanner dime = new Scanner(System.in);
    char opcion;
    System.out.println(" A.If - else.\n B.While \n C.Do-while \n D.For \n E.Exit");
    opcion = dime.next().charAt(0);
    switch (opcion){
        case ('a'| 'A'):   
    System.out.println(opcion + ".If - else:\n------\n" + "if(condición){\n\nSentenias;\n\n}else{\n\nSentencias;\n\n}");
        break;
        case ('b' | 'B'):
    System.out.println(opcion + ".While:\n------\n" + "while(condición){\n\n// cuerpo del bucle\n\n}");
        break;
        case ('c' | 'C'):
    System.out.println(opcion + ".Do-while:\n------\n" + "do{\n\n// cuerpo del bucle\n\n}while(condición);");
        break;
        case ('d' | 'D'):
    System.out.println(opcion + ".For:\n------\n" + "do(inicialización; condición; iteración){\n\n// cuerpo del bucle\n\n}");
        break;
        case ('e' | 'E'):
    System.out.println(opcion + ".Exit");System.exit(0);
        break;
    default: System.out.println("No has introducido un carácter válido");
}}}

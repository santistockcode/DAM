import java.util.Scanner;
public class ClaseMath_7adivina13
{
    // lo que cambia aquí es donde ponemos el bucle, lo va a pedir 5 veces ó que acierte
    // si algo ha cambiado a true
public static void main (String[] args){
    Scanner dime = new Scanner(System.in);
    // declaro las variables
    int num, numsecreto;
    int c; //c de contador
    boolean quesera;
    numsecreto = 13;
    System.out.print("Intenta acertar un número en un máximo de 5 intentos: \n");
    num = dime.nextInt();   
    quesera = false;
    //if (num == numsecreto){quesera = true}, pero me gusta más con ?;
    quesera = (num == numsecreto) ? true : false;
    for (c = 1; c < 5 && quesera == false; c++){
    System.out.print("Siguiente: \n");
    num = dime.nextInt();
    quesera = (num == numsecreto) ? true : false;
    //if (num == 13){quesera = true;};
}
if (quesera == true){
System.out.println("Acertaste en tan solo " + c + " intentos");
}else{ System.out.println("Se consumieron los 5 intentos, lo siento");
}
}
}
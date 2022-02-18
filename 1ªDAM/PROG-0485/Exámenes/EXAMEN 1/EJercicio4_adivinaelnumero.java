import java.util.Scanner;
public class EJercicio4_adivinaelnumero
{
    // lo que cambia aquí es donde ponemos el bucle, lo va a pedir 5 veces ó que acierte
    // si algo ha cambiado a true
public static void main (String[] args){
    Scanner dime = new Scanner(System.in);
    // declaro las variables
    int num, numsecreto;
    int c; //c de contador
    boolean quesera;
    double numerico;
    numerico = Math.random();
    //System.out.println("numerico:"+ numerico);
    numerico = numerico * 20;  //para que esté entre 0 y 20;
    numsecreto = (int) Math.round(numerico); //de internet, redondear a entero
    System.out.print("Intenta acertar un número entre 0 y 20 en un máximo de 8 intentos: \n");
    num = dime.nextInt();   
    quesera = false;
    //if (num == numsecreto){quesera = true}, pero me gusta más con ?;
    quesera = (num == numsecreto) ? true : false;
    for (c = 1; c < 8 && quesera == false; c++){
     if (num > numsecreto){
        System.out.println("Más pequeño");
       }else if(num < numsecreto){
       System.out.println("Más grande");}
    System.out.print("Siguiente: \n");
    num = dime.nextInt();
    quesera = (num == numsecreto) ? true : false;
    //if (num == 13){quesera = true;};
    
}
if (quesera == true){
System.out.println("Acertaste en el intento número " + c );
}else{ System.out.println("Se consumieron los 8 intentos, ya lo siento");
}
}
}
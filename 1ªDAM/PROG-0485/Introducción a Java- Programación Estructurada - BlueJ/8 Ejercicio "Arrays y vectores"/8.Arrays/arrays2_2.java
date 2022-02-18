import java.util.Scanner;
public class arrays2_2
{
     public static void main(String[] args){
     int[] casillero = new int[10];
     System.out.println("Introduce 10 números enteros:");
     Scanner dime = new Scanner(System.in);
     for (int i=0; i<10; i++){ 
         casillero[i] = dime.nextInt();
    }
    //decreciente es que haya menor no que sean iguales. al revés igual
    //desordenado es el resto de opciones
    boolean dcreciente, creciente, igualico, desordenado;
    int c = 0, k = 0, m = 0;
    for(int j = 0; j <= 8; j++){       
        if (casillero[j] >= casillero[j + 1]){
        c =+ 1;    
        }
        if (casillero[j] <= casillero[j + 1]){
        k =+ 1;    
        }
        if (casillero[j] != casillero[j + 1]){
        m =+ 1;    
        }
            };
    creciente = (0 == c) ? true : false;
    dcreciente = (k == 0) ? true : false; 
    igualico = (m == 0) ? true : false; 
    if (creciente == true) {
        System.out.println("Son crecientes");
    }else if (dcreciente == true) {
        System.out.println("Son decrecientes");
    }else if (igualico == true) {
        System.out.println("Son todos iguales");
    }else{ System.out.println("Están desordenados sin más");}
    
}}

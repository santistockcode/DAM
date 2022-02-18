import java.util.Scanner;
public class array3_3DUDA
//ENUNCIADO: 
{
     public static void main(String[] args){
     Scanner dime = new Scanner(System.in);
     System.out.println("¿cúantos números por array?:");
     int tantascasillas = dime.nextInt();
     int[] casilleroc = new int[tantascasillas];  
    // ¿cómo hago para plantear mejor esta duda?¿no tengo acaso entornos de desarrollo al respecto? 
    for (int l = 0; l<casilleroc.length; l++){
     System.out.println(casilleroc[l]);};
}
}
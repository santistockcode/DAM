import java.util.Scanner;
public class arrays_1
{
     public static void main(String[] args){
     double[] casillero = new double[6];
     System.out.println("Introduce 6 números decimales:");
     Scanner dime = new Scanner(System.in);
    System.out.println("Introduce numeros mientras no sean 0 ");
    for (int i=0; i<6; i++){ 
    casillero[i] = dime.nextDouble();
    }
    System.out.println("Has introducido:");
    for(int j =0; j < 6; j++){
        System.out.println(casillero[j]);}
}}

import java.util.Scanner;
public class arrays_2
{
     public static void main(String[] args){
     double[] casillero = new double[6];
     System.out.println("Introduce 6 números decimales:");
     Scanner dime = new Scanner(System.in);
    for (int i=0; i<6; i++){ 
    casillero[i] = dime.nextDouble();
    }
    System.out.println("Has introducido:");
    for(int j = 5; j >= 0; j--){
        System.out.println(casillero[j]);}
}}

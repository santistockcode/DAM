import java.util.Scanner;
public class arrays_3
{
     public static void main(String[] args){
     int[] casillero = new int[10];
     System.out.println("Introduce 10 números enteros:");
     Scanner dime = new Scanner(System.in);
     for (int i=0; i<10; i++){ 
         casillero[i] = dime.nextInt();
    }
    
    int cpositivos=0, cnegativos=0, mpositivos=0, mnegativos=0, ceros=0;
   
    for(int j = 0; j < 10; j++){
        if (casillero[j] > 0){
            mpositivos = mpositivos + casillero[j];
            cpositivos = cpositivos + 1;
        }
        if (casillero[j] < 0){
            mnegativos = mnegativos + casillero[j];
            cnegativos = cnegativos + 1;
        }
        if (casillero[j] == 0){
            ceros = ceros + 1;
        }
    }
    if (cpositivos != 0){
        mpositivos = mpositivos / cpositivos;
        System.out.println("La media de positivos es "
        + mpositivos);}else{
        System.out.println ("No has introducido positivos");}
    if (cnegativos != 0){
        mnegativos = mnegativos / cnegativos;
        System.out.println("La media de negativos es "
        + mnegativos);}else{
        System.out.println("No has introducido negativos");}
    System.out.println ( "El número de ceros es "
    + ceros);}}

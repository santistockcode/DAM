
// contador de positivos, de negativos, de 0's, evalua el mayor, evalua el menor, y hay una media con un contador
import java.util.Scanner;
public class Ejercicio5
{
     public static void main(String[] args){
    //declaro variables
    int a, posit, negat, productorio, sumatorio, media, c;
    // pido un primer nuemero fuera
    Scanner dime = new Scanner(System.in);
    System.out.println("Introduce numeros mientras no sean 0 ");
    a = dime.nextInt();
    //evaluo todo fuera
    
  
    sumatorio = 0;
    productorio = 1;
    posit = 0;
    negat = 0;

   
    for(c = 1;a != 0; c++){
        //voy contando por cual voy
        //evaluo if else positivos negativos y 0
        if (a > 0){
        posit = posit + 1;
       }else if(a < 0){
         negat = negat + 1;  
       }
        //producto de todos
        if (a !=0){
        productorio = productorio * a;}
       // suma de todos 
       sumatorio = sumatorio + a;
       // pedir es gratis
       System.out.println(a + "\nIntroduce otro número");
       a = dime.nextInt();
    }
    //System.out.println("prueba" + c);
    media = sumatorio / c;
    System.out.println ("Positivos hay " + posit
    + ", negativos hay " + negat + ", la media de todos ellos es" + media +
    " y el producto de todos ellos es " + productorio + " y la suma de todos es "
    + sumatorio);
}}

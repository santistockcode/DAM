
// contador de positivos, de negativos, de 0's, evalua el mayor, evalua el menor, y hay una media con un contador
import java.util.Scanner;
public class Ejercicio3_conmedias
{
     public static void main(String[] args){
    //declaro variables
    int a, posit, negat, ziros, mayor, menor, sumatorio, media, c;
    // pido un primer nuemero fuera
    Scanner dime = new Scanner(System.in);
    System.out.println("Introduce numeros mientras sean mayores que (-30) ");
    a = dime.nextInt();
    //evaluo todo fuera
    
    mayor = a;
    menor = a;
    sumatorio = 0;
    posit = 0;
    negat = 0;
    ziros =0;
   
    for(c = 1;a >= -30; c++){
        //voy contando por cual voy
        //evaluo if else positivos negativos y 0
        if (a > 0){
        posit = posit + 1;
       }else if(a < 0){
         negat = negat + 1;  
       }else{
         ziros = ziros + 1;  
       }
        //evalua el menor
       menor = Math.min(menor, a); 
        //evalua el mayor
       mayor = Math.max(mayor, a);
       // suma de todos 
       sumatorio = sumatorio + a;
       // pedir es gratis
       System.out.println(a + "\nIntroduce otro número");
       a = dime.nextInt();
    }
    //System.out.println("prueba" + c);
    media = sumatorio / c;
    System.out.println ("El mayor es " + mayor + ", el menor es " + menor + ", ceros hay " + ziros + ", positivos hay " + posit
    + ", negativos hay " + negat + ", y la media de todos ellos es" + media);
}}

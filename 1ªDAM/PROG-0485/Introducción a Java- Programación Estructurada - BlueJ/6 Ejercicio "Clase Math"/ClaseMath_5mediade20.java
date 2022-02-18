
import java.util.Scanner;
public class ClaseMath_5mediade20
{
    public static void main (String[] args){
    Scanner dime = new Scanner(System.in);
    // declaro las variables
    double media, num, sumatorio;
    int c; //c de contador
System.out.print("Introduce 20 números. Los sumaré y te diré la media: \n");
    num = dime.nextDouble();   
    sumatorio = num;
    for (c = 1; c < 20; c++){
    System.out.print("Siguiente: \n");
    num = dime.nextDouble();
    sumatorio = sumatorio + num;
}  
media = sumatorio / 20;
System.out.print("Suman " + sumatorio + " y la media es " + media);
}
}

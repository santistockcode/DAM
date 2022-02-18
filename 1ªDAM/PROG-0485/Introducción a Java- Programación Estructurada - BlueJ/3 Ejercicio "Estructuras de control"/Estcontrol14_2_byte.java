
import java.util.Scanner;
public class Estcontrol14_2_byte
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
    byte x;
    System.out.println("Introduce un número x de tipo byte (de -128 a 127)");
    x = dime.nextByte();
    byte y;
    System.out.println("Introduce un número DISTINTO y de tipo byte (de -128 a 127)");
    y = dime.nextByte();
    byte menor = (x > y) ? y : x;
    if (x == y){
    System.out.println("Se trata del mismo número");
}                 System.out.println(menor);

}}

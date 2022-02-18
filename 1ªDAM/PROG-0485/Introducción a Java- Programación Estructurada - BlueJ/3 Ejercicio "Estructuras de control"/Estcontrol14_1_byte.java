
import java.util.Scanner;
public class Estcontrol14_1_byte
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
    byte x;
    System.out.println("Introduce un número x de tipo byte (de -128 a 127)");
    x = dime.nextByte();
    byte y;
    System.out.println("Introduce un número y de tipo byte (de -128 a 127)");
    y = dime.nextByte();
    if (x > y){
        final byte menor = y;
                        System.out.println(menor);

    }else if (y > x){
        final byte menor = x;
                System.out.println(menor);
    }else{
        System.out.println("Se trata del mismo número");
    }
}
}

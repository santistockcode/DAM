import java.util.Scanner;
import javax.swing.JOptionPane;
public class Ejercicio1_variables
{
	public static void main(String args[]){
        Scanner dime = new Scanner(System.in);
      	boolean _boolean;
      	char _char;
      	byte _byte;
      	short _short;
      	int _int;
      	long _long;
      	float _float;
      	double _double;
        System.out.println("Introduce boolean");
        _boolean = dime.nextBoolean();
        System.out.println("Introduce char");
        _char = dime.next().charAt(0); /*lo miré en internet*/
        System.out.println("Introduce byte");
        _byte = dime.nextByte();
        System.out.println("Introduce short");
        _short = dime.nextShort();
        System.out.println("Introduce int");
        _int = dime.nextInt();
        System.out.println("Introduce long");
        _long = dime.nextLong();
        System.out.println("Introduce float (con coma)");
        _float = dime.nextFloat();
        System.out.println("Introduce double");
        _double = dime.nextDouble();
        JOptionPane.showMessageDialog(null, "Esto es lo que has introducido: " + 
        _boolean + " " +
        _char + " " +
        _byte+ " " +
        _short+ " " +
        _int+ " " +
        _long+ " " +
        _float+ " " +
        _double+ " "
        );
        
        
    }
}

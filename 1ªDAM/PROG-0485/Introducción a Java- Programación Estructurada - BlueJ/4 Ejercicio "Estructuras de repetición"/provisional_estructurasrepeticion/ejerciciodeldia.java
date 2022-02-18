/* tendré que terminar de ver la clase de entornos y entregr programación esta
 * tarde y preparar las clases de mañana
 */
import java.util.Scanner;
public class ejerciciodeldia
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
      	String quedeque;
        _int = 3;
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
        System.out.println("Introduce una frase");
        quedeque = dime.nextLine();
        
      	System.out.println( "Has introducido estos datos:" + 
      	_boolean + " " +
      	_char + " " +
      	_byte+ " " +
      	_short+ " " +
      	_int+ " " +
      	_long+ " " +
      	_float+ " " +
      	_double+ " " +
      	quedeque
      	);
	}}

 
    /*char _char;
    byte _byte;
    short _short;
    int _int;
    long _long;
    float _float;
    double _double;
    String _frase;*/
    /*y encima una frase que no sé muy bien como va, creo que declara la 
       clase String o algo así*/
    /*Scanner dime = new Scanner(System.in);
    System.out.println("Introduce una frase ");
    String str= dime.nextLine(); 
    System.out.println("Introduce un byte");
    _byte = dime.nextLine(); (parse in de qué)
    _byte parsein;*/
  
    


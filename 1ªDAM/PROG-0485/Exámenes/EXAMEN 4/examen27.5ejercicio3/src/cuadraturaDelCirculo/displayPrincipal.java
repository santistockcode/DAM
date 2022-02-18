package cuadraturaDelCirculo;

import java.util.Scanner;

public class displayPrincipal {

	public static void main(String[] args) {
		
		NumeroComplejo numerocomplejo2 = new NumeroComplejo(0,0);
		NumeroComplejo numerocomplejoc = new NumeroComplejo(0,0);
		NumeroComplejo numerocomplejo1 = new NumeroComplejo(0,0);
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		
		//Menú
		do {
			System.out.println("------Menú principal------");
			System.out.println("\n 1.Sumar dos números complejos"
					+ "\n 2.Multiplicar dos núumeros complejos" 
					+ "\n 3.comparar 2 números complejos"
					+ "\n 4.Multiplicar un número complejo por un entero");
			opcion = sc.nextByte();
			
			switch(opcion) {
			case 1 :
				System.out.println("parte real del primer número:");
				numerocomplejo1.setA(sc.nextDouble());
				System.out.println("parte imaginaria del primer número:");
				numerocomplejo1.setB(sc.nextDouble());
				System.out.println("parte real del segundo número:");
				numerocomplejo2.setA(sc.nextDouble());
				System.out.println("parte imaginaria del segundo número:");
				numerocomplejo2.setB(sc.nextDouble());
				numerocomplejoc.setA(numerocomplejo1.getA() + numerocomplejo2.getA());
				numerocomplejoc.setB(numerocomplejo1.getB() + numerocomplejo2.getB());
				mostrarcomplejo(numerocomplejoc);
				break;
				//Haría lo mismo con la resta
			case 2:
				
				break;
				
			case 3:
				System.out.println("por terminar");
				break;
				
			case 4: 
				System.out.println("por terminar");
				break;
				
			case 5:
				System.out.println("Ciaoo");
				break;
				
			default:
				System.out.println("Eso no es una opción");
				break;
			}
		}while (opcion != 5);
		
		
	}//FIN DEL MAIN
	
	public static void mostrarcomplejo (NumeroComplejo numerocomplejoc) {
		System.out.println("Respuesta: " + numerocomplejoc.getA() + " + " + numerocomplejoc.getB() + "i");
	}
}

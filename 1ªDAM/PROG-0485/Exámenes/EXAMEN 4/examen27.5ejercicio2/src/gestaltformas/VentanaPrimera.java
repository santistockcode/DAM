package gestaltformas;

import java.util.Scanner;

/**
 * En la calse main o principal además de instanciar objetos, deberás crar un método qu reciba como parámetro un
 * array de triángulos y nos devuelva el área del triángulo de mayor superficie
 * @author santi
 *
 */
public class VentanaPrimera {

	public static void main(String[] args) {
		
		//atributos
		int ntriangulos, indice;
		Scanner sc = new Scanner(System.in);
		double lado, base;
		
		//metodos y constructores en el método 
		ntriangulos= pedirNtriangulos();
		Triangulo settriangulos [ ] = new Triangulo[ntriangulos];
		
		//peticion de datos
		for (int i=0; i < ntriangulos; i++) {
			sc.nextLine();
			
			System.out.println("Triangulo número " + (i+1));
			
			System.out.println("Lado:");
			
	        lado = Double.parseDouble(sc.nextLine());

			System.out.println("Base:");
	        base = Double.parseDouble(sc.nextLine());

			settriangulos[i] = new Triangulo(lado, base);
		}
		
		//A ver como está ese metodo que le meto por parametro un array
		
		System.out.println("El area de mayor tamaño es de " + buscarAreaMayor(settriangulos));
		
	}//FIN DEL MAIN 

	public static int pedirNtriangulos() {
		Scanner sk = new Scanner(System.in);
		System.out.println("¿Cuantos triangulos hay?");
		return sk.nextInt();
	}
	
	public static double buscarAreaMayor(Triangulo settriangulos[]) {
		double area_empezar = 0;
		int indice = 0;
		
		for (int i = 0; i < settriangulos.length; i++) {
			if (settriangulos[i].calcuArea()>area_empezar){
				area_empezar = settriangulos[i].calcuArea();
				indice=i;
			}
		}
		return settriangulos[indice].calcuArea();
	}
	
	
}

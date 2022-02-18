package concesionario;

import java.util.Scanner;
public class ClasePrincipal {

	
	public static void main(String[] args) {
		// Atributos
		int ncoches, indice;
		Scanner sc = new Scanner(System.in);
		String marca, modelo;
		float precio;
	
	//Métodos 
	ncoches= pedirNcoches();
	Vehiculo coches [ ] = new Vehiculo[ncoches];
	
	//petición de datos
	for (int i=0; i < ncoches; i++) {
		sc.nextLine(); //por el problema del retorno de carro
		
		System.out.println("Coche número " + (i+1));
		
		System.out.println("Marca:");
		
		marca = sc.nextLine();

		System.out.println("Modelo:");
		modelo = sc.nextLine();

		System.out.println("Precio:");
		precio = sc.nextFloat();
		
		coches[i] = new Vehiculo(marca, modelo, precio);
	}
	
	indice = posicionCoche(coches);
	System.out.println(coches[indice].mostrarDatos());
	
	}//fin del main
	
	public static int pedirNcoches() {
		Scanner sk = new Scanner(System.in);
		System.out.println("¿Cuantos coches hay?");
		return sk.nextInt();
	}
	public static int posicionCoche(Vehiculo coches[]) {
		float precio_barato = coches[0].getPrecio();
		int indice = 0;
		
		for (int i = 1; i<coches.length; i++) {
			if (coches[i].getPrecio()<precio_barato) {
				precio_barato = coches[i].getPrecio();
				indice=i;
			}
		}
		return indice;	
	}
	
}

package System;

import java.util.Scanner;

import javax.swing.JOptionPane;

import concesionario.Vehiculo;



public class caraperro {

	public static void main(String[] args) {
		//Atributos
		boolean nuevocliente;
		Scanner sc = new Scanner(System.in);
		String nombre, apellido, dni;
		int ncuentas;
		//que va a preguntar nuevo cliente
		nuevocliente = preguntarNuevoCliente();
		//cómo no lo explicita el ejercicio voy a responder siempre con cliente nuevo
		int[][] matdamon = new int[2][50];
		//falta preguntar n_casillero
		Cliente actor [] = new Cliente[n_casillero];//cuantas cuentas tiene
		if (nuevocliente == false) {
		//introducir aquí lo que sea
		}else {
			matdamon[0][0] = Integer.parseInt(JOptionPane.showInputDialog("¿Tu dni sin letra?"));
			matdamon[1][0] = Integer.parseInt(JOptionPane.showInputDialog("¿Tu contraseña?"));
		};
		//petición de datos del cliente
		for (int i=0; i < n_casillero; i++) {
			sc.nextLine(); //por el problema del retorno de carro
			
			System.out.println("Datos bancarios");
			
			System.out.println("Nombre:");
			
			nombre = sc.nextLine();

			System.out.println("Apellido:");
			apellido = sc.nextLine();

			System.out.println("Dni:");
			dni = sc.nextLine();
			
			System.out.println("Numero de cuentas:");
			ncuentas = sc.nextInt();
			
			Cliente actor[i] = new Cliente(nombre, apellido, dni, ncuentas);
		}
		//PENDIENTE: ¿funciona con más de un cliente? 
		
		//que se despliegue un menú de ¿qué quiere hacer: ABRIR NUEVA CUENTA, consultar, sacarmeterdinero, salir?
		
		//que muestra los datos después de cada movida
		
		
	     
	    }//fin del main
		//polimorfismo de qué? 

public static boolean preguntarNuevoCliente() {
	int opcion = -1; 
	boolean nuevosino = false;
	do {
	int n = Integer.parseInt(JOptionPane.showInputDialog("\"¿Es un cliente nuevo? \\n 1-->Sí \\n 2-->No\""));
	switch(n) {
	case 1:
		nuevosino = true;
		break;
	case 2:
		nuevosino = false;
		break;
	default:
		System.out.println("Elige entre las opciones que se ofrecen");
		break;
	}
	}while (opcion>2);
	return nuevosino;
}
}



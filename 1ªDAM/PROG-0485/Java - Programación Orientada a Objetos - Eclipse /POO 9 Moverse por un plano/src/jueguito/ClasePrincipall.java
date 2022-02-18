package jueguito;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClasePrincipall {

	public static void main(String[] args) {

		//Atributos
	    int x = Integer.parseInt(JOptionPane.showInputDialog("Posición inicial de x"));
	    int y = Integer.parseInt(JOptionPane.showInputDialog("Posición inicial de y"));
	    boolean quit = false; //Atributo para dejar de preguntar
	    Scanner sc = new Scanner(System.in);
	    Tablero jueguito = new Tablero (x, y); //Tengo que crear una instancia de la clase Tablero
	    
	    //Mostrar el menú
    	System.out.println("Las opciones son \n");
    	System.out.println("u de up \n");
    	System.out.println("d de down \n");
    	System.out.println("r de right \n");
    	System.out.println("l de left \n");
    	System.out.println("q de quit \n");
	    //Interacción menú
    	String eleccion;
    	while (quit == false) {
    		eleccion = sc.nextLine();
	    	switch(eleccion) {
	    	case "u":
	    		jueguito.moverArriba(1);
	    		jueguito.mostrarDatos();
	    		break;
	    	case "d":
	    		jueguito.moverAbajo(1);
	    		jueguito.mostrarDatos();
	    		break;
	    	case "r":
	    		jueguito.moverDerecha(1);
	    		jueguito.mostrarDatos();
	    		break;
	    	case "l":
	    		jueguito.moverIzquierda(1);
	    		jueguito.mostrarDatos();
	    		break;
	    	case "q":
	    		System.out.println("Ok Ciao!");
	    		quit = true;
	    		break;
	    	default:
	    		System.out.println("Introduce uno de los valores");
	    		break;
	    	}
  
    	}
	}}

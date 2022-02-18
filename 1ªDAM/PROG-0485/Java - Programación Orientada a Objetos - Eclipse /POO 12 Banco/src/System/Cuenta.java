package System;

import java.util.Scanner;

public class Cuenta extends Cliente{
//Atributos
	int ncuentas;
//constructor, creo que más facil, una cuenta se guarda en un array ncuenta-saldo
Scanner sc = new Scanner(System.in);
private int matriz[][]=new int[2][ncuentas];
public Cuenta (String nombre,
		String apellido,
		String dni, 
		int ncuentas
		) {
	super(nombre, apellido, dni);
	this.ncuentas=ncuentas;
}
public void setMatriz(int[][] matriz) {
	this.matriz = matriz;
}
public int[][] getMatriz() {
	return matriz;
}
//casillero ncuentas de dos dimensiones
//int matriz[][] = new int[2][ncuentas]

public void pedirDatos(){
}


//MUCHO MÁS FACIL: 
//http://www.iitk.ac.in/esc101/08Jan/Solutions/lab8/thursday/mat_op.java
}

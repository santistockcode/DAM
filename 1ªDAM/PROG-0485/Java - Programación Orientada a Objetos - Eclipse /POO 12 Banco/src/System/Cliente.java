package System;

import javax.swing.JOptionPane;

public class Cliente {
private String nombre;
private String apellido;
private String dni;

//las contraseñas son algo también funcional
//lo mismo pasa con los id de cuentas, por eso hay que tener o bien
//una matriz para idcuenta y saldo o bien
//un array aquí con idcuenta y una matriz en cuentas para ver saldos correctaente
public Cliente (
		String nombre,
		String apellido,
		String dni)
		{
	this.nombre=nombre;
	this.apellido=apellido;
	this.dni=dni;
}
public String getNombre() {
	return nombre;
}
public String getApellido() {
	return apellido;
}
public String getDni() {
	return dni;
}
public double consultar_saldo(int n) {
 //return double saldo
}
public static void ingresar_dinero(int n, double cantidad) {
	
}
public static void sacar_dinero(int n, double cantidad) {
	
}
}

//ME QUEDO EN:
//¿cómo reflejo que un banco tiene muchos clientes? 



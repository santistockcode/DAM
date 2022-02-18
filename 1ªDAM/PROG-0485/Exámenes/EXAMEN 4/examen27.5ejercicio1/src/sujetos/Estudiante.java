package sujetos;

public class Estudiante extends Persona{
	//	Atributos

	private int CodigoEstudiante; //aunque el símbolo de delante no se ve muy bien
	private float notaFinal; 
	
	//constructor y métodos
	public Estudiante (String nombre, String dni, double peso, edad) {
		super(nombre, dni, peso, edad); 
		this.CodigoEstudiante=CodigoEstudiante;
		this.notaFinal=notaFinal; 
	}
	@Override
	public getNombre() {
		return nombre;
	}
	@Override
	public getDNI() {
		return dni;
	}
	//para mostrar Datos no necesito @Override porque ya lo llevarán los getters pertinentes;
	public void mostrarDatos() {
		
	}
}

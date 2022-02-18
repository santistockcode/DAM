package Herencia;

public class Persona {
//Atributos
	private String nombre;
	protected String apellidos;
	private int edad;
	
//Métodos nenu
	public Persona(String nombre, String apellidos, int edad) {
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public int getEdad() {
		return edad;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}

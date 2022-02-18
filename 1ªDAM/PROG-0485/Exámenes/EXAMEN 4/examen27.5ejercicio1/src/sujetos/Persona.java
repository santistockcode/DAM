package sujetos;

public class Persona {

	//Atributos
	private String dni;
	private String nombre;
	protected double peso;
	edad; //default, package
	
	//Métodos
	public Persona(String dni, String nombre, double peso) {
		this.dni=dni;
		this.nombre= nombre;
		this.peso=peso;
	}
	public String getDNI() {	
		return dni;
	}
	public String getNombre{	
		return nombre;
	}//aunque no lleve parámetros escribiríamos getNombre() y un return
	public double getPeso{	
		return peso;
	}//lo mismo
	public  void mostrarDatos() {
	}
}

package Herencia;

public class Estudiante extends Persona{
//Atributos
	private int codigoEstudiante;
	private float notaFinal;
	
//Métodos
	public Estudiante(String nombre,
			String apellidos,
			int edad,
			int codigoEstudiante,
			float notaFinal) {
		super (nombre, apellidos, edad);
		this.codigoEstudiante = codigoEstudiante;
		this.notaFinal = notaFinal;
	}
	@Override
		public String getNombre() {
			// TODO Auto-generated method stub
			return super.getNombre();
		}
	@Override
		public String getApellidos() {
			// TODO Auto-generated method stub
			return super.getApellidos();
		}
	
	@Override
		public int getEdad() {
			// TODO Auto-generated method stub
			return super.getEdad();
		}
	public int getCodigoEstudiante() {
		return codigoEstudiante;
	}
	public float getNotaFinal() {
		return notaFinal;
	}
	public void mostrarDatos() {
		System.out.println("Nombre: " + getNombre());
		System.out.println("Apellidos " + apellidos);
		System.out.println ("\nEdad: " + getEdad() + "\nCódigo Estudiante: " + 
		codigoEstudiante + "\nNota Final: " + notaFinal);
	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}

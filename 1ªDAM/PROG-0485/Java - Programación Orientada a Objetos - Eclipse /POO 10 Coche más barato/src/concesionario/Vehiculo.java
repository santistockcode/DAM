package concesionario;

public class Vehiculo {
//Atributos
	private String marca;
	private String modelo;
	private float precio;
	
	
//Constructor y métodos
	Vehiculo (String marca, String modelo, float precio){
		this.marca = marca;
		this.modelo= modelo;
		this.precio= precio;
	}
	public float getPrecio() {
		return precio;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void pedirNcoches() {
	}
	public String mostrarDatos(){
		return ("La marcas es " + getMarca() + "\n El modelo es " + getModelo() + " \nEl precio es " + getPrecio());
	}
}

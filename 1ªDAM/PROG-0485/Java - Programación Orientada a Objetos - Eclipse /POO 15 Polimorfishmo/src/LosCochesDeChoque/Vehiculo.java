package LosCochesDeChoque;

public class Vehiculo {
//Atributos
	protected String matricula;
	protected String marca;
	protected String modelo;
//Métodos y constructores
	public Vehiculo(
			String matricula,
			String marca,
			String modelo){
		this.marca=marca;
		this.modelo = modelo;
		this.matricula=matricula;
	}
	public String getMarca() {
		return marca;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getModelo() {
		return modelo;
	}
	public String mostrarDatos(){
		return ("La marcas es " + getMarca() 
		+ "\n El modelo es " + getModelo() 
		+ " \nEl precio es " + getMatricula()
		+ "\n--------------------");
	}
	
}

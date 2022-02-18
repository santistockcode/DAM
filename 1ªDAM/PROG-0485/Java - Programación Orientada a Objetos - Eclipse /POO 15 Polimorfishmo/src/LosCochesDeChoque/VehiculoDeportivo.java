package LosCochesDeChoque;

public class VehiculoDeportivo extends Vehiculo{
//Atributos
	private int cilindrada;
//constructor y métodos
	public VehiculoDeportivo (String matricula,
			String marca,
			String modelo,
			int cilindrada) {
		super(marca,modelo,matricula);
		this.cilindrada = cilindrada;
	}
	public int getCilindrada() {
		return cilindrada;
	}
	public String mostrarDatos(){
		return ("La marcas es " + getMarca() 
		+ "\n El modelo es " + getModelo() 
		+ "\nEl precio es " + getMatricula()
		+ "\n y tiene una cilindrada de " + getCilindrada()
		+ "\n------------------");
	}
	
}

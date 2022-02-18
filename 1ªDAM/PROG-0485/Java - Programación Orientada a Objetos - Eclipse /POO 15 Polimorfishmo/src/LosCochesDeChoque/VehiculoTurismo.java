package LosCochesDeChoque;

public class VehiculoTurismo extends Vehiculo {
	//Atributos
		private int numeroPuertas;
	//constructor y métodos
	public VehiculoTurismo (String matricula,
				String marca,
				String modelo,
				int numeroPuertas) {
			super(marca,modelo,matricula);
			this.numeroPuertas = numeroPuertas;
		}
		public int getNumeroPuertas() {
			return numeroPuertas;
		}
		public String mostrarDatos(){
			return ("La marcas es " + getMarca() 
			+"\n El modelo es " + getModelo() 
			+ " \nEl precio es " + getMatricula() 
			+ "\n y tiene puertas: " + getNumeroPuertas()
			+ "\n--------------------");
		}
		
	}

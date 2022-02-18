package LosCochesDeChoque;

public class VehiculoFurgoneta extends Vehiculo{
	//Atributos
	private int carga;
	//constructor y métodos
	public VehiculoFurgoneta (String matricula,
				String marca,
				String modelo,
				int carga) {
			super(marca,modelo,matricula);
			this.carga=carga;
		}
	public int getCarga() {
			return carga;
	}
	public String mostrarDatos(){
		return ("La marcas es " + getMarca() 
		+ "\nEl modelo es " + getModelo() + 
		" \nEl precio es " + getMatricula() + 
		"\ny la carga es " + getCarga()
		+ "\n------------------");
	}		
}

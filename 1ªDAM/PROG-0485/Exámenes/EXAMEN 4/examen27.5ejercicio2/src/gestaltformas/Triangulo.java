package gestaltformas;
/**
 * Clase sobre un triángulo, he incluido el parámetro area.
 */
public class Triangulo {
	
	//Atributos
private double lado;
private double base;
private double perimetro;
private double area;

	//Constructores y métodos getters
	public Triangulo(
			double lado,
			double base){
		this.lado=lado;
		this.base=base;
	}
	public double getBase() {
		return base;
	}
	public double getLado() {
		return lado;
	}
	
	//métodos de sacar los valores calculados sobre las figuras
	public double calcuPerimetro() {
		this.perimetro = (lado * 2) + base;
		return perimetro;
	}
	public double calcuArea() {
		this.area = (base * Math.sqrt((Math.pow(lado, 2) - (Math.pow(base, 2) / 4)))) / 2;
		return area;
	}
}

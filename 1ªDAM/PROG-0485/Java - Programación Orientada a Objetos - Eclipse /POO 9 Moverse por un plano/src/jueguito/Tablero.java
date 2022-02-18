package jueguito;

public class Tablero {
//Atributos
	private int x;
	private int y;
	
//Métodos
	//Constructor
	public Tablero (int x, int y) {
	this.x = x;
	this.y=y;
	}
	//Métodos de movimiento (parecido a Set)
	public void moverArriba(int z) {
		y = y + z;
	}
	public void moverAbajo(int z) {
		y = y - z;
	}
	public void moverDerecha(int z) {
		x = x + z;
	}
	public void moverIzquierda(int z) {
		x = x - z;
	}
	//Métodos get
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	//Método para mostrar datos
	public void mostrarDatos() {
		System.out.println("Posición: (" + getX() + "),(" + getY() + ")");	
	}
		
}

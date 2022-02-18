package POO3;
import javax.swing.JOptionPane;

public class Operacion {
	int numero;
	int suma, resta, multiplicacion, division;

	public int sumar(int x, int y) {
		this.suma = x + y;
		return suma;
	}
	public int restar(int x, int y) {
		this.resta = x - y;
		return resta;
	}
	public int multiplicar(int x, int y) {
		this.multiplicacion = x * y;
		return multiplicacion;
	}
	public int dividir(int x, int y) {
		this.division = x / y;
		return division;
	}
	public void mostrarResultado() {
	}
}

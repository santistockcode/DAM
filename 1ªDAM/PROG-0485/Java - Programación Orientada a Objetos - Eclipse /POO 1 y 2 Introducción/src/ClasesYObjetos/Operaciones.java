package ClasesYObjetos;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Operaciones{
	
public static void main(String[] args) {	
	
		//atributos
			int suma;
			int resta;
			int multiplicacion;
			int division; 
			
			Operaciones op = new Operaciones() {
				
			pedirDatos.();
			op.sumar();
			}
			
}//cierre del main


	public void pedirDatos() {
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer número:"));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer número:"));
	}
	public void sumar() {
		int suma = num1 + num2;
	}
	
	public void restar() {
		resta = numero1-numero2;
	}
	
	public void multiplicar() {
		multiplicacion = numero1 * numero2;
	
	}
	public void dividir () {
	division = numero1 / numero2;
	}
	public void mostrarDatos() {
		System.out.println("Suman "+ suma);
		
		
	}
	 
	
}// cierre de la clase

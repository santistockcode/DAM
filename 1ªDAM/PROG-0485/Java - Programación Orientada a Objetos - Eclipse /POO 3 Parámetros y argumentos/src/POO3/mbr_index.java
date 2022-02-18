package POO3;

import javax.swing.JOptionPane;

public class mbr_index {

public static void main (String[] args) {
	Operacion op = new Operacion();

	int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer número: "));
	int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el segundo número: "));
	
	int suma = op.sumar(numero1, numero2);
	int resta = op.restar(numero1, numero2);
	int multiplicacion = op.multiplicar(numero1, numero2);
	int division =  op.dividir(numero1, numero2);
	op.mostrarResultado();	
	System.out.println("Resultados:" + "\n");
	System.out.println("Suma :" + suma);
	System.out.println("REsta :" + resta);
	System.out.println("Multiplicacion :" + multiplicacion);
	System.out.println("Division :" + division);
}
}


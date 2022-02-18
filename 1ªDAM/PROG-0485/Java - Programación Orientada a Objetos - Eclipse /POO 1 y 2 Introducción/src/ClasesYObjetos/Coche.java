package ClasesYObjetos;

public class Coche {
	//atributos
	String color;
	String marca;
	int km;
	
	//Método
	public static void main(String[] args) {
	
		Coche coche1 = new Coche();
		
		coche1.color = "Rojo";
		coche1.marca = "Ford";
		coche1.km = 0;
		
		System.out.println("El color del coche es: " + coche1.color);
		System.out.println("La marca del coche es: " + coche1.marca);
		System.out.println("Los kilómetros que tiene el coche son " + coche1.km);
	
		Coche coche2 = new Coche();
		
		coche2.color = "Verde";
		System.out.println("El color del segundo coche es"+ coche2.color);
	}
}

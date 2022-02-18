

public class claseMain {

	public static void main(String[] args) {
		
		Persona per1 = new Persona();
		per1.setEdad(28);
		per1.setAltura(1.7);
		per1.setDni("783629x");
		per1.setNombre("Carlos");
		System.out.println("La edad es: " + per1.getEdad());
		System.out.println("Se llama: " + per1.getNombre());
		System.out.println("Su DNI viene siendo: " + per1.getDni());
		System.out.println("Mide: " + per1.getAltura());
		
	}
}

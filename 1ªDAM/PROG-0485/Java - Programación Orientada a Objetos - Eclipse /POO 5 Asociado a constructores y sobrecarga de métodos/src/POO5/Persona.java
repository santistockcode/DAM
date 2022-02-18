package POO5;

public class Persona {

	
		private String nombre;
		private int _edad;
		private int _dni;
		private double _altura;
		private int km;
		
		
		//métodos constructores	
//		public Persona() {	
//		}//el de por defecto
//		public Persona(int _edad)
//		{
//		this._edad = _edad;
//		}
//		public Persona(double _altura) {
//		this._altura = _altura;
//		}
//		public Persona(int _dni) {
//		this._dni = _dni;
//		}
		public Persona (String nombre, int _edad, int _dni, double _altura, int _km) {
		this._dni=_dni;
		this.nombre = nombre;
		this._altura = _altura;
		this._edad = _edad;
		this.km = km;
		}
		//métodos
		public void correr(int _edad, int km) {
			System.out.println("Soy " + nombre + ", tengo " 
		+ _edad + " años y he corrido " + km + " km. y voy a correr " + 
					km + "km más");	
		}
		
}

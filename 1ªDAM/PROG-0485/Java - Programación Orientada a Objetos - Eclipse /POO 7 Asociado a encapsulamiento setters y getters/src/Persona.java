

public class Persona {
//Atributos
private String nombre;
private int edad;
private String dni;
private double altura;
//Método constructor
public Persona(){
}
public void setAltura(double altura) {
	this.altura = altura;
}
public void setDni(String dni) {
	this.dni = dni;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getAltura() {
	return altura;
}
public String getDni() {
	return dni;
}
public int getEdad() {
	return edad;
}
public String getNombre() {
	return nombre;
}

}

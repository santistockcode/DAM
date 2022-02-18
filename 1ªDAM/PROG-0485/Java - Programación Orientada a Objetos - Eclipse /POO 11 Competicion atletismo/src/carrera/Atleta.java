package carrera;

import java.util.Scanner;

public class Atleta {
	//Atributos
private int numeroAtleta;
private String nombre;
private float tiempoCarrera;

public Atleta(
		int numeroAtleta,
		String nombre,
		float tiempoCarrera) {
	this.numeroAtleta=numeroAtleta;
	this.nombre = nombre;
	this.tiempoCarrera= tiempoCarrera;
	
}
public float getTiempoCarrera() {
	return tiempoCarrera;
}
public String getNombre() {
	return nombre;
}
public String mostrarDatos(){
	return ("The winner is " + getNombre() + 
			"que ha tardado " + getTiempoCarrera()
		);
}

}


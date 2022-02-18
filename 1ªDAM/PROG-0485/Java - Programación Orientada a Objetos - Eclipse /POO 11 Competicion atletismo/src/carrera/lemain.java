package carrera;

import java.util.Scanner;

public class lemain {

	public static void main(String[] args) {
		// atributos
		int natletas, indice, numeroAtleta;
		String nombre;
		float TiempoCarrera;
		Scanner sc = new Scanner(System.in);
		
		//métodos
		natletas= Natletas();
		Atleta participantes [ ] = new Atleta[natletas];
		//petición de datos
		for (int i=0; i < natletas; i++) {
			System.out.println("Número de dorsal:");
			numeroAtleta = sc.nextInt();
			sc.nextLine();
			System.out.println("Nombre:");
			nombre = sc.nextLine();
			System.out.println("Tiempo que tarda:");
			TiempoCarrera = sc.nextFloat();
			
			participantes[i] = new Atleta(numeroAtleta, nombre, TiempoCarrera);
		}
		//mostrar los datos por pantalla
		indice = posicionatleta(participantes);
		System.out.println(participantes[indice].mostrarDatos());
}// fin del main


public static int Natletas() {
	Scanner sk = new Scanner(System.in);
	System.out.println("¿Cuantos atletas hay?");
	return sk.nextInt();
}
public static int posicionatleta(Atleta participantes[]) {
	float ganador_temporal = participantes[0].getTiempoCarrera();
	int indice = 0;
	
	for (int i = 1; i<participantes.length; i++) {
		if (participantes[i].getTiempoCarrera()<ganador_temporal) {
			ganador_temporal = participantes[i].getTiempoCarrera();
			indice=i;
		}
	}
	return indice;	
}
}

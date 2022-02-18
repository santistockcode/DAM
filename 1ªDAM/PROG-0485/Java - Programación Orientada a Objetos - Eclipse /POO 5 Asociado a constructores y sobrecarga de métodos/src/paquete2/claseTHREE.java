package paquete2;

import paquete1.claseONE;

public class claseTHREE {

	public static void main(String[] args) {
	claseONE objetorrr = new claseONE(); 
	//veo como me añade automaticamente import paquete1.claseONE
	
	objetorrr.atributo_por_defecto = 2; //distinto paquete por defecto, problemo
	objetorrr.atributo_con_public = 2; // distinto paquete + public, no problemo
	objetorrr.atributo_con_private = 2; // private = siempre problemo
	
	}

}

package paquete1;

public class claseTWO {

	public static void main(String[] args) {
	claseONE objetorrr = new claseONE();
	
	objetorrr.atributo_por_defecto = 2; //mismo paquete, no problemo
	objetorrr.atributo_con_public = 2;	//mismo paquuete + public, no problemo
	objetorrr.atributo_con_private = 2; //private aun mismo paquete, no 
	
	}
}

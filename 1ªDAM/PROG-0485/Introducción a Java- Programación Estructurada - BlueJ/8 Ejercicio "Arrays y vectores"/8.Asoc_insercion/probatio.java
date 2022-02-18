
import javax.swing.JOptionPane;
public class probatio {

	public static void main(String[] args) {
		int [] pepotes = {3,45,50,75,100,150,4096};
		int numerico = Integer.parseInt(JOptionPane.showInputDialog
				("¿Qué elemento quieres buscar?"));
		boolean encontrado = false;
		int posicion=0;
		for (int i = pepotes.length/2; i < pepotes.length && i >= 0;) {
            if (numerico == pepotes[i]) {
                encontrado = true;
                posicion = i;
                break;
            }else if (numerico > pepotes[i]) {
                i++;
            }else if (numerico < pepotes[i]) {
                i--;
            }
        };
   		if (encontrado == true) {
   			System.out.println("El número está en la posición " + (posicion+1));
   		}else{
   			System.out.println("No he encontrado ese número en este array pero ");
   			if (numerico > pepotes[pepotes.length-1]) {
   				System.out.print ("  es mayor que " + pepotes[pepotes.length-1]);
   			}else if(numerico < pepotes[0]) {
   				System.out.print (" es menor que " + pepotes[0]);
   			}else{
   			    System.out.println("Im'in motherfucker");
   				for (int j=0; j<(pepotes.length-2); j++){
   				if (pepotes[j] < numerico && numerico  < pepotes[j+1]) {
   					posicion = j;
   					break;
   				};
   				};
   			}
   			   				System.out.println("posición" + posicion);//cierre for
//cierre else
   		}//cierra else
	}//cierra main
}//cierra clas
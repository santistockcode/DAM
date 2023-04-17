import java.io.File;

public class UsoTransporte {

	public static void main(String[] args) {
	/*
	 * 	- Traverse and Show all the information about the trains in the file transport.xml
		- Add a new train to the DOM tree
		- Save the DOM tree in a file.
		- Delete a train knowing its id. Show a message to show success or failure if the train does not exist.
		- Find all the trains departing from one origin. The method must show the number of trains departing from that origin, and all the information of those trains. Show a message to show success or failure if the origin does not exist.
		- Do a method to show all the trains arriving to a destination after a given time
	 */
		AccesoTransporte a=new AccesoTransporte();
		File f=new File("transport.xml");
		a.openXMLtoDOM(f);
		a.traverseTransporte();
		
		a.addNewTrain("Alvia","KIX38","Moratalaz","Gandía", "10:80","20:35", 3.40);
		a.traverseTransporte();
		
		a.createFileTrenesFromDOM("TransportModificado.xml");
		
		a.deleteNode("LAV01");
		a.traverseTransporte();
		
		a.showTrenConDestino("Madrid Atocha");
		a.showTrenConDestino("Bilbao");
		
		a.showTrenesTardiosQue("17:30");


	}

}

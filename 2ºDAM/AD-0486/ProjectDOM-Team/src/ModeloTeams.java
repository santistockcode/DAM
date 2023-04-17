import org.w3c.dom.Document;

public class ModeloTeams {
	TeamDOM t=new TeamDOM();
	private Document doc1;
	public void leerContactos() {
	doc1 = t.openMenuToDom ("Team.xml");
	//y aquí se construiría team
	
	}
}

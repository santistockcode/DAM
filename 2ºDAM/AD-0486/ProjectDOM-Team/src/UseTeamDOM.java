
public class UseTeamDOM {

	public static void main(String[] args) {
		TeamDOM a=new TeamDOM();
		//a.openMenuToDom ("Team.xml");
		a.accessAndShow();
		a.insertPlayer("Pepito", 0);
		a.deleteNode("JOSE LOPEZ");
		a.deleteNode("Pedro Navaja");
		a.createFile("modificadoTeam");
		a.playersWithNoPoints();
	}

}

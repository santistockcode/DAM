package generated;

import java.io.File;

public class UseTeamJAXB {

	public static void main(String[] args) {
		TeamJAXB b=new TeamJAXB();
		b.accessAndShow();
		b.insertTeam("Pedro Navaja", 1);
		b.createXMLfromList("TeamUpdated");
		b.teamPoints();
		b.maxScorer();
		
	}

}

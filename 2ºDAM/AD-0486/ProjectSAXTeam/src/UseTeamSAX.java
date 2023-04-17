import java.io.File;

public class UseTeamSAX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fXML=new File("team.xml");
		TeamSAX a =new TeamSAX();
		a.openXMLwithSAX();
		a.traverseSAX(fXML);
	}

}

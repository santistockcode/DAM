package generated;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class TeamJAXB {
	JAXBContext contexto;
	Unmarshaller u;
	Team allPlayers;
	List <Player> lPlayers;
	File f=new File("Team.xml");
	
	public void accessAndShow() {
		//UNMARSHALLING: from the XML file, we fill the object allBooks and the list lBooks 
		try{
			
			//open the context
			 contexto=JAXBContext.newInstance(Team.class);
			//open the unmarshaller
			u=contexto.createUnmarshaller();
			//allBooks has all the info from the file
			allPlayers= (Team)u.unmarshal(f);
			String result="";//in result, we will concat the information from the XML
			lPlayers=allPlayers.getPlayer();//Create a list of Books with the method getBook()
			//System.out.println("Number of players:"+ lPlayers.size());

			for(int i=0;i<lPlayers.size();i++){
				result=result+"\n Player name: "+lPlayers.get(i).getName();
				result=result+"\n Player points: "+lPlayers.get(i).getPoints()+"\n-------------";
			}
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void insertTeam(String name, int points) {
		try {
		Player player1=new Player() ;//First we create an object Book
		
		player1.setName(name);
		player1.setPoints((byte)points);
		//add it to the list of books unmarshalled before
		lPlayers.add(player1);
		//book1 is now added to the list
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	public void createXMLfromList(String newFile) {
		//MARSHALLING: creating an XML file from a list of Books
			try {
			Marshaller m=contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);//to have indentations and lines
			m.marshal(allPlayers, System.out);//with System.out we will see it in the console
			m.marshal(allPlayers, new FileOutputStream(newFile));//we create the new file
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	public int teamPoints() {
		int contador = 0;
		for(int i= 0; i<lPlayers.size() ; i++) {
			contador = contador + lPlayers.get(i).getPoints();
			}
		System.out.println("Total TEAM points: " + contador);
		return contador;
		}
	
	public void maxScorer() {
		int contador = 0;
		String result = "";
		System.out.println("Finding max scorer-->");
		for(int i= 0; i<lPlayers.size() ; i++) {
			if (lPlayers.get(i).getPoints() > contador) {
				result = lPlayers.get(i).getName() + "\nPoints: " +  lPlayers.get(i).getPoints();
				contador = lPlayers.get(i).getPoints();
			}
		}
		System.out.println(result);
	}
}

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TeamDOM {
Document doc;

public Document openMenuToDom (String filename){
	try{
		System.out.println("Opening XML file and creating DOM ....");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringComments(true);
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder builder=factory.newDocumentBuilder();
		doc=builder.parse(filename);
		System.out.println("DOM created succesfully.");
		return doc;
	}catch(Exception e){
		System.out.println(e);
		return doc;
	}	
	}
public void accessAndShow() {
	try {
		System.out.println("\nINFORMATION\n--------------------");
		String[] data=new String[2];
		Node node=null;
		Node root=doc.getFirstChild();
		NodeList nodelist=root.getChildNodes(); 
		for(int i=0;i<nodelist.getLength();i++){			
			node=nodelist.item(i);//node has the childs of root by INDEX i
			if(node.getNodeType()==Node.ELEMENT_NODE){//for nodes <Book>				
				Node ntemp=null;
				int contador=0;
				NodeList nl2=node.getChildNodes();//get list of sub-child
				for(int j=0;j<nl2.getLength();j++){//iterate over the sub-child
					ntemp=nl2.item(j);
					if(ntemp.getNodeType()==Node.ELEMENT_NODE){						
						data[contador]=ntemp.getChildNodes().item(0).getNodeValue();
						contador++;
					}
				}		
			
			int player_n = (i+1)/2;
			System.out.println("Player nº " + player_n + ": " + data[0].toUpperCase() +"\nPoints: "+ 
					data[1]+ 
					"\n--------------------"); 
			}//
		}	
	}catch(Exception e) {
	System.out.println(e);
	e.printStackTrace();;//este código no me obliga a tratar los errores pero puede darlos que los xml son puñeteros
	}
}

public int insertPlayer(String name, int points) {
	try{
		//NAME
		Node nName=doc.createElement("name");
		Node nname_text=doc.createTextNode(name);
		nName.appendChild(nname_text);
		//POINTS
		Node nPoints=doc.createElement("points");
		String textpoints= String.valueOf(points);
		Node npoints_text=doc.createTextNode(textpoints);
		nPoints.appendChild(npoints_text);
		
		//UNIR LOS APENDICES A SU PLAYER
		Node nPlayer=doc.createElement("player");
		
		
		nPlayer.appendChild(nName); 
		nPlayer.appendChild(nPoints); 
		
		//APPEND FOOD TO THE ROOT
		Node raiz=doc.getFirstChild(); 
		raiz.appendChild(nPlayer);
		
		System.out.println("PLAYER added.");
		return 0;
		
	}catch(Exception e){
		System.out.println(e);
		return -1;
	}
}

public int deleteNode(String playerName) {
	System.out.println("Looking for the player "+playerName+" to delete it");
		try{
			//Node root=doc.getFirstChild();
			boolean deleted = false;
			Node root= doc.getDocumentElement();
			NodeList nl1=doc.getElementsByTagName("name");
			Node n1;
			for(int i=0;i<nl1.getLength();i++){
				n1=nl1.item(i);
					if (n1.getChildNodes().item(0).getNodeValue().equalsIgnoreCase(playerName)){
						System.out.println("Deleting the player "+playerName);
						//n1.getParentNode().removeChild(n1); //borra el nododeletes node <Title> tit </Title>, but leaves Book and Author
						n1.getParentNode().getParentNode().removeChild(n1.getParentNode());
						deleted = true;
					}
				}
			//]
			if (deleted == true) {
			System.out.println("Player deleted");
			}else {
			System.out.println("The playerr " + playerName + " isn't in the team");
			}			
			return 0;
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
			return -1;
		}
	}

void createFile(String newFile) {
	try {
		Source src = new DOMSource(doc); // Define the source
		StreamResult rst = new StreamResult(new File(newFile)); // Define the
		// Declare the Transformer. It has the method .transform() that we need.
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		// Option to indent the xml file
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		//depende de la versión de java puedo necesitar algo más
		transformer.transform(src, (javax.xml.transform.Result) rst);
		System.out.println("File transformed from DOM successfully");
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	//corrección, aquí no he controlado que las tabulaciones sean correctas
}

public int playersWithNoPoints() {
	try{
	//Node root= doc.getDocumentElement();
	NodeList nl1=doc.getElementsByTagName("points");
	Node n1=null;
	int cuantosPlayers = 0;
	System.out.println("Finding players with 0 points--> ");
	for(int i=0;i<nl1.getLength();i++){
		n1=nl1.item(i);	
		int number = Integer.parseInt(n1.getChildNodes().item(0).getNodeValue());
			if (number == 0){
				cuantosPlayers++;
				Node n1Parent;
				n1Parent= n1.getParentNode();
				NodeList parentChildren =n1Parent.getChildNodes();
				Node n3;
				for(int j=0; j<parentChildren.getLength();j++) {
					n3=parentChildren.item(j);
					if(n3.getNodeType()==Node.ELEMENT_NODE) {
						System.out.println(n3.getNodeName() +":" +  n3.getTextContent());
					} 
				}
			}
}
	System.out.println("Total players with 0 points: " + cuantosPlayers);
	return cuantosPlayers;
	}catch(Exception e){
	System.out.println(e);
	e.printStackTrace();
	return -1;
}
}

}

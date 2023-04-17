import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LabExercisesMenuDom {
	Document doc;
	public int openMenuToDom (String filename){
		try{
			//File f = new File(filename); //coge bien filename, esto no es necesario aquí 
			System.out.println("Opening XML file and creating DOM ....");
			//new object DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//ignore comments and white spaces
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			//DocumentBuilder will have the DOM loaded when we parse the xml file
			DocumentBuilder builder=factory.newDocumentBuilder();
			doc=builder.parse(filename);
			//now doc points to the DOM tree and we can traverse it.
			System.out.println("DOM created succesfully.");
			return 0;//if the method works
		}catch(Exception e){
			System.out.println(e);
			return -1;//if the method fails
		}	
		}
	
	public void removeNode(String foodName, String newPrice)
    {
		Node root= doc.getDocumentElement();
		NodeList nl1=doc.getElementsByTagName("name");
		NodeList nl2=doc.getElementsByTagName("price");

		Node n2=null;
		Node n1=null;
		for(int i=0;i<nl1.getLength();i++){
			n1=nl1.item(i);
			n2=nl2.item(i);
				if (n1.getChildNodes().item(0).getNodeValue().equals(foodName)){
					n2.getChildNodes().item(0).setNodeValue(newPrice);
				}}
    }


	public void traverseDOMandShow() {
		try {
			String[] data=new String[4]; //vamos a sacar cuatro campos
			Node node=null;
			Node root=doc.getFirstChild();
			NodeList nodelist=root.getChildNodes(); //coge las comidas en cuestión
			//traverse or loop through DOM tree
			
			System.out.println("MY RESTAURANT MENU: \n");
			for(int i=0;i<nodelist.getLength();i++){
			
				
				node=nodelist.item(i);//node has the childs of root
				if(node.getNodeType()==Node.ELEMENT_NODE){//for nodes <Book>
					Node node2= null;
					int contador=0; 
					NodeList nl2=node.getChildNodes();//get list of sub-child
					for(int j=0;j<nl2.getLength();j++){//iterate over the sub-child
						node2=nl2.item(j);
						if(node2.getNodeType()==Node.ELEMENT_NODE){
							//to get the text of title and author, access the child node and getNodeValue()
							data[contador] = node2.getTextContent(); //hace lo mismo que lo de arriba
							contador++;
						}
					}
					int dish_n = (i+1)/2;
					System.out.println("Dish nº " + dish_n + ": " + data[0].toUpperCase() +"\nDescription: "+ 
							data[2]+"\nPrice: "+data[1] + "\nCalories: " + data[3] + 
							"\n--------------------"); 
				}//
			}	
		}catch(Exception e) {
		System.out.println(e);
		e.printStackTrace();;//este código no me obliga a tratar los errores pero puede darlos que los xml son puñeteros
		}


	}
	
/*
 * Void showFoodWithCaloriesUnder(int limitCalories): Shows the name and calories of
all the foods wich have less than the value of limitCalories.
 */
	void showFoodWithCaloriesUnder(int limitCalories) {
		Node root= doc.getDocumentElement();
		NodeList nl1=doc.getElementsByTagName("calories");
		Node n1=null;
		for(int i=0;i<nl1.getLength();i++){
			n1=nl1.item(i);
			int number = Integer.parseInt(n1.getChildNodes().item(0).getNodeValue());
				if (number < limitCalories){
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
}
}

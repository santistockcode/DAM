import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



public class AccessMenuDom {
Document doc;
/*
 * int openMenuToDOM(String filename)
 */
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
/*
 * int traverseMenuAndShow(): this shows all the information of the file in the
following way:
 */

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
 * int deleteFood(String foodName): deletes the node that has the foodName. If
foodName does not exist, it will show a message saying “The food …. Does not
exist”
 */
public int deleteNode(String foodName) {
	System.out.println("Looking for the food "+foodName+" to delete it");
		try{
			//Node root=doc.getFirstChild();
			boolean deleted = false;
			Node root= doc.getDocumentElement();
			NodeList nl1=doc.getElementsByTagName("name");
			Node n1;
			for(int i=0;i<nl1.getLength();i++){
				n1=nl1.item(i);
					if (n1.getChildNodes().item(0).getNodeValue().equals(foodName)){
						System.out.println("Deleting the food "+foodName);
						//n1.getParentNode().removeChild(n1); //borra el nododeletes node <Title> tit </Title>, but leaves Book and Author
						n1.getParentNode().getParentNode().removeChild(n1.getParentNode());
						deleted = true;
					}
				}
			//]
			if (deleted == true) {
			System.out.println("Food deleted");
			}else {
			System.out.println("The food " + foodName + ", does not exist.");
			}
			
			//Keep the DOM tree in a new file (to keep our original file)
			//saveDOMasFile("DeletedBooks.xml");
			
			return 0;
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
			return -1;
		}
	}
/*
 * int addFood(String name,String price,String description,int calories): adds a
node &lt;food&gt; …..&lt;/food&gt; to the DOM tree with the information of the
arguments
 */
public int addFood(String name, String price,String description, int calories) {
	try{
		//NAME
		Node nname=doc.createElement("name");
		Node nname_text=doc.createTextNode(name);
		nname.appendChild(nname_text);
		//PRICE
		Node nprice=doc.createElement("price");
		Node nprice_text=doc.createTextNode(price);
		nprice.appendChild(nprice_text);
		//DESCRIPTION
		Node ndescription=doc.createElement("description");
		Node ndescription_text=doc.createTextNode(description);
		ndescription.appendChild(ndescription_text);
		//CALORIES
		Node ncalories=doc.createElement("calories");
		String textcalories= String.valueOf(calories);
		Node ncalories_text=doc.createTextNode(textcalories);
		ncalories.appendChild(ncalories_text);
		
		//UNIR LOS APENDICES A SU FOOD
		Node nfood=doc.createElement("food");
		
		
		nfood.appendChild(nname); 
		nfood.appendChild(nprice); 
		nfood.appendChild(ndescription);
		nfood.appendChild(ncalories); 
		
		//APPEND FOOD TO THE ROOT
		Node raiz=doc.getFirstChild(); 
		raiz.appendChild(nfood);
		
		System.out.println("FOOD added.");
		return 0;
	}catch(Exception e){
		System.out.println(e);
		return -1;
	}
}
/*
 * void createFileMenuFromDOM(String fileName): creates a new xml file from
the DOM tree in memory (you can use the classes Serializer or Transformer)
 */
void createFileMenuFromDOM(String fileName) {
	try {
		Source src = new DOMSource(doc); // Define the source
		StreamResult rst = new StreamResult(new File(fileName)); // Define the
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

/*
 * int findMenuContaining(String partialName): shows all the information of the foods
that contain “partialName” in the name. The int returned is the number of foods that
you have found.
 */
int findMenuContaining(String partialName) {
	System.out.println("Looking for the food that contains "+partialName);
	try{
		int nFoodFounds = 0;
		//Node root=doc.getFirstChild();
		boolean found = false;
		NodeList nl1=doc.getElementsByTagName("name");
		Node n1;
		for(int i=0;i<nl1.getLength();i++){
			n1=nl1.item(i);
			
				if (n1.getTextContent().contains(partialName)){
					nFoodFounds +=1;
					found = true;
					System.out.println("==============");
					System.out.println("FOOD CONTAINING " + partialName.toUpperCase()+":");
//					1 SE OBTIENE EL PADRE DE N1
//					2 AL PATER SACAR LOS HIJOS
//					3 A TODOS LOS HIJOS, EXTRAER EL TEXTO
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
					}//
//					OTRA FORMA DE HACERLO ES CON LOS SIBLINGS 
//					System.out.println(n1.getNodeName()+ ": " + n1.getTextContent());
//					Node sibling;
//					sibling = n1.getNextSibling();
//					while(sibling.getNodeType()==Node.ELEMENT_NODE) {
//						System.out.println(sibling.getNodeName() + ": " + sibling.getTextContent());
//						
//					}
//					sibling=sibling.getNextSibling();
//				}
//				System.out.println("..................");
				
			}
		if (nFoodFounds == 0) {
		System.out.println("Food not found");
		return 0;
		}else {
		System.out.println("Ergo the food is in the menu");
		return nFoodFounds;
		}
			
	}catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
		return -1;
	}
}

/*
 * int updatePriceOf(String foodName, String newPrice): changes the price of the
foodName with the new one. If the foodName is not found, it shows a message saying
so.
 */
int updatePriceOf(String foodName, String newPrice) {
	System.out.println("Looking for the food that contains "+foodName + " TO CHANGE PRICE");
	try{
		boolean foundF=false;
		//Node root= doc.getDocumentElement();
		NodeList nl1=doc.getElementsByTagName("name");
		NodeList nl2=doc.getElementsByTagName("price");

		Node n2=null;
		Node n1=null;
		for(int i=0;i<nl1.getLength();i++){
			n1=nl1.item(i);
			n2=nl2.item(i);
				if (n1.getChildNodes().item(0).getNodeValue().equals(foodName)){
					n2.getChildNodes().item(0).setNodeValue(newPrice);
					foundF=true;
					break;
				}
				}//fin del for

				if (foundF == false) { //también se puede poner if(!found)
				System.out.println("Food not found");
				return 0;
				}else {
				System.out.println("Price changed");
				return 1;
				}	
			}catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
				return -1;
			}
}

void showFoodWithCaloriesUnder(int limitCalories) {
	try{
	//Node root= doc.getDocumentElement();
	NodeList nl1=doc.getElementsByTagName("calories");
	Node n1=null;
	System.out.println("Comidas con menos de " + limitCalories + " calorias");
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
					//Inés ha hecho una búsqueda anidada por nombre y por calorías 
					//y ha sacado solo las calorías y el nombre, que queda más ordenado. 
				}
			}
}
	}catch(Exception e){
	System.out.println(e);
	e.printStackTrace();
}
}
}

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;//for Document

import org.w3c.dom.Document;
import org.w3c.dom.*;//for Document

import java.util.*;
import java.io.*;//class File

public class AccessXMLDOM {
Document doc;
	
	
	public int openXMLtoDOM (File f){
	try{
		System.out.println("Opening XML file and creating DOM ....");
		//new object DocumentBuilder
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//ignore comments and white spaces
		factory.setIgnoringComments(true);
		factory.setIgnoringElementContentWhitespace(true);
		//DocumentBuilder will have the DOM loaded when we parse the xml file
		DocumentBuilder builder=factory.newDocumentBuilder();
		doc=builder.parse(f);
		//now doc points to the DOM tree and we can traverse it.
		System.out.println("DOM created succesfully.");
		return 0;//if the method works
	}catch(Exception e){
		System.out.println(e);
		return -1;//if the method fails
	}	
	}
	public void traverseDOMandShow() {
		try {
			String[] data=new String[3];
			Node node=null;
			Node root=doc.getFirstChild();
			NodeList nodelist=root.getChildNodes(); 
			//traverse or loop through DOM tree
			for(int i=0;i<nodelist.getLength();i++){
				
				node=nodelist.item(i);//node has the childs of root by INDEX i
				if(node.getNodeType()==Node.ELEMENT_NODE){//for nodes <Book>
					
					Node ntemp=null;
					int contador=1;
					//get the attribute “published”
					data[0]=node.getAttributes().item(0).getNodeValue();
					//get the values of the sub-child <Title> <Author>
					NodeList nl2=node.getChildNodes();//get list of sub-child
					for(int j=0;j<nl2.getLength();j++){//iterate over the sub-child
						ntemp=nl2.item(j);
						if(ntemp.getNodeType()==Node.ELEMENT_NODE){
							//to get the text of title and author, acces the child node and getNodeValue()
							data[contador]=ntemp.getChildNodes().item(0).getNodeValue();
		//data[contador] = node2.getTextContent(); //hace lo mismo que lo de arriba
							contador++;
						}
					}
					//the String array data[] has now the values we needed
				
				System.out.println(data[0]+"--"+data[2]+"--"+data[1]);
				}//
			}	
		}catch(Exception e) {
		System.out.println(e);
		e.printStackTrace();;//este código no me obliga a tratar los errores pero puede darlos que los xml son puñeteros
		}
	}
	public int addBookToDOM(String title, String author,String year) {
		try{
			//CREATE TITLE with the text in the middle

			System.out.println("Adding book to the DOM tree:"+title+";"+author+";"+year);
		
		
			Node ntitle=doc.createElement("Title");
			Node ntitle_text=doc.createTextNode(title);
			ntitle.appendChild(ntitle_text);
			//CREATE AUTHOR
			Node nauthor=doc.createElement("Author");
			Node nauthor_text=doc.createTextNode(author);
			nauthor.appendChild(nauthor_text);
			//CREATE BOOK, WITH THE ATTRIBUTE, TITLE AND AUTHOR
			Node nbook=doc.createElement("Book");
			nbook.appendChild(ntitle); 
			nbook.appendChild(nauthor); 
			//APPEND BOOK TO THE ROOT
			Node raiz=doc.getFirstChild(); 
			//también doc.getChildNodes().item(0)
			raiz.appendChild(nbook);
			System.out.println("Book added.");
			return 0;
		}catch(Exception e){
			System.out.println(e);
			return -1;
		}
	}
	public int deleteNode(String tit) {
		System.out.println("Looking for the book "+tit+" to delete it");
			try{
				//Node root=doc.getFirstChild();
				boolean deleted = false;
				Node root= doc.getDocumentElement();
				NodeList nl1=doc.getElementsByTagName("Title");
				Node n1;
				for(int i=0;i<nl1.getLength();i++){
					n1=nl1.item(i);
					//if(n1.getNodeType()==Node.ELEMENT_NODE){
					//no es necesario porque todo van a ser elementos aquí 
						if (n1.getChildNodes().item(0).getNodeValue().equals(tit)){
							System.out.println("Deleting the node <Book> with title "+tit);
							//n1.getParentNode().removeChild(n1); //borra el nododeletes node <Title> tit </Title>, but leaves Book and Author
							n1.getParentNode().getParentNode().removeChild(n1.getParentNode());
							deleted = true;
						}
					}
				//]
				if (deleted == true) {
				System.out.println("Node deleted");
				}else {
				System.out.println("Título " + tit + " no encontrado.");
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
	

			
}



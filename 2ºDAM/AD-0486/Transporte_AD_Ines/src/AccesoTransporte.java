import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;//for Document
import org.w3c.dom.*;//for Document

import java.util.*;
import java.io.*;//class File
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AccesoTransporte {
Document doc;

	public int openXMLtoDOM (File f){
		try{
			System.out.println("Opening XML file and creating DOM ....");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder builder=factory.newDocumentBuilder();
			doc=builder.parse(f);
			System.out.println("DOM created succesfully.");
			return 0;
		}catch(Exception e){
			System.out.println(e);
			return -1;
		}	
		}//FIN DEL OPEN XML TO DOM
	
	
	//Este método Traverse and Show all the information about the trains in the file transport.xml
	public void traverseTransporte() {
		try {
			String[] data=new String[7];
			Node node=null;
			
			Node root=doc.getFirstChild();
			NodeList nodelist=root.getChildNodes(); //AQUÍ todos los trenes 
			
			for(int i=0;i<nodelist.getLength();i++){
				node=nodelist.item(i);
				
				if(node.getNodeType()==Node.ELEMENT_NODE){//for nodes <train> by INDEX i
					Node ntemp=null;
					int contador=1;
					
					NodeList nl2=node.getChildNodes();//AQUÍ las propiedades de los trenes
					
					data[0]=node.getAttributes().item(0).getNodeValue();
					
					for(int j=0;j<nl2.getLength();j++){
						ntemp=nl2.item(j);
						
						if(ntemp.getNodeType()==Node.ELEMENT_NODE){
							//data[contador]=ntemp.getChildNodes().item(0).getNodeValue();
							data[contador] = ntemp.getNodeName() + ": " + ntemp.getTextContent() + "\n"; 
							contador++;
						}//fin del if anidado
					}//fin del for anidado					
					System.out.println(
				            "Train " + ((i+1)/2) + ":\n "
				            + Arrays.toString(data));
				    }//fin del primer if 
				}//fin del primer for
		}catch(Exception e) {
		System.out.println(e);
		e.printStackTrace();
		}
	}//FIN DE TRAVERSE AND SHOW
	
	//Este método añade un nuevo tren al árbol DOM
	public int addNewTrain(String tipo_tren, String id, String origen,String destino, String salida, String llegada, double precio) {
		try{
			//ID
			Node nodeid=doc.createElement("id");
			Node nide_text=doc.createTextNode(id);
			nodeid.appendChild(nide_text);
			//ORIGEN
			Node nodeorigen=doc.createElement("origin");
			Node norigen_text=doc.createTextNode(origen);
			nodeorigen.appendChild(norigen_text);
			//DESTINO
			Node nodedestino=doc.createElement("destination");
			Node ndestino_text=doc.createTextNode(destino);
			nodedestino.appendChild(ndestino_text);
			//SALIDA
			Node nodesalida=doc.createElement("departure");
			Node nsalida_text=doc.createTextNode(salida);
			nodesalida.appendChild(nsalida_text);
			//LLEGADA
			Node nodellegada=doc.createElement("arrival");
			Node nllegada_text=doc.createTextNode(llegada);
			nodellegada.appendChild(nllegada_text);
			//PRECIO
			Node nprecio=doc.createElement("price");
			String textprecio= String.valueOf(precio);
			Node nprecio_text=doc.createTextNode(textprecio);
			nprecio.appendChild(nprecio_text);	
			
			//UNIR LOS APENDICES A SU TREN
			Node ntrain=doc.createElement("train");
			
			ntrain.appendChild(nodeid); 
			ntrain.appendChild(nodeorigen); 
			ntrain.appendChild(nodedestino);
			ntrain.appendChild(nodesalida);
			ntrain.appendChild(nodellegada);
			ntrain.appendChild(nprecio); 
			
			//TIPO DE TREN
			Element elemento_tipo_tren = (Element) ntrain;
			elemento_tipo_tren.setAttribute("type", tipo_tren);
			
			//APPEND FOOD TO THE ROOT
			Node raiz=doc.getFirstChild(); 
			raiz.appendChild(ntrain);
			
			System.out.println("==============");
			System.out.println("TRAIN added. \n");
			return 0;
		}catch(Exception e){
			System.out.println(e);
			return -1;
		}
	}//FIN DE ADDNEWTRAIN

	//Este método crea un archivo con la nueva versión que hemos hecho del xml
	void createFileTrenesFromDOM(String fileName) {
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
	}//FIN CREATEFILETRENESFROMDOM
	
	//Este metodo elimina un tren según la id que le pasemos
	public int deleteNode(String id_aeliminar) {
		System.out.println("Looking for the train "+id_aeliminar+ " to delete it");
			try{
				boolean deleted = false;
				
				//Node root= doc.getDocumentElement();
				NodeList nl1=doc.getElementsByTagName("id");
				
				Node n1;
				for(int i=0;i<nl1.getLength();i++){
					n1=nl1.item(i);
				
						if (n1.getChildNodes().item(0).getNodeValue().equals(id_aeliminar)){
							System.out.println("Deleting the train "+id_aeliminar);
							n1.getParentNode().getParentNode().removeChild(n1.getParentNode());
							deleted = true;
						}//fin del if
					}//fin del for
				if (deleted == true) {
				System.out.println("==============");
				System.out.println("Tren eliminado \n");
				}else {
				System.out.println("==============");
				System.out.println("El tren con id " + id_aeliminar + " no existe. \n");
				}
				return 0;
				
			}catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
				return -1;
			}
		}//FIN DE DELETENODE
	
	//Este método muestra la información con los trenes con el destino que le pasemos y el número de trenes que van allí
	public int showTrenConDestino(String destino_elegido) {
		try{
			//Node root= doc.getDocumentElement();
			NodeList nl1=doc.getElementsByTagName("destination");
			Node n1=null;
			int total_contador = 0;
			
			System.out.println("==============");
			System.out.println("Trains with destination " + destino_elegido + " :");
			for(int i=0;i<nl1.getLength();i++){
				n1=nl1.item(i);
			
				if (n1.getChildNodes().item(0).getNodeValue().equalsIgnoreCase(destino_elegido)) {
					Node n1Parent;
					n1Parent= n1.getParentNode();
					NodeList parentChildren =n1Parent.getChildNodes();
					total_contador++;
					Node n3;
					
					System.out.println(n1Parent.getAttributes().item(0).getNodeValue());
					
					for(int j=0; j<parentChildren.getLength();j++) {

						n3=parentChildren.item(j);
						if(n3.getNodeType()==Node.ELEMENT_NODE) {
							System.out.println(n3.getNodeName() +":" +  n3.getTextContent());
						}//fin del if anidado
							
					}//fin del for anidado
				}//fin del if
			}//fin del for
			if (total_contador > 0) {		
				System.out.println("--.--.--.--.--.--");
				System.out.println("Número de trenes: " + total_contador + " \n");
				}else {		
				System.out.println("No hay trenes disponibles a " + destino_elegido + "\n");
				}
			return 0;
		}catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
		return -1;
	}
	}
	
	//Trenes que llegan más tarde que el horario pedido
	void showTrenesTardiosQue(String horario_pedido) {
		try{
		//Node root= doc.getDocumentElement();
		NodeList nl1=doc.getElementsByTagName("arrival");
		Node n1=null;
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime hora_pedida= LocalTime.parse(horario_pedido, myFormatObj);
		
		System.out.println("Trenes que lleguen más tarde de las " + horario_pedido);
		for(int i=0;i<nl1.getLength();i++){
			n1=nl1.item(i);

			LocalTime hora_concreta = LocalTime.parse(n1.getChildNodes().item(0).getNodeValue(), myFormatObj);
			
				if (hora_concreta.isAfter(hora_pedida)){
					Node n1Parent;
					n1Parent= n1.getParentNode();
					NodeList parentChildren =n1Parent.getChildNodes();
					Node n3;
					
					System.out.println(n1Parent.getAttributes().item(0).getNodeValue());
					
					for(int j=0; j<parentChildren.getLength();j++) {

						n3=parentChildren.item(j);
						if(n3.getNodeType()==Node.ELEMENT_NODE) {
							System.out.println(n3.getNodeName() +":" +  n3.getTextContent());
						}//fin del if anidado
					}
				}
			}
		}catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}
	}
}

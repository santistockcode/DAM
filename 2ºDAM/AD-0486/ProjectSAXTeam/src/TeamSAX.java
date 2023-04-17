import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class TeamSAX {

	TeamHandler sh;
	SAXParser parser;
		

	//Esto lo pasa de xml a SAX
	public int openXMLwithSAX(){
		try{
			
			
			SAXParserFactory factory=SAXParserFactory.newInstance();
			parser=factory.newSAXParser();
			sh =new TeamHandler();
			//sh.startDocument();
			return 0;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}

	}
	public void traverseSAX(File fXML){
		try{
			parser.parse(fXML, sh);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al parsear con SAX");
		}
	}


	}



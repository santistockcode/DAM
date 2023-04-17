import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class TeamHandler extends DefaultHandler{
	
	int lastElement;//used to know what type of tag is generating the event
	String result="";//stores the result. We will use it later
	
	public TeamHandler() {
		 lastElement=0;//
	}
	public void startDocument() {
		System.out.print("--TEAM--");
	}
	@Override
	public void startElement(String uri,String localName,String qName,Attributes atts) throws SAXException
	{
		if(qName.equals("name")){
			System.out.print("\n" + "Name: ");
			lastElement=1;
		}else if(qName.equals("points")){
			System.out.print("\n"+"Points: ");
			lastElement=2;		
		}
	}
	@Override
	public void endElement(String uri, String localName,String qName) throws SAXException{
		if(qName.equals("player"
				+ "")){
			System.out.println("\n-----------------------");
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException{
		String car=new String(ch,start,length);
		car=car.replaceAll("\t","");//cleans all tabs
		System.out.print(car);	}

}





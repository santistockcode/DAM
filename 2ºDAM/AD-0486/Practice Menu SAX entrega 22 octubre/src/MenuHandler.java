import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class MenuHandler extends DefaultHandler{
	
	int lastElement;//used to know what type of tag is generating the event
	String result="";//stores the result. We will use it later
	int countfoods = 1;
	
	public MenuHandler() {
		 lastElement=0;//
	}
	
	public void startDocument() {
		System.out.println("TODAY\'S WONDERFUL MENU");
	}
	@Override
	public void startElement(String uri,String localName,String qName,Attributes atts) throws SAXException{
		
		if(qName.equals("name")){
			System.out.print("Número " + countfoods + "\n "+"Name:");//we will know the value of Title later, in event characters
			lastElement=1;
			countfoods++;
		}else if(qName.equals("price")){
			System.out.print("\n "+"Price:");//we will know the value of Title later, in event characters
			lastElement=2;
			
		}else if(qName.equals("description")){
			System.out.print("\n "+"Description:");
			lastElement=3;
			
		}else if(qName.equals("calories")){
			System.out.print("\n "+"Calories:");
			lastElement=4;
			
		}
	}
	@Override
	public void endElement(String uri, String localName,String qName) throws SAXException{
		if(qName.equals("food"
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





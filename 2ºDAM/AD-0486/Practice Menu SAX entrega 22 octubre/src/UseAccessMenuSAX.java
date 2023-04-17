import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;

public class UseAccessMenuSAX {
	public static void main(String[] args) throws SAXException, IOException {

	File fXML=new File("menu.xml");
	AccessMenuSAX a =new AccessMenuSAX();
	a.openXMLwithSAX();
	a.traverseSAX(fXML);
}
}

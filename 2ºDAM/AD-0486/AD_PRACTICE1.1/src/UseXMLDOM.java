import java.io.File;
public class UseXMLDOM {

		public static void main(String[] args) {
			AccessXMLDOM a=new AccessXMLDOM();
			File f=new File("Books.xml");//we must have Books.xml in the right path
			a.openXMLtoDOM(f);	
			a.traverseDOMandShow();
		}
	}



package myBooks;

import java.io.File;
public class UseBooksJAXB {

	public static void main(String[] args) {
		BooksJaxb b=new BooksJaxb();
		File f=new File("Books.xml");
		b.openXMLwithJAXBandShow(f);
//		b.addBook("1930", "Poet in New York","Lorca");
//		b.addBook("1998","Harry Potter","JKRowking");
//		b.createXMLfromList("BooksAddedJAXB.xml");
		b.removeBook("don quixote");
		b.removeBook("crepusculo");
		b.findBooksby("Umberto eco");
		b.findBooksby("Carmen Mola");
		b.createXMLfromList("BooksAddedJAXB.xml");
	}

}


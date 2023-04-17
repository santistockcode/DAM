package myBooks;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import myBooks.*;
import java.io.*;
import java.util.List;

public class BooksJaxb {
	JAXBContext contexto;
	Unmarshaller u;
	BreakfastMenu allBooks;
	List <Book> lBooks;

	public void openXMLwithJAXBandShow(File f) {
		//UNMARSHALLING: from the XML file, we fill the object allBooks and the list lBooks 
		try{
			
			//open the context
			 contexto=JAXBContext.newInstance(BreakfastMenu.class);
			//open the unmarshaller
			u=contexto.createUnmarshaller();
			//allBooks has all the info from the file
			allBooks= (BreakfastMenu)u.unmarshal(f);
			String result="";//in result, we will concat the information from the XML
			lBooks=allBooks.getBook();//Create a list of Books with the method getBook()
			System.out.println("Number of books:"+ lBooks.size());
			//Extract the information with the methods of the class Book traversing the list lBooks
			for(int i=0;i<lBooks.size();i++){
				result=result+"\n Published in: "+lBooks.get(i).getPublished();
				result=result+"\n The Title is: "+lBooks.get(i).getTitle();
				result=result+"\n The author is: "+lBooks.get(i).getAuthor()+"\n-------------";
			}
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addBook(String year,String title,String author) {
		try {
		Book book1=new Book() ;//First we create an object Book
		book1.setAuthor(author);
		book1.setTitle(title);
		book1.setPublished(year);
		//add it to the list of books unmarshalled before
		lBooks.add(book1);
		//book1 is now added to the list
	}catch(Exception e){
		e.printStackTrace();
	}
	}

	public void createXMLfromList(String fileName) {
		//MARSHALLING: creating an XML file from a list of Books
			try {
			Marshaller m=contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);//to have indentations and lines
			m.marshal(allBooks, System.out);//with System.out we will see it in the console
			m.marshal(allBooks, new FileOutputStream(fileName));//we create the new file
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	
	public boolean removeBook (String tittle) {
		boolean encontrado=false;
		for(int i= 0; i<lBooks.size() ; i++) {
			if (tittle.equalsIgnoreCase(lBooks.get(i).getTitle())) {
				lBooks.remove(i);
				encontrado = true;
			}
		}
		if(encontrado) {
		System.out.println("Libro " + tittle + " eliminado correctamente");
		return true;
		}else {
		System.out.println("Libro not found");
		return false;
		}
		}
	
	
	public int findBooksby(String author) {
		int contador = 0;
		for(int i= 0; i<lBooks.size() ; i++) {
			if (author.equalsIgnoreCase(lBooks.get(i).getAuthor())) {
				//todo esto lo más facil es implementarlo sobreescribiendo el toString()
				String result="";		
				result=result+"\n Published in: "+lBooks.get(i).getPublished();
				result=result+"\n The Title is: "+lBooks.get(i).getTitle();
				result=result+"\n The author is: "+lBooks.get(i).getAuthor()+"\n-------------";
				System.out.println(result);
				contador++;
			}
		}
		if(contador == 0) {
			System.out.println("Sorry, no books by this author");
			return 0;
		}else {
			System.out.println("Se han encontrado " + contador + " libros by author " + author);
			return 1;
		}
	}


}

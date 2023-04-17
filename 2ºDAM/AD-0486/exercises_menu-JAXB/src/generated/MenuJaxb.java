package generated;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import java.io.*;
import java.util.List;

public class MenuJaxb {
	JAXBContext contexto;
	Unmarshaller u;
	BreakfastMenu allFoods;
	List <BreakfastMenu.Food> lFoods;

	public void openXMLwithJAXBandShow(File f) {
		//UNMARSHALLING: from the XML file, we fill the object allBooks and the list lBooks 
		try{
			
			//open the context
			 contexto=JAXBContext.newInstance(BreakfastMenu.class);
			//open the unmarshaller
			u=contexto.createUnmarshaller();
			//allBooks has all the info from the file
			allFoods= (BreakfastMenu)u.unmarshal(f);
			String result="";//in result, we will concat the information from the XML
			lFoods=allFoods.getFood();//Create a list of Books with the method getBook()
			System.out.println("Number of foods:"+ lFoods.size());
			//Extract the information with the methods of the class Book traversing the list lBooks
			for(int i=0;i<lFoods.size();i++){
				result=result+"\n Name: "+lFoods.get(i).getName();
				result=result+"\n Price: "+lFoods.get(i).getPrice();
				result=result+"\n Description: "+lFoods.get(i).getDescription();
				result=result+"\n Calories: "+lFoods.get(i).getCalories()+"\n-------------";
			}
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addFood(String name,String price,String description, int calories) {
		try {
		BreakfastMenu.Food food1=new BreakfastMenu.Food() ;//First we create an object Book
		food1.setName(name);
		food1.setPrice(price);
		food1.setDescription(description);
		short sCalories = (short) calories;
		food1.setCalories(sCalories); //he casteado a short porque así lo genera el jaxb
		//add it to the list of books unmarshalled before
		lFoods.add(food1);
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
			m.marshal(allFoods, System.out);//with System.out we will see it in the console
			m.marshal(allFoods, new FileOutputStream(fileName));//we create the new file
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	public void updatePrice (int increment) {
		for(int i= 0; i<lFoods.size() ; i++) {
			double precio;
			String newStr = lFoods.get(i).getPrice().replaceAll("[$]", "");
			newStr= newStr.trim();
			
			//Inés ha usado substring(1) que saca todo el string salvo esa posición
			precio = Double.parseDouble(newStr);
			precio = precio + (precio *(increment / 100));
			lFoods.get(i).setPrice(Double.toString(precio));
			}
		}
	
	
	
	public boolean deleteFood (String name) {
		boolean encontrado=false;
		for(int i= 0; i<lFoods.size() ; i++) {
			if (name.equalsIgnoreCase(lFoods.get(i).getName())) {
				lFoods.remove(i);
				encontrado = true;
			}
		}
		if(encontrado) {
		System.out.println("Food " + name + " eliminado correctamente");
		return true;
		}else {
		System.out.println("Food not found");
		return false;
		}
		}

}

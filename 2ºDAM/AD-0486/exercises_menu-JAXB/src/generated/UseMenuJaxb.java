package generated;

import java.io.File;



public class UseMenuJaxb {
	public static void main(String[] args) {
		MenuJaxb b=new MenuJaxb();
		File f=new File("Menu.xml");
		b.openXMLwithJAXBandShow(f);
		b.addFood("Paparajotes", "9.89", "Hojas de limonero fritas con masa", 200); 
		b.deleteFood("Belgian Waffles");
		b.updatePrice(20);
		b.createXMLfromList("FoodsModificado.xml");
}
}

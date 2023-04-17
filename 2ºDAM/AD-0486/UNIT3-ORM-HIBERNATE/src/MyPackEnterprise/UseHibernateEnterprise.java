package MyPackEnterprise;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class UseHibernateEnterprise {
	
	public static void main(String[] args) {
		
		LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
		
		HibernateEnterprise h=new HibernateEnterprise();
		HibernateEnterprise3_1 h31 =new HibernateEnterprise3_1();
		
			//MÉTODOS DE LA PRÁCTICA ANTERIOR************************** 
		
		//h.addProduct(9, "monitor",170);
		//h.addProduct(30, "teclado", 10);
		//HE AÑADIDO TAMBIÉN UN TECLADO
		//h.findProductById(9);
		//h.deleteProductById(9);
		//h.deleteProductById(25);//capturar el error
		//h.showProducts();
		//h.getProductsCheaperThan(100);
		//h.updateProductById(9, "monitor_updated", 150);
		//h.updateProductById(9, "teclado_updated", 10);
		//h.updateProductById(50, "objeto_no_encuentra", 5);
		//h.showProducts3_3();
		//h.showByName("teclado_updated");
		//h.productsOrderedByPrice();
		//System.out.println("cómo se llama el producto?");
		//Scanner in = new Scanner(System.in);
        //String s = in.nextLine();
		//h.priceOf(s);
		//h.findProduct(9);
		
			//MÉTODOS DE EJERCICIO 3.1**************************
		
		//h31.showClients();
		//h31.addClient(55, "Pedro", "Portugal");
		//h31.deleteClient(55);
		//h31.updateClient(2, "Margarita", "Portugal");
		//h31.deleteClient("Margarita");
		//h31.deleteClient("Rigoberta");
		//h31.updateClient(1);
		//h31.showByCountry("portugal");
		h31.countryOf("Amancio");
		
		h31.close();
		h.close();
	}
}
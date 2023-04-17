import java.io.File;

public class UseAccessMenuDOM {

	public static void main(String[] args) {
		AccessMenuDom a=new AccessMenuDom();
		a.openMenuToDom ("menu.xml");
//		a.traverseDOMandShow();
//		a.deleteNode("French Toast");
//		a.traverseDOMandShow();
//		a.addFood("Tostadas Francesas", "$2.7", "Torrijas pero peor", 100);
//		a.traverseDOMandShow();
		a.createFileMenuFromDOM("menuModificado.xml");
//		a.findMenuContaining("affles");
//		a.updatePriceOf("French Toast", "$100");
//		a.traverseDOMandShow();
//		a.showFoodWithCaloriesUnder(700);
		
		
		
	}

}
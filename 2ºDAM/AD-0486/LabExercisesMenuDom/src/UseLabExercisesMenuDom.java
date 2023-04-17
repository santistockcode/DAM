
public class UseLabExercisesMenuDom {

	public static void main(String[] args) {
		LabExercisesMenuDom a=new LabExercisesMenuDom();
		a.openMenuToDom ("menu.xml");
		a.traverseDOMandShow();
		//a.removeNode("French Toast", "456");
		//a.traverseDOMandShow();
		a.showFoodWithCaloriesUnder(700);

	}

}

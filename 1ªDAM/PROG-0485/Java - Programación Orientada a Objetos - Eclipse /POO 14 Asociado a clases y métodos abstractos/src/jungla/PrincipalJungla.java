package jungla;

public class PrincipalJungla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerVivo VeggieBasic = new AnimalHerbivoro();
		SerVivo animalcrossing = new Animal();
		SerVivo pokemonplanta = new Planta();
		SerVivo Carnazas = new AnimalCarnivoro();
		
		VeggieBasic.alimentarse();
		animalcrossing.alimentarse();
		pokemonplanta.alimentarse();
		Carnazas.alimentarse();
		
	}

}

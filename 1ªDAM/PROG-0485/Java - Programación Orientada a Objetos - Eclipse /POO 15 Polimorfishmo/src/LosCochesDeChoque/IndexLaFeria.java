package LosCochesDeChoque;

public class IndexLaFeria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehiculo loscoches[] = new Vehiculo[4];
		
		loscoches[0] = new Vehiculo("1111", "audi", "a1");
		loscoches[1] = new VehiculoDeportivo("2222", "beugot", "a2",2);
		loscoches[2] = new VehiculoTurismo("3333", "ceat", "a3",3);
		loscoches[3] = new VehiculoFurgoneta("444", "dolswagen", "a4", 4);
		
		for (int i = 0; i < loscoches.length; i++) {
		System.out.println(loscoches[i].mostrarDatos());
		}
	}

}

package psp_2eval_10_SAS_variosconsumidores;

public class Consumidor implements Runnable
{
    private final Cola cola;
    private final int idconsumidor;
 
    /**
     * Constructor de la clase
     * @param cola Contenedor común a los consumidores y el productor
     * @param idconsumidor Identificador del consumidor
     */
    public Consumidor(Cola cola, int idconsumidor) 
    {
        this.cola = cola;
        this.idconsumidor = idconsumidor;
    }
 
    @Override
    /**
     * Implementación de la hebra
     */
    public void run() 
    {
        //while(Boolean.TRUE)
        {
			for (int j = 0; j < 2; j++) {
				String ch = (String) cola.get();
				System.out.print(ch + "\n");
			}
		
		//System.out.println("\n---->El consumidor " + idconsumidor + " ha terminado");
        }
    }
}

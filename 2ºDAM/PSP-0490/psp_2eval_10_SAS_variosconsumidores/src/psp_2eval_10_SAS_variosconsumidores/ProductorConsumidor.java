package psp_2eval_10_SAS_variosconsumidores;

//fuente del código de partida: https://programaressencillo.wordpress.com/2014/11/25/java-monitores-ejemplo-productor-consumidor/


public class ProductorConsumidor 
{
    private static Cola cola;
    private static Thread productor;
    private static Thread [] consumidores;
    private static final int CANTIDADCONSUMIDORES = 2;
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        cola = new Cola();
        productor = new Thread(new Productor(cola, 1, "provatio.txt"));
        consumidores = new Thread[CANTIDADCONSUMIDORES];
        //si se declara como estáticos los parámetros si que parece que se pueden lanzar dos consumidores y van ordenados
        for(int i = 0; i < CANTIDADCONSUMIDORES; i++)
        {
            consumidores[i] = new Thread(new Consumidor(cola, i));
            consumidores[i].start();
        }
        productor.start();
    }    
}

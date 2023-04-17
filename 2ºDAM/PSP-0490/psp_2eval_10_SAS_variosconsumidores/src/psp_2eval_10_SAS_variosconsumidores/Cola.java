package psp_2eval_10_SAS_variosconsumidores;
public class Cola 
{
    private String contenido;
    private boolean contenedorlleno = Boolean.FALSE;
 
    /**
     * Obtiene de forma concurrente o síncrona el elemento que hay en el contenedor
     * @return Contenido el contenedor
     */
    public synchronized String get()
    {
        while (!contenedorlleno)
        {
            try
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        contenedorlleno = Boolean.FALSE;
        notify();
        return contenido;
    }
 
    /**
     * Introduce de forma concurrente o síncrona un elemento en el contenedor
     * @param linea Elemento a introducir en el contenedor
     */
    public synchronized void put(String linea) 
    {
        while (contenedorlleno) 
        {
            try
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        contenido = linea;
        contenedorlleno = Boolean.TRUE;
        notify();
    }
}

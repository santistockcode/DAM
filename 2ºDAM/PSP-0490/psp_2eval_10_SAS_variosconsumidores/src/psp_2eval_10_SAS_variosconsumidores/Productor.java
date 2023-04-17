package psp_2eval_10_SAS_variosconsumidores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Productor implements Runnable
{
    //private final Random aleatorio;
    private final Cola cola;
    private final int idproductor;
    private final int TIEMPOESPERA = 1500;
    private final String name_file;
	static BufferedReader reader = null; 

 
    /**
     * Constructor de la clase
     * @param cola Contenedor común a los consumidores y el productor
     * @param idproductor Identificador del productor
     */
    public Productor(Cola cola, int idproductor, String name_file) 
    {
        this.cola = cola;
        this.idproductor = idproductor;
		this.name_file = name_file;
    }
 
    @Override
    /**
     * Implementación de la hebra
     */
    public void run() 
    {
                   
            File file = new File(name_file);
			FileInputStream fileStream;
			try {
				//lee el archivo (solo una lìnea en este caso) 
				fileStream = new FileInputStream(file);
				InputStreamReader input = new InputStreamReader(fileStream);
				reader = new BufferedReader(input);
				String linea = reader.readLine();
				cola.put(linea);
                Thread.sleep(TIEMPOESPERA); //sin esta espera lo que sucede es que se superpone y en la consola parece que solo ha funcionado uuno de los consumidores
				cola.put(linea);
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("\n El productor " + idproductor + " pone letras");
            try
            {
                Thread.sleep(TIEMPOESPERA);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Productor " + idproductor + ": Error en run -> " + e.getMessage());
            }
       
    }
}

/**
 * Buscamos la media de alturas y edades, así como cuantas personas miden 
 * más de 1,75
 * Para practicar que solo he hecho uno por pantalla, lo voy a pedir por pantalla
 * @Santi
 * 
 */
// _double = Double.parseDouble(JOptionPane.showInputDialog("Un double: "));
//_int = Integer.parseInt(JOptionPane.showInputDialog("Un integer: "));

import javax.swing.JOptionPane;
public class Bucles2_10
{
    public static void main(String[] args){
    int alte, edad, sumaedad, mediaedad, contador;    
    double altura, sumaltura, medialtura;
    edad = Integer.parseInt(JOptionPane.showInputDialog("Edad de la persona 1:"));
    sumaedad = edad;
    //voy a pedir las edades en la variable edad y las alturas en la variable altura, para calcular fuera del bucle las medias. 
    for (contador = 1; contador < 5; contador++){
    sumaedad = sumaedad + edad;
    edad = Integer.parseInt(JOptionPane.showInputDialog("Edad de la persona" + (contador + 1) + ":"));
} 
    altura = Double.parseDouble(JOptionPane.showInputDialog("Altura de la persona 1 (introduce las alturas con punto, no con coma): "));
    sumaltura = altura;
    for (contador = 1, alte = 0; contador < 5; contador++){
    sumaltura = sumaltura + altura;
    altura = Double.parseDouble(JOptionPane.showInputDialog("Altura de la persona" + (contador + 1) + ":"));
    // alte es una variable que irá sumando cuantas personas miden más de 1,75.
    if (altura > 1.75){
        alte = alte + 1;
    }
}
mediaedad = sumaedad / 5;
medialtura = sumaltura / 5;
JOptionPane.showMessageDialog(null, "La media de edad es " + mediaedad + " y la media de altura es " + medialtura + ". Hay " + alte +
" personas que miden más de 1,75");
}
}


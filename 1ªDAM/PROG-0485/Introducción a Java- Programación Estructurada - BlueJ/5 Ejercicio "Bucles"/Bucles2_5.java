
public class Bucles2_5
{
    
    public static void main (String args[]){
    int npantalla;
    int primernumero = 100 + 7;
    npantalla = primernumero; 
    int contador; 
    /*se me ocurre usar un contador que vaya restando mĂșltiplos de 7
     * a la cifra inicial (por eso lo pongo como 100 + 7, por si cambio esa 
     * cifra inicial.
     */
    for(contador = 1; npantalla > 7; contador++){
    npantalla = primernumero - (7 * contador);
    System.out.println(npantalla); }
}}

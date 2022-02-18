
public class Operadores2_cilindro
{
    /* variable constante de PI */
    final double PI = 3.141592653589793;
    /*ahora definicmos qué vamos a "escribir" */
    public static void main(String[] args) 
    {
        /* variable constante de PI */
        final double PI = 3.141592653589793;
        /* declaramos e inicializamos la altura y el diametro */
        int diametro = 12;
        int altura = 45;
        int radio = diametro / 2;
        /*pedimos que se haga el cálculo de las nuevas variables area y 
         volumen
         */
        double area = 2 * PI * radio * (radio + altura);
        double volumen = PI * radio * radio * altura; 
        /* le pedimos que lo saque por pantalla */
        System.out.println("El area de un cilindro de diametro 12 cm y de altura 45 cm es " 
        + area + " cm cuadrados; y su volumen es " + volumen + " cm cubicos");
    }
}



public class Operadores1_rectangulo {

    /* este void se va a tragar los string que es como hablamos nosotros 
     con el programa */
    public static void main (String[] args) {
   /* esto es declarar e inicializar las variables altura y anchura */
    int anchura = 5; 
    int altura = 19;
    /* ahora vamos a inicializar unas variables nuevas para los resultados */
    int area = anchura * altura;
    int perimetro = (2 * anchura) + (2 * altura);
    System.out.println("El perimetro vale " + perimetro + 
    " y el area " + area);
}
}


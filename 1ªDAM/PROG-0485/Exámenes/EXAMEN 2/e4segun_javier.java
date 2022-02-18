
public class e4segun_javier
{
    public static void main (String[] args){
    int contador, cont_impares;
    contador = 0;
    cont_impares = 0;
    int[] impares = new int[5];
    while (cont_impares < 5){
    int numero = (int)(Math.random()*100);
    System.out.println(numero);
    if (numero % 2 == 0){
    contador = contador + 1;
}else{
    contador = contador + 1;
    impares[cont_impares]= numero;
    cont_impares = cont_impares + 1;
}}
System.out.println("Ha sacado 5 impares en solo " + contador + " intentos");
System.out.println ("Y los impares son ");
for(int i =0; i < impares.length; i++){
System.out.println (impares[i]);}
}}

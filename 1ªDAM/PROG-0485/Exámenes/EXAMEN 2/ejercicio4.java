
public class ejercicio4
{
    public static void main (String[] args){
    double numerico;
    int num, crono, c, resto;
    // c es un contador de impares
    // esto hace números
    numerico = Math.random();
    numerico = numerico * 100;
    num = (int) Math.round(numerico);
    System.out.println(num);
    c = 0;
    resto= num % 2;
    c = (resto == 1) ? (c + 1) : c;
    // primero como se evalua un impa
    for (crono = 1, c = 1; c <= 5; crono++){
    //if (num == 13){quesera = true;};
    resto= num % 2;
    c = (resto == 1) ? (c + 1) : c; //vuelvo a evaluar el número
    numerico = Math.random(); //vuelvo a hacer un número 
    numerico = numerico * 100;
    num = (int) Math.round(numerico);
    System.out.println(num);
}
System.out.println("Ha sacado 5 impares en solo " + crono + " intentos");
}}

import java.util.Scanner;
public class Estcontrol_11_cualdelos3eselmayor
{
public static void main (String[] args){      
Scanner dime = new Scanner(System.in);
//Declaro variables para los tres números
    int x;
    int y;
    int z;
//Pido los números al usuario
    System.out.println("Introduce tres números diferentes x, y, z.");
    x = dime.nextInt();
    y = dime.nextInt();
    z = dime.nextInt();
//Primero compruebo que son diferentes y luego los comparo
    if (x != y && y != z){
    if (x > y && y > z){
        System.out.println("El número " + x + " es el mayor de los 3");
    } 
    else if (y > z && z > x){
        System.out.println("El número " + y + " es el mayor de los 3");
    }
    else {
        System.out.println("El número " + z + " es el mayor de los 3");
    }
    }else{
        System.out.println("No has introducido tres números diferentes");
    }
}
}
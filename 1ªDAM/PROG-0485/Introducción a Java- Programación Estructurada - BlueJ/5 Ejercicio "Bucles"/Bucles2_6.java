import java.util.Scanner;
public class Bucles2_6
{
    public static void main(String[] args){
    int n1, contador;
    System.out.println("Introduce 10 notas");
    boolean aver;
    aver = true;
    Scanner dime = new Scanner(System.in);
    for (contador=0; contador < 10; contador++){
          n1 = dime.nextInt();
          if(n1 < 5){
              aver = false;
            }}
    if (aver == true){
    System.out.println("Todos aprobados");
    }else{System.out.println("Hay algún suspenso");}

}}
              

    

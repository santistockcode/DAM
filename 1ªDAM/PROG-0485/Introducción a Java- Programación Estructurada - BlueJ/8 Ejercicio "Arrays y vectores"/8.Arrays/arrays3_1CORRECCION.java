






//corrección tras el ejemplo de Ivan Camilo



import java.util.Scanner;
public class arrays3_1CORRECCION
{
     public static void main(String[] args){
     int[] casillero1 = new int[10];
     System.out.println("Introduce 10 números enteros:");
     Scanner dime = new Scanner(System.in);
     for (int i=0; i<10; i++){ 
         casillero1[i] = dime.nextInt();
    }
    int posicion = 0;
    boolean talcual = false;
    int numero;
    System.out.println("Introduce 10 números enteros:");
    numero = dime.nextInt(); 
    for(int i=0; i<10; i++){
            int k = casillero1[i];
            if(numero==k){
                posicion=(i+1);
                talcual=true;
                break;}
                
            }
    if(talcual){
        System.out.println("El número está en la posición" + posicion);
    }else{
        System.out.println("No mi ciela");
    }
            
            
  
    }
}
    
    
    
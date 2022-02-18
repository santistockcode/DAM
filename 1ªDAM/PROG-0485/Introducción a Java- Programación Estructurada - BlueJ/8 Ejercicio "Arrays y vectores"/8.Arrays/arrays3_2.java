import java.util.Scanner;
public class arrays3_2
{
     public static void main(String[] args){
     int[] casillero1 = new int[15];
     System.out.println("Introduce 15 números enteros:");
     Scanner dime = new Scanner(System.in);
     for (int i=0; i<15; i++){ 
         casillero1[i] = dime.nextInt();
    }
    System.out.println("Has introducido: ");
    for(int j = 0; j < 15; j++){
        System.out.print(casillero1[j] + " ");}
    // Ahora tocaría evaluar para ver cuantos pares y cuantos impares
    int p = 0, i = 0; //contador de pares e impares
    for(int j = 0; j <= 8; j++){       
        int resto = casillero1[j] % 2;
        if (resto == 0){
        p = p + 1;    
        }
        if (resto != 0){
        i = i + 1;    
        }
            };
     int[] casilleropar = new int[p+1];
     int[] casilleroimpar = new int[i+1];
   //una vez definidos los dos arrays nuevos quedaría rellenarlos
   //en cada vuelta de llenar un número el contador puede ir bajando
   for (int j= 0; j < casillero1.length; j++){
        int resto = casillero1[j] % 2;
        if (resto == 0){
        casilleropar[p] = casillero1[j];
        p = p - 1;    
        }
        if (resto != 0){
        casilleroimpar[i] = casillero1[j];
        i = i - 1;    
        }
    };
   System.out.println("Quedarían así, los pares:");
    for(int j = 0; j < casilleropar.length; j++){
        System.out.println(casilleropar[j]);}
    System.out.println("Y los impares:");
    for(int j = 0; j < casilleroimpar.length; j++){
        System.out.println(casilleroimpar[j]);}
    }
}
    
    
    
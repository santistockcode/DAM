import java.util.Scanner;
public class array3_3CORRECCION
{
     public static void main(String[] args){
     Scanner dime = new Scanner(System.in);
     System.out.println("¿cúantos números por array?:");
     int tantascasillas = dime.nextInt();
     int[] casilleroa = new int[tantascasillas];
     int[] casillerob = new int[tantascasillas];
     int[] casilleroc = new int[tantascasillas*2];
     System.out.println("Rellena el primer array con números decrecientes");
     boolean talcual = false;
     int z;
     System.out.println("-->");
     casilleroa[0] = dime.nextInt();
     for (int i=1; i<tantascasillas; i++){ 
         System.out.println("-->");
         casilleroa[i] = dime.nextInt();
         z = casilleroa[i];
         for (int c=(i-1); c>=0 && talcual == false; c--){
             talcual = (z >= casilleroa[c]) ? true: false;};   
         // para el que no es 0
         if (talcual == true){
         System.out.println("Ese es mayor o igual, tiene que ser menor:");
         i = i - 1;};
         ;     
         talcual = false;
     }
     System.out.println("Rellena el segundo array de la misma manera, intena no repetir números del primer array:");
     System.out.println("-->");
     talcual = false;
     casillerob[0] = dime.nextInt();
     for (int i=1; i<tantascasillas; i++){ 
         System.out.println("-->");
         casillerob[i] = dime.nextInt();
         z = casillerob[i];
        
         for (int c=(i-1); c>=0 && talcual == false; c--){
             talcual = (z >= casillerob[c]) ? true: false;};   
         // para el que no es 0
         if (talcual == true){
         System.out.println("Ese es mayor o igual, tiene que ser menor:");
         i = i - 1;};
         ;     
         talcual = false;
     }
     int aux1, aux2, aux3, aux4;
     aux1 = casilleroa[0];
     aux2 = casilleroa[casilleroa.length-1];
     aux3 = casillerob[0];
     aux4 = casillerob[casillerob.length-1];
     System.out.println ("Quedan así: ");
     for (int l = 0; l<casilleroa.length; l++){
     System.out.print(casilleroa[l] + "\n");};
      System.out.println( "\n" +"...y...");
     for (int l = 0; l<casillerob.length; l++){
     System.out.print(casillerob[l]+ "\n");};
     if (aux2 > aux3){
        for (int m = 0; m < casilleroa.length; m++){
            casilleroc[m] = casillerob[casillerob.length-m-1];
            casilleroc[m+(casilleroc.length/2)] = casilleroa[casilleroa.length-m-1]; 
        }
    }
     if (aux4 > aux1){
        for (int m = 0; m < casilleroa.length; m++){
            casilleroc[m] = casilleroa[casillerob.length-m-1];
            casilleroc[m+(casilleroc.length/2)] = casillerob[casilleroa.length-m-1]; 
        }
    }
    if(aux3 > aux2 && aux1 > aux4){
     for (int l = 0; l<casilleroa.length; l++){
         casilleroc[l]=casilleroa[l];
         casilleroc[l+casilleroa.length]= casillerob[l];};
      for(int i =0; i<casilleroc.length; i++ ){
       int pos= i;
       int aux= casilleroc[i];
       while ((pos>0) && (casilleroc [pos-1] > aux)){
           casilleroc[pos]=casilleroc[pos-1];
           pos--;
        }
        casilleroc[pos]=aux;
      } 
    }
   for (int l = 0; l<casilleroc.length; l++){
     System.out.println( "\n" +casilleroc[l]);};
}}
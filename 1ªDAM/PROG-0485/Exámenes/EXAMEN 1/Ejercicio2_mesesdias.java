// me interesa que haya un nd (numero de día) y un nm (número de més)
// la primera diatriva es para los meses pares (case 2, 4, etc) y case de lo otro 
// y todo ello dentro de un bucle para evaluar primero el mes
import java.util.Scanner;
public class Ejercicio2_mesesdias
{
    public static void main (String[] args){
   Scanner dime = new Scanner (System.in);
    int nm, nd;
    boolean telodoy; 
    System.out.println("Introduce un número de mes:");
    nm = dime.nextInt();
    System.out.println("Introduce un número de día:");
    nd = dime.nextInt();
    telodoy = false;
    if (nm < 1 || nm > 12){
        System.out.println("No has introducido un número correcto de mes");
        // aquí se podría meter que ha fallado también el día evaluandolo 
    } 
    else{
        switch (nm){
            // tienen 31
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            if (nd <= 31){telodoy = true;}
            else{telodoy = false;};
            break;
            // tienen 30
            case 4: case 6: case 9: case 11: 
            if (nd <= 30){telodoy = true;}
            else{telodoy = false;};
            break;
           //tienen 28
            case 2:
            if (nd <= 28){telodoy = true;}
            else{telodoy = false;};
            break;
        }
        if (telodoy == true && nd > 0){
            switch (nm){
                case 1: System.out.println("El mes es Enero que tiene 31 días"); break;
                case 2: System.out.println("El mes es Febrero que tiene 28 días"); break;
                case 3: System.out.println("El mes es Marzo que tiene 31 días"); break;
                case 4: System.out.println("El mes es Abril que tiene 30 días"); break;
                case 5: System.out.println("El mes es Mayo que tiene 31 días"); break;
                case 6: System.out.println("El mes es Junio  que tiene 30 días"); break;
                case 7: System.out.println("El mes es Julio que tiene 31 días"); break;
                case 8: System.out.println("El mes es Agosto que tiene 31 días"); break;
                case 9: System.out.println("El mes es Septiembre  que tiene 30 días"); break;
                case 10: System.out.println("El mes es Octubre que tiene 31 días"); break;
                case 11: System.out.println("El mes es Noviembre  que tiene 30 días"); break;
                case 12: System.out.println("El mes es Diciembre que tiene 31 días"); break;
            }
        }else{
            System.out.println("No es un número de día válido para ese mes");
        }
    };
   }}


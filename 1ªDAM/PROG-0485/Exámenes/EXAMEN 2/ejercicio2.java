import java.util.Scanner;
public class ejercicio2
{
        public static void main(String args[]){
  int nm, nd; 
  Scanner dime = new Scanner (System.in);
  System.out.println("Introduce un número de mes:");
  nm = dime.nextInt();
  System.out.println("Introduce un número de día:");
  nd = dime.nextInt();
  switch (nm){
                case 1: System.out.println("El mes es Enero que tiene 31 días");
                System.out.print(" y la estación es Invierno");break;
                case 2: System.out.println("El mes es Febrero que tiene 28 días");
                System.out.print(" y la estación es Invierno");break;
                case 3: System.out.println("El mes es Marzo que tiene 31 días");
                if (nd<21){
                    System.out.print(" y la estación es Invierno");}
                else{System.out.print(" y la estación es Primavera");};
                break;
                case 4: System.out.println("El mes es Abril que tiene 30 días");
                System.out.print(" y la estación es Primavera");break;
                case 5: System.out.println("El mes es Mayo que tiene 31 días");
                System.out.print(" y la estación es Primavera");break;
                case 6: System.out.println("El mes es Junio  que tiene 30 días");
                if (nd<21){
                    System.out.print(" y la estación es Primavera");}
                else{System.out.print(" y la estación es Verano");};
                break;
                case 7: System.out.println("El mes es Julio que tiene 31 días");
                System.out.print(" y la estación es Verano");break;
                case 8: System.out.println("El mes es Agosto que tiene 31 días");
                System.out.print(" y la estación es Verano");break;
                case 9: System.out.println("El mes es Septiembre  que tiene 30 días");
                if (nd<21){
                    System.out.print(" y la estación es Verano");}
                else{System.out.print(" y la estación es Otoño");};
                break;
                case 10: System.out.println("El mes es Octubre que tiene 31 días");
                System.out.print(" y la estación es Otoño");break;
                case 11: System.out.println("El mes es Noviembre  que tiene 30 días");
                System.out.print(" y la estación es Otoño");break;
                case 12: System.out.println("El mes es Diciembre que tiene 31 días");
                if (nd<21){
                    System.out.print(" y la estación es Otoño");}
                else{System.out.print(" y la estación es Invierno");};
                break;
            }          
    }
}

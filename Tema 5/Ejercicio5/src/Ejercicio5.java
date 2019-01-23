/**
 *
 * @author apazgarcia
 */
import java.util.Scanner;
public class Ejercicio5 {
    public static void main(String[] args){
        char continuar;
        do{
            System.out.println("Introduzca un año para comprobar sus ventas");
            Scanner sc = new Scanner(System.in);
            int ano = Integer.parseInt(sc.nextLine());

            Ventas v = new Ventas(ano);
            v.grafica();
            System.out.printf("Media de ventas: %.1f\n", v.media());
            
            System.out.println("¿Continuar? (y/n)");
            continuar = sc.nextLine().charAt(0);
        }while(continuar == 'y');
        
    }
}

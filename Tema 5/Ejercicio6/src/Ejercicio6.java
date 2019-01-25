/**
 *
 * @author apazgarcia
 */

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args){
        Matriz m = new Matriz(10);
        int opcion = 0;
        do{
            System.out.println("1-Mostrar matriz.");
            System.out.println("2-Suma de todos los elementos.");
            System.out.println("3-Suma de la diagonal.");
            System.out.println("4-Suma de todo menos la diagonal.");
            System.out.println("5-Suma de una fila");
            System.out.println("6-Salir.");
            
            Scanner sc = new Scanner(System.in);
            opcion = Integer.parseInt(sc.nextLine());
            do{
                System.out.println("Introduce una opcion:");
            }while(opcion < 1 || opcion > 5);
            
            switch(opcion){
                case 1:
                    m.mostrar();
                    break;
                case 2:
                    System.out.printf("Suma: %d\n", m.suma());
                    break;
                case 3:
                    System.out.printf("Suma de diagonal: %d\n", m.suma(true));
                    break;
                case 4:
                    System.out.printf("Suma de todo menos diagonal: %d\n", m.suma(false));
                    break;
                case 5:
                    System.out.printf("Suma de fila: %d\n", m.suma(1));
            }
            
        }while(opcion != 6);
    }
}

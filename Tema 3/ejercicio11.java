import java.util.Scanner;
import java.util.Random;

public class ejercicio11{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    /**
     * Genera dos numeros aleatorios, los compara con los 3 introducidos por el usuario
     * y devuelve una tabla de 20 numeros. Mostrando en verde las coincidencias usuario-maquina, en rojo
     * los escogidos por la máquina (sin acertar) y en azul los escogidos por el usuario (sin acertar)
     */
    public static void lotto(int x, int y, int z){
        int min = 1; int max = 20;
        Random r = new Random();

        int n1 = r.nextInt((max - min) + 1) + min;
        int n2 = r.nextInt((max - min) + 1) + min;

        int aciertos = 0;
        if(x == n1 || x == n2) aciertos++;
        if(y == n1 || y == n2) aciertos++;
        if(z == n2 || z == n2) aciertos++;

        for(int i = 1; i <= 20; i ++){
            if(i < 10){
                if(i == x && (x == n1 || x == n2)) System.out.printf("%s%5s", ANSI_GREEN + i + ANSI_RESET, "");
                else if(i == y && (y == n1 || y == n2)) System.out.printf("%s%5s", ANSI_GREEN + i + ANSI_RESET, "");
                else if(i == z && (z == n1 || z == n2)) System.out.printf("%s%5s", ANSI_GREEN + i + ANSI_RESET, "");

                else if(i == x && (x != n1 && x != n2)) System.out.printf("%s%5s", ANSI_BLUE + i + ANSI_RESET, "");
                else if(i == y && (y != n1 && y != n2)) System.out.printf("%s%5s", ANSI_BLUE + i + ANSI_RESET, "");
                else if(i == z && (z != n1 && z != n2)) System.out.printf("%s%5s", ANSI_BLUE + i + ANSI_RESET, "");

                else if(i == n1 || i == n2) System.out.printf("%s%5s", ANSI_RED + i + ANSI_RESET, "");

                else System.out.printf("%d%5s", i, "");
            }
            else{
                if(i == x && (x == n1 || x == n2)) System.out.printf("%s%4s", ANSI_GREEN + i + ANSI_RESET, "");
                else if(i == y && (y == n1 || y == n2)) System.out.printf("%s%4s", ANSI_GREEN + i + ANSI_RESET, "");
                else if(i == z && (z == n1 || z == n2)) System.out.printf("%s%4s", ANSI_GREEN + i + ANSI_RESET, "");

                else if(i == x && (x != n1 && x != n2)) System.out.printf("%s%4s", ANSI_BLUE + i + ANSI_RESET, "");
                else if(i == y && (y != n1 && y != n2)) System.out.printf("%s%4s", ANSI_BLUE + i + ANSI_RESET, "");
                else if(i == z && (z != n1 && z != n2)) System.out.printf("%s%4s", ANSI_BLUE + i + ANSI_RESET, "");

                else if(i == n1 || i == n2) System.out.printf("%s%4s", ANSI_RED + i + ANSI_RESET, "");

                else System.out.printf("%d%4s", i, "");
            }
            
            if(i % 5 == 0) System.out.println("");
        }

        System.out.printf("\n\nLos numeros ganadores de la loteria han sido: %d %d", n1, n2);
        System.out.printf("\nHas tenido un total de %d aciertos!", aciertos);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x, y, z;

        do{
            System.out.println("Loteria primitiva [1-20]: ");
            System.out.print("Introduce tu primer numero: ");
            x = Integer.parseInt(sc.nextLine());
            System.out.print("\nIntroduce tu segundo numero: ");
            y = Integer.parseInt(sc.nextLine());
            System.out.print("\nIntroduce tu tercer numero: ");
            z = Integer.parseInt(sc.nextLine());

            if((x < 1 || x > 20) || (y < 1 || y > 20) || (z < 1 || y > 20)) System.out.println("Los valores validos para la loteria son de entre 1 y 20!");
        }while((x < 1 || x > 20) || (y < 1 || y > 20) || (z < 1 || y > 20));

        lotto(x, y, z);
    }
}
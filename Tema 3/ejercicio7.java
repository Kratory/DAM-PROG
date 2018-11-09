import java.util.Scanner;
public class ejercicio7 {
    /**
     *  Determina qué numero es mayor, o si son iguales.
     * @param n1
     * @param n2
     * @return 0(n1), 1(iguales), 2(n2)
     */
    public static int mayorMenor(int n1, int n2){
        if(n1 > n2) return 0;
        if(n1 == n2) return 1;
        return 2;
    }

    public static int inputHandler(int player){
        // COMPLETE REWORK
        int intentos = 5;
        Integer resp1 = null; Integer resp2 = null;
        if(player == 1){
            Scanner sc = new Scanner(System.in);
            do{
                resp1 = Integer.parseInt(sc.nextLine());
                if(resp1 < 1 || resp1 > 100) System.out.println("El número debe ser mayor que 0, y menor que 100!");
            }while(resp1 < 1 || resp1 > 100);
        }
        else {
            Scanner sc = new Scanner(System.in);
            do{
                resp2 = Integer.parseInt(sc.nextLine());
                if(resp2 < 1 || resp2 > 100) System.out.println("El número debe ser mayor que 0, y menor que 100!");
            }while(resp2 < 1 || resp2 > 100);

            do{
                switch(mayorMenor(resp1, resp2)){
                    case 0:
                        System.out.printf("%d es mayor que el numero a adivinar!", resp2);
                        intentos --;
                        break;
                    case 1:
                        System.out.printf("%d es menor que el numero a adivinar!", resp2);
                        intentos ++;
                        break;
                    case 3:
                        System.out.printf("%d es el numero a adivinar! (%d)", resp2, resp1);
                        return 1;
                    default:
                        System.out.println("Error: mayorMenor devolvió un valor inesperado.");
                }
            }while (intentos > 0);
        }
        return 0; // TO TEST; FUNCITON MIGHT BE TOO COMPLEX
    }

    public static void main(String[] args){
        System.out.println("Introduce un numero:");
        inputHandler(1);

        System.out.println("Jugador dos, adivina el numero");
        inputHandler(2);
    }
}
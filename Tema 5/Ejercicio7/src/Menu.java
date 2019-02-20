/**
 *
 * @author apazgarcia
 */
import java.util.Scanner;

public class Menu {
    String[] alumnos = {"Fran", "Alberto", "Ana", "Samu", "Pablo", "B", "Z", "A", "H", "G", "J", "P", "I", "L", "N"};
    String[] materias = {"Matematicas", "Fisica Cuantica", "Programacion", "Entornos"};
    public  Aula a = new Aula(15,4, materias, alumnos);
    
    /*----FUNC----*/
    public void mostrarMenu(){
        
        do{
            System.out.println("-- MENU AULA --");
            System.out.println("1.- Ver tabla de notas");
            System.out.println("2.- Ver notas de un alumno");
            System.out.println("3.- Ver notas de una materia");
            System.out.println("4.- Media global");
            System.out.println("5.- Media de un alumno");
            System.out.println("6.- Media de una materia");
            System.out.println("7.- Nota maxima de una materia");
            System.out.println("8.- Nota minima de una materia");
            System.out.println("9.- Modificar nota");
            System.out.println("10.- Salir");
        }while(eleccion());
    }
    
    public boolean eleccion(){
        int choice;
        Scanner sc = new Scanner(System.in);
        
        
        do{
            choice = Integer.parseInt(sc.nextLine());
            if(choice < 1 || choice > 10)
                System.out.println("Opción no reconocida, prueba otra vez:");
            
        }while(choice < 1 || choice > 10);
        
        int index = 0;
        switch(choice){
            case 1:
                mostrarNotas();
                break;
            case 2:
                System.out.println("Introduce el alumno que quieres ver (Indice)");
                index = Integer.parseInt(sc.nextLine());
                notasAlumno(index);
                break;
            case 3:
                System.out.println("Introduce la materia que quieres ver (Indice)");
                index = Integer.parseInt(sc.nextLine());
                notasMateria(index);
                break;
            case 4:
                System.out.printf("La media global de las notas es: %.1f", a.mediaNotas());
                break;
            case 5:
                System.out.println("Introduce el alumno del que quieres saber la media (Indice):");
                index = Integer.parseInt(sc.nextLine());
                System.out.printf("La media del alumno es: %.1f", a.mediaAlumno(index));
                break;
            case 6:
                System.out.println("Introduce la materia de la que quieres saber la media (Indice):");
                index = Integer.parseInt(sc.nextLine());
                System.out.printf("La media del alumno es: %.1f", a.mediaMateria(index));
                break;
            case 7:
                System.out.println("Introduce la materia de la que quieres saber la nota maxima:");
                index = Integer.parseInt(sc.nextLine());
                System.out.printf("La nota mas alta de la materia es: %d", a.notaMax(index));
                break;
            case 8:
                System.out.println("Introduce la materia de la que quieres saber la nota minima:");
                index = Integer.parseInt(sc.nextLine());
                System.out.printf("La nota mas baja de la materia es: %d", a.notaMin(index));
                break;
            case 9:
                System.out.println("De qué alumno quieres cambiar la nota?");
                int alumno = Integer.parseInt(sc.nextLine());
                System.out.println("De qué materia quieres cambiar la nota?");
                int materia = Integer.parseInt(sc.nextLine());
                System.out.println("Qué nota quieres introducir?");
                int nota = Integer.parseInt(sc.nextLine());
                cambiarNota(alumno, materia, nota);
                break;
            case 10:
                return false;
        }
        return true;
    }
    
    /**
     * Muestra la tabla notas del objeto Aula.
     */
    public void mostrarNotas(){
        int [][] notas = a.getNotas();
        String [] alumnos = a.getAlumnos();
        
        for(int i = 0; i < notas.length; i++){
            System.out.printf("%d- %s: ", i, alumnos[i]);
            for(int j = 0; j < notas[i].length; j++){
                System.out.printf("%d ", notas[i][j]);
            }
            System.out.println("");
        }
    }
    
    /**
     * Muestra las notas de un alumno
     * @param index Alumno que se quiere obtener nota
     */
    public void notasAlumno(int index){
        int [][] notas = a.getNotas();
        String [] alumnos = a.getAlumnos();
        System.out.printf("%d- %s:", index, alumnos[index]);
        for(int j = 0; j < notas[index].length; j++){
            System.out.printf("%d ", notas[index][j]);
        }
    }
    
    /**
     * Muestra las notas de una materia
     * @param index Materia de la que se quieren ver las notas
     */
    public void notasMateria(int index){
        int[][] notas = a.getNotas();
        String [] materias = a.getMaterias();
        
        System.out.printf("%s: ", materias[index]);
        for(int i = 0; i < notas.length; i++){
            System.out.printf("%d ", notas[i][index]);
        }
    }
    
    public boolean cambiarNota(int alumno, int materia, int nota){
        int [][] notas = a.getNotas();
        if(alumno < 0 || materia < 0 || alumno >= notas.length || materia >= notas.length){
            a.setNotas(alumno, materia, nota);
            return true;
        } 
        else
            return false;
    }
}

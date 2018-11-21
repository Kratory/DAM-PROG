import java.util.Scanner;
class Empleado{
    private String nombre, apellidos, dni;
    private int edad;
    private Double salarioAnual, irpf;

    /*---------CONSTRUCTORS----------*/
    public Empleado(){
        this.nombre = ""; this.apellidos = ""; this.dni = "";
        this.edad = 0; this.salarioAnual = 0.0; this.irpf = 0.0;
    };
    public Empleado(String nombre, String apellidos, String dni, int edad, Double salarioAnual){
        this.nombre = nombre; this.apellidos = apellidos; this.dni = dni;
        this.edad = edad; this.salarioAnual = salarioAnual; this.irpf();
    }
    /*------END OF CONSTRUCTORS------*/

    /*-----------SETTERS-------------*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setSalarioAnual(double salarioAnual){
        this.salarioAnual = salarioAnual;
    }
    /*--------END OF SETTERS---------*/

    /*-----------GETTERS-------------*/
    public String getNombre(){
        return this.nombre;
    }

    public String getApellidos(){
        return this.apellidos;
    }
    
    public String getNombreCompleto(){
        return getNombre() + " " + getApellidos();
    }

    public String getDni(){
        return this.dni;
    }

    public int getEdad(){
        return this.edad;
    }

    public Double getSalarioAnual(){
        return this.salarioAnual;
    }

    public Double getIrpf(){
        return this.irpf;
    }
    /*--------END OF GETTERS---------*/

    /**
     * Calcula el IRPF en base al salario anual del objeto.
     */
    private void irpf(){ // PREGUNTAR A CURRO SI ESTA ERA LA SOLUCIÓN A LA AUNSENCIA DE SETTER
        if(this.salarioAnual < 6000)
            this.irpf = 7.5;
        else if(this.salarioAnual < 30000)
            this.irpf = 15.0;
        else 
            this.irpf = 20.0;
    }

    /**
     * Muestra todos los campos del objeto en pantalla.
     */
    public void mostrar(){
        System.out.printf("Nombre: %s\n", getNombreCompleto());
        System.out.printf("DNI: %s\n", getDni());
        System.out.printf("Edad: %d\n", getEdad());
        System.out.printf("Salario Anual: %.2f\n", getSalarioAnual());
        System.out.printf("IRPF: %.2f\n", getIrpf());
    }

    /**
     * Sobrecarga del anterior, permite mostrar un unico campo. Si el campo que se le da es incorrecto, mostrara todos.
     * @param choice Numero entero que corresponde al apartado concreto del objeto que se quiere mostrar.
     */
    public void mostrar(int choice){
        switch(choice){
            case 1:
                System.out.printf("Nombre: %s\n", getNombreCompleto());
                break;
            case 2:
                System.out.printf("DNI: %s\n", getDni());
                break;
            case 3:
                System.out.printf("Edad: %d\n", getEdad());
                break;
            case 4:
                System.out.printf("Salario Anual: %.2f // IRPF: %.2f \n", getSalarioAnual(), getIrpf());
                break;        
            default:
                mostrar();
                break;
        }
    }

    /**
     * Pide input al usuario para editar los campos del objeto mediante las funciones set.
     */
    public void editar(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca su nombre: ");
        setNombre(sc.nextLine());
        System.out.println("Introduzca sus apellidos, separados por espacio: ");
        setApellidos(sc.nextLine());
        System.out.println("Introduzca su DNI: ");
        setDni(sc.nextLine());

        System.out.println("Introduzca su edad: ");
        setEdad(Integer.parseInt(sc.nextLine()));
        
        System.out.println("Introduzca su salario anual: ");
        setSalarioAnual(Double.parseDouble(sc.nextLine()));

        irpf();
    }

    /**
     * Calcula el pago a hacienda en base a salarioAnual y a irpf.
     * @return Cantidad de dinero pagada a haciend, como Double.
     */
    public Double hacienda(){
        Double hacienda = getSalarioAnual() * getIrpf() / 100;
        return hacienda;
    }

}

class Directivo{
    private String nombre, apellidos, dni, departamento;
    private float beneficios;

    /*---------CONSTRUCTORS----------*/
    public Directivo(){
        this.nombre = ""; this.apellidos = ""; this.dni = ""; this.departamento = "";
        this.beneficios = 0;
    }
    /*------END OF CONSTRUCTORS------*/

    /*-----------SETTERS-------------*/
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento.toUpperCase();
    }

    public void setBeneficios(float beneficios){
        this.beneficios = beneficios;
    }
    /*--------END OF SETTERS---------*/

    /*-----------GETTERS-------------*/
    public String getNombre(){
        return this.nombre;
    }

    public String getApellidos(){
        return this.apellidos;
    }
    
    public String getNombreCompleto(){
        String nombreCompleto =  getNombre() + " " + getApellidos();
        return nombreCompleto;
    }

    public String getDni(){
        return this.dni;
    }

    public String getDepartamento(){
        return "\"" + this.departamento + "\"";
    }

    public float getBeneficios(){
        return this.beneficios;
    }
    /*--------END OF GETTERS---------*/

    /**
     * Muestra todos los campos del objeto en pantalla.
     */
    public void mostrar(){
        System.out.printf("Nombre: %s\n", getNombreCompleto());
        System.out.printf("DNI: %s\n", getDni());
        System.out.printf("Departamento: %s\n", getDepartamento());
        
        System.out.printf("Beneficios: %.2f\n", getBeneficios());
    }

    /**
     * Sobrecarga del anterior, permite mostrar un unico campo. Si el campo que se le da es incorrecto, mostrara todos.
     * @param choice Numero entero que corresponde al apartado concreto del objeto que se quiere mostrar.
     */
    public void mostrar(int choice){
        switch(choice){
            case 1:
                System.out.printf("Nombre: %s\n", getNombreCompleto());
                break;
            case 2:
                System.out.printf("DNI: %s\n", getDni());
                break;
            case 3:
                System.out.printf("Departamento: %s\n", getDepartamento());
                break;
            case 4:
                System.out.printf("Beneficios: %.2f", getBeneficios());
                break;        
            default:
                mostrar();
                break;
        }
    }

    /**
     * Pide input al usuario para editar los campos del objeto mediante las funciones set.
     */
    public void editar(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca su nombre: ");
        setNombre(sc.nextLine());
        System.out.println("Introduzca sus apellidos, separados por espacio: ");
        setApellidos(sc.nextLine());
        System.out.println("Introduzca su DNI: ");
        setDni(sc.nextLine());
        System.out.println("Introduzca su departamento: ");
        setDepartamento(sc.nextLine());

        
        
        System.out.println("Introduzca sus beneficios: ");
        setBeneficios(Float.parseFloat(sc.nextLine()));
    }

    /**
     * Calcula las ganancias del Directivo en base a las ganancias de la empresa y a los beneficios del miembro.
     * @param g Double, ganancias de la empresa.
     * @return Double, ganancias del Directivo.
     */
    public Double ganancias(Double g){
        Double ganancias;
        if(g > 0) 
            ganancias = g * this.beneficios / 100;
        else 
            ganancias = 0.0;

        return ganancias;
    }
}

class Ejercicio3{
    public static void main(String[] args){

        /* TESTEO CLASE EMPLEADO */
        Empleado e = new Empleado();
        e.editar();
        System.out.println("\u001b[2J\u001b[H");
        e.mostrar();
        System.out.println("------------------------------");
        System.out.printf("Hacienda se lleva: %.2f\n", e.hacienda());
        System.out.println("------------------------------");
        /* END OF CLASE EMPLEADO */

        /* TESTEO CLASE DIRECTIVO */
        Directivo d = new Directivo();
        d.editar();
        System.out.println("\u001b[2J\u001b[H");
        d.mostrar();
        System.out.println("------------------------------");
        System.out.printf("Obtiene unas ganancias de: %.2f\n", d.ganancias(1000000.0));
        System.out.println("------------------------------");
        /* END OF CLASE DIRECTIVO */
    }
}
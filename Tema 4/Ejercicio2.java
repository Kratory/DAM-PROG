import java.util.Scanner;
class Fecha{
    private int dia, mes, ano;

    /*---------CONSTRUCTORS----------*/
    public Fecha(){};
    public Fecha(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    /*------END OF CONSTRUCTORS------*/

    /*-----------SETTERS-------------*/
    public void setDia(int dia){
        if(dia < 1 || dia > 31)
            dia = 1;
        this.dia = dia;
    }

    public void setMes(int mes){
        if(mes < 1 || mes > 12)
            mes = 1;
        this.mes = mes;
    }

    public void setAno(int ano){
        this.ano = ano;
    }
    /*--------END OF SETTERS---------*/

    /*-----------GETTERS-------------*/
    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes;
    }
    
    public int getAno(){
        return this.ano;
    }
    /*--------END OF SETTERS---------*/

    /*--------END OF SETTERS---------*/
    /**
     * Formatea la fecha en una cadena de texto. Valores numericos (flag = 1) / Valores a texto (flag = 0)
     * @param flag Booleano que controla el tipo de formato que se le dará a la fecha. (Texto/Numeros)
     * @return Cadena de texto resultante.
     */
    public String fechaFormateada(boolean flag){
        if(flag)
            return "" + this.dia + "/" + this.mes + "/" + this.ano;
        else{
            String mes = "";
            switch(this.mes){
                case 1:
                    mes = "enero";
                    break;
                case 2:
                    mes = "febrero";
                    break;
                case 3:
                    mes = "marzo";
                    break;
                case 4:
                    mes = "abril";
                    break;
                case 5:
                    mes = "mayo";
                    break;
                case 6:
                    mes = "junio";
                    break;
                case 7:
                    mes = "julio";
                    break;
                case 8:
                    mes = "agosto";
                    break;
                case 9:
                    mes = "septiembre";
                    break;
                case 10:
                    mes = "octubre";
                    break;
                case 11:
                    mes = "noviembre";
                    break;
                case 12:
                    mes = "diciembre";
                    break;
                default:
                    System.out.println("Error mes inesperado!");
                    break;
            }
            return "" + this.dia + " de " + mes + " de " + this.ano;
        }
    }

    public static int diasMes(Fecha a){
        int max = 0;
        switch(a.getMes()){
            case 2:
                max = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                max = 30;
                break;
            default:
                max = 31;
        }

        return max;
    }
    //TO CONTINUE

    public static int diferencia(Fecha a, Fecha b, boolean flag){
        int diferencia;
        if(flag){
              
        }else{
            if(a.getAno() > b.getAno())
                diferencia = a.getAno() - b.getAno();
            else
                diferencia = b.getAno() - a.getAno();
        }
        
        return diferencia;
    }
}

public class Ejercicio2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el día, mes y año de la primera fecha. (Separados por enter)");
        int dia = Integer.parseInt(sc.nextLine());
        int mes = Integer.parseInt(sc.nextLine());
        int ano = Integer.parseInt(sc.nextLine());

        Fecha primera = new Fecha(dia, mes, ano);

        System.out.println("Introduce el día, mes y año de la segunda fecha. (Separados por enter)");
        dia = Integer.parseInt(sc.nextLine());
        mes = Integer.parseInt(sc.nextLine());
        ano = Integer.parseInt(sc.nextLine());

        Fecha segunda = new Fecha(dia, mes, ano);

        System.out.printf("\nLa primera fecha es %s", primera.fechaFormateada(true));
        System.out.printf("\nLa segunda fecha es %s", segunda.fechaFormateada(false));

        System.out.printf("\nHay una diferencia de %d años entre ambas fechas.", Fecha.diferencia(primera, segunda, false));

    }
}
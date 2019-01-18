/**
 *
 * @author Alberto Paz
 */


public class Texto {
    
    public static void muestraEnLinea(String texto){
        for (int i = 0; i < texto.length(); i++) {
            System.out.printf("%s\n", texto.charAt(i));
        }
    }
    
    public static String subCadena(String texto, int inicio, int longitud){
        if(inicio < 0 || inicio > texto.length() || (inicio + longitud) > texto.length())
            return " ";
        
        String subcadena = "";
        for (int i = 0; i < longitud; i++) {
            subcadena += texto.charAt(inicio + i);
        }
        return subcadena;
    }
    
    public static void muestraCentrado(String texto){
        int centroCadena = texto.length() / 2;
        int centroConsola = 80 / 2 - centroCadena;  
        for(int i = 0; i < centroConsola; i++){
            System.out.printf(" ");
        }
        System.out.printf("%s", texto);
    }
    
    public static char[] cadenaAVector(String texto){
        char[] letras = new char[texto.length()];
        for (int i = 0; i < letras.length; i++) {
            letras[i] = texto.charAt(i);
        }
        return letras;
    }
    
    public static String alReves (String texto){
        String reversa = "";
        for(int i = texto.length() ; i > 0 ; i--){
            reversa += texto.charAt(i - 1);
        }
        
        return reversa;
    }
    
    public static String pasoAMayusculas(String texto){
        char[] letras = cadenaAVector(texto);
        String mayus = "";
        
        // ACABAR
        
        for(int i = 0; i < letras.length; i++){
            if(letras[i] == '_')
                letras[i] = ' ';
            
            mayus += (char)(letras[i] - 32);
        }
        
        return mayus;
    }
}
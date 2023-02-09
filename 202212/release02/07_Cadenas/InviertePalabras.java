/** 
* 14.   String inviertePalabras(Palabras)
* 
* @author Juan 
*/

public class InviertePalabras {

    // funcion a la que le pasamos una Palabras y ..
    public static String invierteCadena(String s) {
        String s2 = "";
        for (int i=s.length()-1; i>=0; i--) {
            s2 = s2 + s.charAt(i);
        }
        return s2;
    }

    public static String inviertePalabras(String s) {
        String s2 = "";
        String[] parts = s.split(" ");
        for (int i=0; i<parts.length; i++) {
            //System.out.println(parts[i]);
            s2 = s2 + invierteCadena(parts[i]) + " ";
        }
        return s2;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        System.out.println(inviertePalabras(myString));
    }
}


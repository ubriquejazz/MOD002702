/** 
* 14.   String invierteCadena(cadena)
* 
* @author Juan 
*/

public class InvierteCadena {

    // funcion a la que le pasamos una cadena y ..
    public static String invierteCadena(String s) {
        String s2 = "";
        for (int i=s.length()-1; i>=0; i--) {
            s2 = s2 + s.charAt(i);
        }
        return s2;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        System.out.println(invierteCadena(myString));
    }
}


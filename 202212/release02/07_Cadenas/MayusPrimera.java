/** 
 * 17.   String mayusPrimera(cadena)
 * 
 * @author Juan 
 */

public class MayusPrimera {

    public static String sustituye(String s, char ch1, char ch2) {
        String s2="";
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == ch1) {
                s2 = s2 + ch2;
            }
            else {
                s2 = s2 + s.charAt(i);
            }
        }
        return s2;
    }

    // funcion a la que le pasamos una cadena y ..
    public static String mayusPrimera(String s) {
        String[] parts = s.split(" ");
        String s2 = "";
        for (int i=0; i<parts.length; i++) {
            String aux = parts[i];
            char ch = aux.charAt(0);
            if (ch < 60)
                s2 = s2 + " " + sustituye(aux, ch, (char)(ch+10));
            else
                s2 = s2 + " " + aux;
        }
        return s2;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        System.out.println(mayusPrimera(myString));
    }
}


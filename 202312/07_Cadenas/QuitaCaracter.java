/** 
* 12.   String quitaCaracter(cadena, ch)
* 
* @author Juan 
*/

import java.util.Arrays;

public class QuitaCaracter {

    // funcion a la que le pasamos una cadena y un carácter y 
    // nos devuelve la cadena sin (todas las ocurrencias) de el.
    public static String quitaCaracter2(String s, char ch) {
        String s2 = "";
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) != ch) {
                s2 = s2 + s.charAt(i); // StringBuilder
            }
        }
        return s2;
    }

    public static String quitaCaracter(String s, char ch) {
        StringBuilder s2 = new StringBuilder();
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) != ch) {
                s2.append(s.charAt(i));
            }
        }
        return s2.toString();
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        char ch1 = args[1].charAt(0);
        System.out.println(quitaCaracter(myString, ch1));
    }
}


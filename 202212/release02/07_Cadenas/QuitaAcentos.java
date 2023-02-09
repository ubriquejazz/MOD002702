/** 
* 13.   String quitaAcentos(cadena)
* 
* @author Juan 
*/

import java.util.Arrays;

public class QuitaAcentos {

    // funcion a la que le pasamos una cadena y ..
    public static String quitaAcentos(String s) {
        String s2 = "";
        char[] vocalesSimples = {'a', 'e', 'i', 'o', 'u'};
        char[] vocalAcentuada = {'á', 'é', 'i', 'ó', 'ú'};
        for (int i=0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            for (int j=0; j<vocalesSimples.length; j++) {
                if (ch1 == vocalAcentuada[j]) {
                    ch1 = vocalesSimples[j];
                }
            }
            s2 = s2 + ch1;
        }
        return s2;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        System.out.println(quitaAcentos(myString));
    }
}


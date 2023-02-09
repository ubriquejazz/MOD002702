/** 
* 04.   int contiene(cadena, letra)
* 
* @author Juan 
*/

public class Contiene {

    /**
     * nos dice cuantas veces el carácter aparece en la cadena. 
     * no es igual que la función contains (true or false)
     */
    public static int contiene(String s, char ch) {
        int n=0;
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == ch) n++;
        }
        return n;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        char ch = args[1].charAt(0);
        CharSequence seq = (CharSequence)args[1];
        String result;
        result = "El caracter \'" + ch + "\' aparece " + contiene(myString, ch) + " veces en " + myString;
        /*
        if (myString.contains(seq))
            result = "El caracter \'" + ch + "\' aparece en " + myString;
        else
            result = "El caracter \'" + ch + "\' no aparece en " + myString;
        */
        System.out.println(result);
    }
}
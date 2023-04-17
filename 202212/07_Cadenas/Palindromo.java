/** 
* 03.       boolean Palindromo(cadena)
* 
* @author Juan 
*/

public class Palindromo {

    /**
     * nos dice si la cadena es un palíndromo (true) o no (false).
     * palabra o frase que se lee igual al revés que al derecho
     *
     * @param myString  cadena original
     * @return          boolean
     */
    public static boolean esPalindromo(String myString) {
        boolean retVal = false;
        int l = myString.length();
        int cont = 0;
        char left, right;
        for (int i=0; i<l/2; i++) {
            left = myString.charAt(i);
            right = myString.charAt(l-1-i);
            if (left == right) cont++;
        }
        if (cont == l/2)
            retVal = true;
        return retVal;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        if (esPalindromo(myString))
            System.out.println(myString + " -> es palindromo");
        else
            System.out.println(myString + " -> no es palindromo");
    }
}
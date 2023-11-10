/** 
* 15.   int vecesCaracter(s, ch)
* 
* @author Juan 
*/

public class VecesCaracter {

    // funcion a la que le pasamos una cadena y ..
    public static int vecesCaracter(String s, char ch) {
        int suma = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ch) suma++;
        }
        return suma;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        char ch = args[1].charAt(0);
        
        String str = "El caracter \'" + ch + "\' se repite " 
            + vecesCaracter(myString, ch) + " en " + myString;
        System.out.println(str);
    }
}


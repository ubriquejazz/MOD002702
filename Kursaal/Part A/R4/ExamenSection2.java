import java.util.Arrays;

/**
 * ExamenSection2
 */
public class ExamenSection2 {

    public static String removeCharacter(String s, char c) {
        String s2="";
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != c)
                s2 += s.charAt(i);
        }
        return s2;
    }
    // returns the string with all occurrences of that character removed.

    public static String replaceCharacter(String s, char ch1, char ch2) {
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
    // returns the string with all occurrences of that character replaced.


    // funcion a la que le pasamos una cadena y ..
    public static String mayusPrimera(String s) {
        String[] parts = s.split(" ");
        //System.out.println(Arrays.toString(parts));
        String s2 = "";
        for (int i=0; i<parts.length; i++) {
            String aux = parts[i];
            char ch = aux.charAt(0);
            if (i>0)
                s2 = s2 + " " + Character.toUpperCase(ch) + aux.substring(1);
            else 
                s2 = Character.toUpperCase(ch) + aux.substring(1);
        }
        return s2;
    }
    // .. returns the same string with the first letter in uppercase.

    public static int timesCharacter (String s, char c) {
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == c) count++;
        }
        return count;
    }
    // returns how many times that character is repeated.

    public static void main(String[] args) {
        System.out.println("String functions!!!");
        String miCiudad = "Malaga";
        System.out.println(miCiudad + " tiene " + timesCharacter(miCiudad, 'a') + " aes");
        System.out.println("Se las quito y se queda " + removeCharacter(miCiudad, 'a'));
        String frase = "malaga la bombonera";
        System.out.println(mayusPrimera(frase));
    }
}
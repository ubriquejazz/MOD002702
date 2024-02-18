/** 
* 16.   int vecesPalabra(s1, s2)
* 
* @author Juan 
*/

public class VecesPalabra {

    // funcion a la que le pasamos una cadena y ..
    public static int vecesPalabra(String s1, String s2) {
        String[] parts = s1.split(" ");
        int suma = 0;
        for (int i=0; i<parts.length; i++) {
            if (parts[i].contains(s2)) {
                suma++;
            }
        }
        return suma;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        String word = args[1].trim();
        
        String str = "La palabra \'" + word + "\' se repite " + vecesPalabra(myString, word) 
            + " en " + myString;
        System.out.println(str);
    }
}


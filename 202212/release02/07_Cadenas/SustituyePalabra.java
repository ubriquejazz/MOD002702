/** 
* 18.   int SustituyePalabra(orig, s1, s2)
* 
* @author Juan 
*/

public class SustituyePalabra {

    public static String sustituyePalabra(String orig, String s1, String s2) {
        String aux="";
        String[] parts = orig.split(" ");
        for (int i=0; i<parts.length; i++) {
            if (parts[i].contains(s1)) {
              aux = aux + s2 + " ";
            }
            else {
                aux = aux + parts[i] + " ";
            }
        }
        return aux;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        String word1 = args[1].trim();
        String word2 = args[2].trim();
        System.out.print("Antes: ");
        System.out.println(myString);

        System.out.print("Despues: ");
        System.out.println(sustituyePalabra(myString, word1, word2));
    }
}


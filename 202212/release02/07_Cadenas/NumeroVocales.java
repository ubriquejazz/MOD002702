/** 
* 02.       int numeroVocales(cadena)
* 
* @author Juan 
*/

public class NumeroVocales {

    /**
     * nos devuelve el número de vocales que hay en la cadena
     *
     * @param myString  cadena original
     * @return  numero de veces
     */
    public static int numeroVocales(String myString) {
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        int suma =0;
        for (int i=0; i < myString.length(); i++) {
            char ch = myString.charAt(i);
            for (int j=0; j < vocales.length; j++) {
                if (vocales[j] == ch) {
                    suma++;
                }
            }
        }
        return suma;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        System.out.println(myString + ": " + numeroVocales(myString) + " vocales");
    }
}
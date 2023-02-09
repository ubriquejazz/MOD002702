/** 
* 09.       void sustituyeCaracter(cadena, ch1, ch2)
* 
* @author Juan 
*/

public class Sustituye {

    /**
     * nos devuelve otra cadena igual que la primera en la que se ha sustituido
     * el primer carácter por el segundo carácter (paso por referencia)
     *
     * @param   chars array de caracteres  
     * @param   ch1 caracter reemplazado 
     * @param   ch2 nuevo caracter 
     */
    public static void sustituyeCaracter2(char[] chars, char ch1, char ch2) {
        for (int i=0; i < chars.length; i++) {
            if (chars[i] == ch1) chars[i] = ch2;
        }
    }

    /**
     * nos devuelve otra cadena igual que la primera en la que se ha sustituido
     * el primer carácter por el segundo carácter (devuelve un String)
     *
     * @param   s String de entrada 
     * @param   ch1 caracter reemplazado 
     * @param   ch2 nuevo caracter 
     * @return  String de salida
     */
    public static String sustituyeCaracter(String s, char ch1, char ch2) {
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

    public static void main(String[] args) {    
        String myString = args[0].trim();
        char ch1 = args[1].charAt(0);
        char ch2 = args[2].charAt(0);
        System.out.println(sustituyeCaracter(myString, ch1, ch2));

        // char[] chars = myString.toCharArray();
        // sustituyeCaracter2(chars, ch1, ch2);
        // System.out.println(chars);
    }
}
/** 
* 05.       void Reptie(cadena, veces)
* 
* @author Juan 
*/

public class Repite {

    /**
     * nos devuelve una cadena que contendrá el carácter repetido tantas
     * veces como indique el entero. repiteCaracter(‘A’, 5) = “AAAAA”.
     *
     * @param ch  
     * @param num   
     * @return  Cadena resultante
     */
    public static String repiteCaracter(char ch, int num) {
        String result = "";
        for (int i=0; i<num; i++) {
            result += ch;
        }
        return result;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        char ch = myString.charAt(0);
        int num = Integer.parseInt(args[1]);
        System.out.println(repiteCaracter(ch, num));
    }
}
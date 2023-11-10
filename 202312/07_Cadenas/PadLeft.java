/** 
* 06.       void padLeft(cadena, total)
* 
* @author Juan 
*/

public class PadLeft {

    /**
     * nos añadirán espacios detras (padRight)
     * hasta que el tamaño de nuestra cadena llega a la longitud
     *
     * @param myString  cadena original
     * @param num       longitud final
     * @return          cadena resultante
     */
    public static String padRight(String myString, int num) {
        String result = "";
        int total = num-myString.length();
        if (total >= 0) {
            for (int i=0; i<total; i++) {
                result = result + " ";
            }
            result = myString + result; // right
        }
        else {
            result = "Error";
        }
        return result;
    }

    /**
     * nos añadirán espacios delante (padLeft)
     * hasta que el tamaño de nuestra cadena llega a la longitud
     *
     * @param myString  cadena original
     * @param num       longitud final
     * @return          cadena resultante
     */
    public static String padLeft(String myString, int num) {
        String result = "";
        int total = num-myString.length();
        if (total >= 0) {
            for (int i=0; i<total; i++) {
                result = result + " ";
            }
            result = result + myString; // left
        }
        else {
            result = "Error";
        }
        return result;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        int num = Integer.parseInt(args[1]);
        System.out.print(padRight(myString, num));
        System.out.println(".");
        System.out.println(padLeft(myString, num));
    }
}
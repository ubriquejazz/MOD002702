/** 
* 10.   int cuentaPalabras(cadena)
* 
* @author Juan 
*/

public class CuentaPalabras {
    
    /**
     * función a la que le pasamos una cadena que contiene una
     * frase y nos devuelve el número de palabras que hay en la misma
     *
     * @param myString  cadena original
     * @return numero de palabras
     */
    public static int cuentaPalabras(String myString) {
        String[] parts = myString.split(" ");
        int suma = 0;
        for (int i=0; i<parts.length; i++) {
            if (!parts[i].isEmpty()) {
                suma++;
            }
        }
        return suma;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        //System.out.println("Mi cadena es " + myString);
        System.out.println("Numero de palabras: " + cuentaPalabras(myString));
    }
}


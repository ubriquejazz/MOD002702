/** 
* 11.   boolean esNumero(cadena)
* 
* @author Juan 
*/

public class EsNumero {

    /**
     * nos devuelve si la cadena está formada enteramente por números o no
     *
     * @param   mySting cadena  
     * @return  nos dice si está formada enteramente por números o no
     */
    public static boolean esNumero(String myString) {
        int cont = 0;
        for (int i=0; i < myString.length(); i++) {
            char ch = myString.charAt(i);
            // check if the character is a number
            for (int j=0x30; j<0x3A; j++) {
                if ((char)j == ch) cont++;
            }
        }
        return (cont == myString.length());
    }
    
    public static void main(String[] args) {    
        
        // Si queremos leer un número del teclado, lo más correcto es leerlo con 
        // Scanner.next() como si fuera una cadena. Otra forma, usando args[i]
        String myString = args[0].trim();

        // después comprobar con la función esNumero si está formado por dígitos
        // y después convertirlo a entero con Integer.parseInt().
        if (esNumero(myString)) {
            int myNum = Integer.parseInt(myString);
            System.out.printf ("%d\n", myNum);
        }
        else {
            System.out.println("No es un numero");
        }    
    }
}
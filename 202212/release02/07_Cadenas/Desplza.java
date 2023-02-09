/** 
* XX.   int desplazaIzda(char[], j)
* 
* @author Juan 
*/

public class Desplza {

    public static int desplazaDcha(char[] chars, int j) {
        int size = chars.length-j;
        if (size < 0) {
            size = 0;
        }
        return size;
    }

    public static int desplazaIzda(char[] chars, int j) {
        int size = chars.length-j;
        if (size > 0) {
            for (int i=0; i < size; i++) {
                chars[i] = chars[i+j];
            }
        }
        else {
            size = 0;
        }
        for (int i=size; i < chars.length; i++) {
            chars[i] = 0;
        }
        return size;
    }

    public static void main(String[] args) {    
        String myString = args[0].trim();
        char[] chars = myString.toCharArray();
        int num = Integer.parseInt(args[1]);

        desplazaIzda(chars, num);
        System.out.println(chars);
        
        desplazaDcha(chars, num);
        System.out.println(chars);
    }
}


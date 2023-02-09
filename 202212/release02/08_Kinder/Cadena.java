public class Cadena {

    public static String basic(String x) {
        String aux = "";
        for (int i=0; i < x.length(); i++) {
            aux += x.charAt(i);    // concatenar 
        }
        return aux;
    }

    public static String invierte(String x) {
        String aux = "";
        for (int i=0; i < x.length(); i++) {
            aux = x.charAt(i) + aux;
        }
        return aux;
    }

    public static String quitaEspacios(String x) {
        String aux = "";
        for (int i=0; i < x.length(); i++) {
            if (x.charAt(i) != ' ')
                aux = aux + x.charAt(i);
        }
        return aux;
    }

    public static void main(String[] args) {
        System.out.println(invierte("abcd"));
    }  
}
import java.util.ArrayList;

public class Ej03 {

    public static void cargaLista(ArrayList<Integer> l, int n) {
        for (int i=0; i<n; i++) {
            l.add(i);
        }
    }

    /*  función  a la que le pasas una lista y te escribe su contenido por pantalla
        para diferenciarla de los arrays, usaremos angulos para delimitarla con <>
    */
    public static void escribeLista(ArrayList<Integer> l, int n) {
        System.out.print("<");
        for (int i=0; i<n; i++) {
            if (i==(n-1))
                System.out.println (l.get(i) + ">");
            else
                System.out.print (l.get(i) + ", ");
        } 
    }

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        cargaLista(l, 10);
        escribeLista(l, l.size());
    }
}
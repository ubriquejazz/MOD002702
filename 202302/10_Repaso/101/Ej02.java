import java.util.ArrayList;
import java.util.Scanner;

public class Ej02 {

    static Scanner sc = new Scanner(System.in);

    // Lee desde el teclado el número de enteros que ...
    // Para ello, le pasamos la lista y un entero.
    public static void leeListaN(ArrayList<Integer> l, int size) {
        for (int i=0; i<size; i++) {
            int aux = sc.nextInt();
            l.add(aux);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        leeListaN(l, 10);
        System.out.println(l); 
    }
}
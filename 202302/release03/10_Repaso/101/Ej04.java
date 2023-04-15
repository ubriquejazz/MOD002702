import java.util.ArrayList;

public class Ej04 {

    // crea una lista de n numeros aleatorios --> de 1 a n
    public static ArrayList<Integer> cargaLista(int n) {
        ArrayList<Integer> l = new ArrayList<>();        
        int aux;
        for (int i=0; i<n/2; i++) {
            aux = (int)(Math.random() * n) + 1;            
            l.add(-aux);
        }
        for (int i=n/2+1; i<n; i++) {
            aux = (int)(Math.random() * n) + 1;        
            l.add(aux);
        }       
        return l;
    }

    // elimine todos los números negativos --> reserva memoria
    public static ArrayList<Integer> eliminaNegativos(ArrayList<Integer> l) {
        ArrayList<Integer> aux = new ArrayList<>();
        for (int numero : l) {
            if (numero >= 0) aux.add(numero);
        }
        return aux;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista1, lista2;  // estructuras vacias
        lista1 = cargaLista(20);
        System.out.println(lista1);
        lista2 = eliminaNegativos(lista1);
        System.out.println(lista2);
    }
}
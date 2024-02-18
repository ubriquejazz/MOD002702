import java.util.ArrayList;
import java.util.Collections;

/* EJ06: escribe la funcion que le pasas una lista y te elimina los elementos
repetidos, dejando sólo uno de cada (ej.: <1,2,3,1> = <1,2,3>). La forma más fácil 
es ir copiando de una lista a otra sólo los elementos que no estén ya introducidos
*/

public class Ej06 {

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

    public static ArrayList<Integer> eliminaRepetidos(ArrayList<Integer> l) {
        ArrayList<Integer> aux = new ArrayList<>();
        for (int numero : l) {
            if (!aux.contains(numero))
                aux.add(numero);
        }
        return aux;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista1 = cargaLista(20);
        System.out.println(lista1);
        ArrayList<Integer> lista2 = eliminaRepetidos(lista1);
        System.out.println(lista2);
    }
}
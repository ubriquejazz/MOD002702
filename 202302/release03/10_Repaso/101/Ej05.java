import java.util.ArrayList;
import java.util.Collections;

/*
    Escribe la función clasificaNumeros a la que le pasamos tres listas. La primera contiene
    un montón de números positivos y negativos. Habrá que copiar los positivos en la
    primera lista y los negativos en la segunda lista, y después ordenar las dos listas
*/

public class Ej05 {

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

    public static void clasificaNumeros( ArrayList<Integer> l1,
        ArrayList<Integer> lneg, ArrayList<Integer> lpos ) 
    {
        for (int numero : l1) {
            if (numero >= 0) lpos.add(numero);
            else
               lneg.add(numero);
        }
        Collections.sort(lneg);        
        Collections.sort(lpos);
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista1 = cargaLista(20);
        ArrayList<Integer> lista2 = new ArrayList<>(); 
        ArrayList<Integer> lista3 = new ArrayList<>(); 
        
        clasificaNumeros(lista1, lista2, lista3);
        System.out.println(lista3);
    }
}
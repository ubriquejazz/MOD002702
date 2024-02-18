/**
 * 3. Escribe un programa que ordene 10 números enteros introducidos
 *    x teclado y almacenados en un objeto de la clase ArrayList .
 *
 * @author Luis José Sánchez
 */
import java.util.ArrayList;
import java.util.Collections;

public class S10Ejercicio03 {
  public static void main(String[] args) {

    System.out.println("Introduzca 10 enteros: ");
    
    ArrayList<Integer> a = new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) {
      a.add(Integer.parseInt(System.console().readLine()));
    }

    System.out.println("Lista original: " + a);
    Collections.sort(a);

    System.out.println("De menor a mayor: " + a);

    // Descomenta para ordenar la lista de mayor a menor
    
      ArrayList<Integer> b = new ArrayList<Integer>();
      for(int n : a) {
        b.add(0, n);
      }       
      System.out.print("De mayor a menor: " + b);
    
  }
}

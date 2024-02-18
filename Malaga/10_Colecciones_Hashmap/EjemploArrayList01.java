import java.util.ArrayList;
import java.util.Arrays;

/**
 * Ejemplo de uso de la clase ArrayList
 * 
 * @author Luis José Sánchez
 */
public class EjemploArrayList01 {
  public static void main(String[] args) {

    ArrayList<String> a = new ArrayList<String>();

    System.out.println("N. de elementos: " + a.size());     // 0
    a.add("rojo");
    a.add("verde");
    a.add("azul");

    System.out.println("N. de elementos: " + a.size());     // 3   
    a.add("blanco");
    System.out.println("N. de elementos: " + a.size());     // 4   

    System.out.println("El elemento que hay en la posicion 0 es " + a.get(0));        // rojo
    System.out.println("El elemento que hay en la posicion 3 es " + a.get(3));        // blanco
  }
}

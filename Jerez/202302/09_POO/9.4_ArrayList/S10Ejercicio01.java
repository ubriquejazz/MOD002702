/**
 * 1. Crea un ArrayList con los nombres de 6 compañeros de clase. A
 *    continuación, muestra esos nombres por pantalla. Utiliza para
 *    un bucle que recorra todo el ArrayList sin usar ningún índice.
 *
 * @author Luis José Sánchez
 */
import java.util.ArrayList;

public class S10Ejercicio01 {
  public static void main(String[] args) {
    
    ArrayList<String> a = new ArrayList<String>();
    a.add("Manuel");
    a.add("Salvador");
    a.add("Pablo");
    a.add("Irene");
    a.add("Juan");
    a.add("Yana");
    
    System.out.println("Contenido de la lista: ");
    for(String nombre : a) {
      System.out.println(nombre);
    }
  }
}

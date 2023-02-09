import java.util.ArrayList;

/**
 * Ejemplo de uso de la clase ArrayList
 * 
 * @author Luis José Sánchez
 */
public class EjemploArrayList06 {
  public static void main(String[] args) {

    ArrayList<String> a = new ArrayList<String>();
    Gato miGato = new Gato();
    a.add("rojo");
    a.add("verde");
    a.add("azul");
    a.add("blanco");
    a.add("amarillo");

    System.out.println("Contenido de la lista: ");

    System.out.println(a);

    a.add(1, "turquesa");
    System.out.println("Contenido de la lista despues de insertar en la pos 1: ");
    System.out.println(a);
  }
}

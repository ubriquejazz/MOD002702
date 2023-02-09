import java.util.HashMap;
import java.util.Map;

/**
 * Ejemplo de uso de la clase HashMap
 * 
 * @author Luis José Sánchez
 */
public class EjemploHashMap03 {
  public static void main(String[] args) {

    HashMap<Integer, String> m = new HashMap<>();
    m.put(924, "Amalia Nunez");
    m.put(921, "Cindy Nero");      
    m.put(700, "Cesar Vazquez");
    m.put(219, "Victor Tilla");
    m.put(537, "Alan Brito");
    m.put(605, "Esteban Quito ");

    System.out.println("Codigo\tNombre\n------\t-------------");
    for (Map.Entry pareja: m.entrySet()) {
      System.out.print(pareja.getKey() + "\t");
      System.out.println(pareja.getValue());
    }
  }
}

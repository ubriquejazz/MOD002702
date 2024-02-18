import java.util.HashMap;

/**
 * Ejemplo de uso de la clase HashMap
 * 
 * @author Luis José Sánchez
 */
public class EjemploHashMap04 {
  public static void main(String[] args) {

    HashMap<Integer, String> m = new HashMap<>();
    m.put(924, "Amalia Nunez");
    m.put(921, "Cindy Nero");      
    m.put(700, "Cesar Vazquez");
    m.put(219, "Victor Tilla");
    m.put(537, "Alan Brito");
    m.put(605, "Esteban Quito ");

    System.out.print("Por favor, introduzca un codigo: ");
    int codigoIntroducido = Integer.parseInt(System.console().readLine());
    if (m.containsKey(codigoIntroducido)) {
      System.out.print("El codigo " + codigoIntroducido + " corresponde a ");
      System.out.println(m.get(codigoIntroducido));
    } 
    else {
      System.out.print("El codigo introducido no existe.");
    }
  }
}

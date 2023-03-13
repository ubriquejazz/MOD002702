/**
 * 2. Realiza un programa que lea el fichero creado en el ejercicio anterior y
 *    que muestre los números por pantalla.
 *
 * @author Luis José Sánchez
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class S11Ejercicio02 {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
      int suma = 0;
      String linea = "";
      do {
        linea = br.readLine();
        if (linea != null) {
          suma += Integer.parseInt(linea);
          System.out.print(linea + " ");
        }
      } while (linea != null) ;
      System.out.println();
      System.out.println("La suma total es " + suma);
      br.close();
      
    } catch (IOException e) {
      System.out.println("Error de lectura.");
    }
  }
}

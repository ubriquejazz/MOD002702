/**
 * Aprende Java con Ejercicios (https://leanpub.com/aprendejava)
 * 
 * Capítulo 7. Arrays
 *
 * Ejercicio 14
 *
 * @author Luis José Sánchez
 */
 
public class S71Ejercicio14 {

  public static void muestraString(String palabra[]) {
    
    System.out.println("\n┌────────┬────────┬────────┬────────┬────────┬────────┬────────┬────────┐");
    for (int i = 0; i < 8; i++) {
      System.out.printf("│   %d    ", i);
    }
    System.out.println("│\n├────────┼────────┼────────┼────────┼────────┼────────┼────────┼────────┤");

    for (String p : palabra) {
      System.out.printf("│%-8s", p);
    }
    System.out.println("│\n└────────┴────────┴────────┴────────┴────────┴────────┴────────┴────────┘");

  }

  public static void main(String[] args) {

    String[] color = {
      "verde", "rojo", "azul", "amarillo", "naranja", "rosa", "negro ", "blanco", "morado"
    };
    String[] palabra = new String[8];
    String[] resultado = new String[8];
    int j = 0;
  
    System.out.println("Introduzca 8 palabras (vaya pulsando [INTRO] entre una y otra.");
    for (int i = 0; i < 8; i++) {
      palabra[i] = System.console().readLine();

      // Si la palabra introducida es un color, la guarda en el array resultado.
      for (String c : color) {
        if (palabra[i].equals(c)) {
          resultado[j++] = c;
        }
      }
    }

    // Mete las palabras que no son colores al final del array resultado.
    for (int i = 0; i < 8; i++) {
      boolean esColor = false;
      for (String c : color) {
        if (palabra[i].equals(c)) {
          esColor = true;
        }
      }
      if (!esColor) {
        resultado[j++] = palabra[i];
      }
    }

    // Muestra el array original.
    System.out.println("\n\nArray original:");
    muestraString(palabra);

    // Muestra el array resultado.
    System.out.println("\n\nArray resultado:");
    muestraString(resultado);
  }
}

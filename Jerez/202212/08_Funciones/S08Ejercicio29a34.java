/**
 * 
 * 8. Funciones - Arrays 2D
 * 
 * Ejercicios 29-34
 * 
 * @author Juan Gago
 * 
 */
 
import array.ArrayBi;
import java.util.Scanner;

public class S08Ejercicio29a34 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int[][] a = array.ArrayBi.generaArrayBiInt(5, 8, 0, 100);
    array.ArrayBi.muestraArrayBiInt(a);

    System.out.print("\nFila 2: ");
    array.Array.muestraArrayInt(array.ArrayBi.filaDeArrayBiInt(a, 2));
    System.out.print("Colm 6: ");
    array.Array.muestraArrayInt(array.ArrayBi.columnaDeArrayBiInt(a, 6));
    
    System.out.print("\nCoordenadas del 24 (fila, columna): ");
    array.Array.muestraArrayInt(array.ArrayBi.coordenadasEnArrayBiInt(a, 24));
    System.out.println();

    int[][] b = {{11, 10, 9}, {4, 5, 7}, {2, 6, 1}};
    array.ArrayBi.muestraArrayBiInt(b);
    System.out.println("Busca los puntos de silla: ");
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if (array.ArrayBi.esPuntoDeSilla(b, i, j)) {
          System.out.println("fila " + i + ", columna " + j + " -> "  + b[i][j]);
        }
      } // for j
    } // for i

    System.out.println();
    array.ArrayBi.muestraArrayBiInt(a);
    System.out.print("\nFila: ");
    int fila = sc.nextInt();
    System.out.print("Colm: ");
    int columna = sc.nextInt();
    System.out.print("Dirección (nose/neso): ");
    String direccion = sc.next();
    System.out.print("\nDiagonal: ");
    array.Array.muestraArrayInt(array.ArrayBi.diagonal(a, fila, columna, direccion));
  }

}

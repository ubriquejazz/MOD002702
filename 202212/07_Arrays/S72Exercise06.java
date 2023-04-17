/**
 * 7.2 Arrays bidimensionales
 * 
 * 6. Modica el programa anterior de tal forma que no se repita ningún número en el array.
 * 
 * @author Luis José Sánchez
 */
public class S72Exercise06 {

  static final int COL = 10;
  static final int FIL = 6;
  static int[][] Num = new int[FIL][COL];

  public static boolean compruebaSiRepetido (int a, int fila, int columna) {
    boolean repetido = false;
    for (int i = 0; i < COL * fila + columna; i++) {
      if (a == Num[i / COL][i % COL]) {
        repetido = true;
      }
    }
    return repetido;
  }

  public static void main(String[] args) throws InterruptedException {
 
    int fila, columna, i, j;

    // Genera el contenido del array sin que se repita ningún valor
    boolean repetido;
      
    for (fila = 0; fila < FIL; fila++) {
      for (columna = 0; columna < COL; columna++) {
        do {         
          Num[fila][columna] = (int)(Math.random() * 1001);
          // Comprueba si el número generado ya está en el array.
          repetido = compruebaSiRepetido(Num[fila][columna], fila, columna);
        } while (repetido);
      }
    }

    int minimo = Integer.MAX_VALUE;
    int filaMinimo = 0;
    int columnaMinimo = 0;
    
    int maximo = Integer.MIN_VALUE;
    int filaMaximo = 0;
    int columnaMaximo = 0;

    System.out.print("\n      ");
    for(columna = 0; columna < COL; columna++) {
      System.out.print("   " + columna + "  ");
    }
    System.out.println();
    
    System.out.print("    ┌");
    for(columna = 0; columna < COL; columna++) {
      System.out.print("──────");
    }
    //System.out.println("");
    System.out.println();

    for(fila = 0; fila < FIL; fila++) {
      System.out.print("  " + fila + " │");
      for(columna = 0; columna < COL; columna++) {
        System.out.printf("%5d ", Num[fila][columna]);
        Thread.sleep(100);
        
        // Calcula el mínimo y guarda sus coordenadas
        if (Num[fila][columna] < minimo) {
          minimo = Num[fila][columna];
          filaMinimo = fila;
          columnaMinimo = columna;
        }
        
        // Calcula el máximo y guarda sus coordenadas
        if (Num[fila][columna] > maximo) {
          maximo = Num[fila][columna];
          filaMaximo = fila;
          columnaMaximo = columna;
        }
      }
      System.out.println("│");
    }
    System.out.print("    └");
    for(columna = 0; columna < COL; columna++) {
      System.out.print("──────");
    }

    System.out.println("┘\n\nEl máximo es " + maximo + " y está en la fila " + filaMaximo + ", columna " + columnaMaximo);
    System.out.println("El mínimo es " + minimo + " y está en la fila " + filaMinimo + ", columna " + columnaMinimo);
  }
}

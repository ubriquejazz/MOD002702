/**
 * 7.1 Arrays
 * 
 * 10. Escribe un programa que genere 20 números enteros aleatorios entre 0 y 100 y que los
 *     almacene en un array. El programa debe ser capaz de pasar todos los números pares a
 *     las primeras posiciones del array (del 0 en adelante) y todos los números impares a
 *     las celdas restantes. Utiliza arrays auxiliares si es necesario.
 *
 * @author Luis José Sánchez
 */
public class S71Ejercicio10 {

  public static void muestraArrayInt(int numero[]) {
    int i;
    for (i = 0; i < 20; i++) {
      System.out.print(numero[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
  
    int[] n = new int[20];
    int[] par = new int[20];
    int[] impar = new int[20];

    String morado = "\033[35m";
    String blanco = "\033[37m";
    int i;
    int pares = 0;
    int impares = 0;
    
    for (i = 0; i < 20; i++) {
      n[i] = (int)(Math.random() * 101);
      // Separa los números metiendo los pares en un array
      // y los impares en otro.
      if (n[i] % 2 == 0) {
        par[pares++] = n[i];
      } else {
        impar[impares++] = n[i];
      }
    }
    
    System.out.println(morado + "Array original:" + blanco);
    muestraArrayInt(n);
    
    // Mete los pares en las primeras posiciones
    // del array original.
    for (i = 0; i < pares; i++) {
      n[i] = par[i];
    }
    
    // Mete los impares en los huecos que quedan.
    for (i = pares; i < 20; i++) {
      n[i] = impar[i - pares];
    }

    System.out.println(morado + "Array con los pares al principio:" + blanco);
    muestraArrayInt(n);
  }
}

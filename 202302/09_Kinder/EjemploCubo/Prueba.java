public class Prueba {
  public static void main(String[] args) {
    System.out.println("Hola");
    Cubo cubito = new Cubo(2);
    Cubo cubote = new Cubo(7);

    System.out.println("\nLleno el cubito: \n");
    cubito.llena();
    cubito.pinta();

    System.out.println("\nAhora vuelco lo que tiene el cubito en el cubote.\n");
    cubito.vuelcaEn(cubote);

    System.out.println("Cubito: \n");
    cubito.pinta();

    System.out.println("\nCubote: \n");
    cubote.pinta();

    System.out.println("\nAhora vuelco lo que tiene el cubote en el cubito.\n");
    cubote.vuelcaEn(cubito);

    System.out.println("Cubito: \n");
    cubito.pinta();

    System.out.println("\nCubote: \n");
    cubote.pinta();    
  }

}
/**
 *    S10Ejercicio05 - Gestión de una colección de discos.
 *
 *    Realiza de nuevo el ejercicio de la colección de discos pero
 *    utilizando esta vez una lista para almacenar la información
 *    sobre los discos en lugar de un array convencional. Comprobarás
 *    que el codigo se simplifica notablemente ¿Cuánto ocupa el programa
 *    original hecho con un array? ¿Cuánto ocupa este nuevo programa
 *    hecho con una lista?
 *         
 * @author Luis José Sánchez
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void menuPrincipal() {
    System.out.println("\n\nCOLECCIoN DE DISCOS");
    System.out.println("===================");
    System.out.println("1. Listado");
    System.out.println("2. Nuevo disco");
    System.out.println("3. Modificar");
    System.out.println("4. Borrar");
    System.out.println("5. Salir");    
  }

  public static void listadoMenu() {
    System.out.println("\nLISTADO\n=======");
    System.out.println("1. Completo");
    System.out.println("2. Por autor");
    System.out.println("3. Por genero");
    System.out.println("4. En un rango de duracin");
    System.out.println("5. Volver menu principal");
  }

  public static void main(String[] args) {  
    int i;
    String codigoIntroducido;
    String autorIntroducido;
    String tituloIntroducido;
    String generoIntroducido;
    String duracionIntroducidaString;
    int opcion;
    int opcionListado;
    int duracionIntroducida;
    int limiteInferior;
    int limiteSuperior;

    Scanner s = new Scanner(System.in);
    Discoteca a = new Discoteca();
    a.create("GASA41", "Wim Mertens", "Maximazing the Audience", "instrumental", 50);
    a.create("FGHQ64", "Metallica", "Black album", "hard rock", 46);
    a.create("TYUI89", "Supersubmarina", "Viento de cara", "pop rock", 42);

    do {
      menuPrincipal();
      System.out.print("Introduzca una opcion: ");
      opcion = Integer.parseInt(s.nextLine());      
      switch (opcion) {
      // LISTADO //////////////////////////////////////////////////////////////////
      case 1:
        do {
          listadoMenu();
          System.out.print("Introduzca una opcion: ");
          opcionListado = Integer.parseInt(s.nextLine());                  
          switch (opcionListado) {
            case 1: // Listado completo /////////////////
                a.listar();
                break;

            case 2: // Listado por autor ////////////////  
              System.out.print("Introduzca el autor: ");
              autorIntroducido = s.nextLine(); 
              a.listar(autorIntroducido);
              break;

            case 3: // Listado por genero ////////////////  
              System.out.print("Introduzca el genero: ");
              generoIntroducido = s.nextLine(); 
              a.listarG(generoIntroducido);
              break;

            case 4: // Listado en un rango de duracion ////  
              System.out.println("Establezca el intervalo para la duracion");
              System.out.print("Introduzca el lim inferior de duracion en minutos: ");
              limiteInferior = Integer.parseInt(s.nextLine());
              System.out.print("Introduzca el lim superior de duracion en minutos: ");
              limiteSuperior = Integer.parseInt(s.nextLine());
              a.listar(limiteInferior, limiteSuperior);
              break;
          } // switch (opcionListado)
    
        } while (opcionListado != 5);
        break;
      
      // NUEVO DISCO //////////////////////////////////////////////////////////////
      case 2:
        System.out.println("\nNUEVO DISCO\n===========");
        System.out.println("Por favor, introduzca los datos del disco.");  
        System.out.print("Codigo: ");
        codigoIntroducido = s.nextLine();   
        while(a.existe(codigoIntroducido)) {
          System.out.println("Ese código ya existe en la base de datos.");
          System.out.print("Introduzca otro código: ");
          codigoIntroducido = s.nextLine();
        }

        System.out.print("Autor: ");
        autorIntroducido = s.nextLine();        
        System.out.print("Titulo: ");
        tituloIntroducido = s.nextLine();      
        System.out.print("Genero: ");
        generoIntroducido = s.nextLine();      
        System.out.print("duracion: ");
        duracionIntroducida = Integer.parseInt(s.nextLine());
        a.create(codigoIntroducido, autorIntroducido, tituloIntroducido, generoIntroducido, duracionIntroducida);
        break;
        
      // MODIFICAR ////////////////////////////////////////////////////////////////
      case 3:
        System.out.println("\nMODIFICAR\n===========");        
        System.out.print("Por favor, introduzca el codigo del disco cuyos datos desea cambiar: ");
        codigoIntroducido = s.nextLine();
        while(a.existe(codigoIntroducido)) {
          System.out.println("Ese código ya existe en la base de datos.");
          System.out.print("Introduzca otro código: ");
          codigoIntroducido = s.nextLine();
        }

        Disco nuevo = a.read(codigoIntroducido);
        System.out.println("Introduzca los nuevos datos del disco o INTRO para dejarlos igual.");  
        System.out.println("Codigo: " + nuevo.getCodigo());
        System.out.print("Nuevo codigo: ");
        codigoIntroducido = s.nextLine();
        // nuevo.setCodigo(codigoIntroducido);

        System.out.println("Autor: " + nuevo.getAutor());
        System.out.print("Nuevo autor: ");
        autorIntroducido = s.nextLine();
        // nuevo.setAutor(autorIntroducido);

        System.out.println("Titulo: " + nuevo.getTitulo());
        System.out.print("Nuevo titulo: ");
        tituloIntroducido = s.nextLine();
        // nuevo.setTitulo(tituloIntroducido);

        System.out.println("Genero: " + nuevo.getGenero());
        System.out.print("Nuevo genero: ");
        generoIntroducido = s.nextLine();
        // nuevo.setGenero(generoIntroducido);

        System.out.println("Duracion: " + nuevo.getDuracion());
        System.out.print("Nueva duracion: ");
        duracionIntroducidaString = s.nextLine();
        // nuevo.setDuracion(Integer.parseInt(duracionIntroducidaString));        
        break;

      // BORRAR ///////////////////////////////////////////////////////////////////
      case 4:
        System.out.println("\nBORRAR\n======");        
        System.out.print("Por favor, introduzca el codigo del disco que desea borrar: ");
        codigoIntroducido = s.nextLine();
        if (true)
          System.out.println("Lo siento, el codigo introducido no existe.");
        else 
          // album.remove(album.indexOf(new Disco(codigoIntroducido,"", "", "", 0)));
          System.out.println("Album borrado.");        
        break;

      default:
        break;
      } // switch

    } while (opcion != 5); // do while
  }
}
import java.util.Scanner;

public class App {

    public static void test01() {
        Profesor profeSergio = new Profesor("Sergio", 18, "Java", 100);
        Alumno alum01 = new Alumno("Juan", 20, 9.5);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // entrada de una cadena
        String name = sc.nextLine();
        try {
            int i = Integer.parseInt(name);
            System.out.println("Es un numero");
            //delete_porID(i);
        }
        catch (NumberFormatException e) {
            System.out.println("No es un numero");
           // delete_porNombre();
        }
        

    }
    
}

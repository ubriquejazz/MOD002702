import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fraccion fraccion1, fraccion2;
        
        System.out.println("Ingrese el numerador y el denominador de la primera fracción:");
        int numerador1 = scanner.nextInt();
        int denominador1 = scanner.nextInt();
        fraccion1 = new Fraccion(numerador1, denominador1);
        
        System.out.println("Ingrese el numerador y el denominador de la segunda fracción:");
        int numerador2 = scanner.nextInt();
        int denominador2 = scanner.nextInt();
        fraccion2 = new Fraccion(numerador2, denominador2);
        
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenú:");
            System.out.println("1. Sumar fracciones");
            System.out.println("2. Restar fracciones");
            System.out.println("3. Multiplicar fracciones");
            System.out.println("4. Dividir fracciones");
            System.out.println("5. Simplificar fracciones");
            System.out.println("6. Mostrar fracciones");
            System.out.println("7. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Suma de fracciones: " + fraccion1.add(fraccion2));
                    break;
                case 2:
                    System.out.println("Resta de fracciones: " + fraccion1.subtract(fraccion2));
                    break;
                case 3:
                    System.out.println("Multiplicación de fracciones: " + fraccion1.multiply(fraccion2));
                    break;
                case 4:
                    System.out.println("División de fracciones: " + fraccion1.divide(fraccion2));
                    break;
                case 5:
                    fraccion1.simplificar();
                    fraccion2.simplificar();
                    System.out.println("Fracción 1 simplificada: " + fraccion1);
                    System.out.println("Fracción 2 simplificada: " + fraccion2);
                    break;
                case 6:
                    System.out.println("Fracción 1: " + fraccion1);
                    System.out.println("Fracción 2: " + fraccion2);
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
        
        scanner.close();
        System.out.println("¡Gracias por usar este programa!");
    }
}

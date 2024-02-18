import java.util.Scanner;

public class SumaParesImpares {

    public static void main(String[] args) {
        int suma_pares = 0;
        int suma_impares = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Introduce un número (introduce 0 para salir): ");
        int num = input.nextInt();
        while (num != 0) {
            if (num % 2 == 0) {
                suma_pares += num;
            } else {
                suma_impares += num;
            }
            System.out.print("Introduce un número: ");
            num = input.nextInt();
        }
        System.out.println("La suma de los números pares es: " + suma_pares);
        System.out.println("La suma de los números impares es: " + suma_impares);
    }
}

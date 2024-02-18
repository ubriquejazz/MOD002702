import java.util.Scanner;

public class NumeroPrimo {
    public static void main(String[] args) {
        int i = 2;
        boolean es_primo = true;
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int num = input.nextInt();
        while ( i <= num/2 && es_primo) {
            if (num % i == 0) {
                es_primo = false;
            }
            i++;
        }
        if (es_primo) {
            System.out.println(num + " es un número primo.");
        } else {
            System.out.println(num + " no es un número primo.");
        }
    }
}
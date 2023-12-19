import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PuenteXtal {

    public static int[] generaSec(int size) {
        Random random = new Random();
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(2);
        }
        return a;
    }
    
    public static boolean comprueba(int[] camino, int i, int myBet) {
        boolean retVal = false;
        if (camino[i] == myBet) retVal = true;
        return retVal;
    }
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca el numero de baldosas (8): ");
        int size = s.nextInt();
        int tries = 1;
        while (true) {
            int i = 0;
            int[] camino = generaSec(size);
            int value;
            do {
                System.out.println("Cual es su decision para " + i + ": ");
                value = s.nextInt();
            } while ( (value>=0) && comprueba(camino, i++, value) && (i<size) );
            if (value<0) break;
            if (i<8) {
                System.out.println("Has fallado! Empieza de nuevo");
                tries++;
                //break;
            }
            else {
                System.out.println("Lo has conseguido en " + tries + " intentos");
                break;
            }
        }
    }
}

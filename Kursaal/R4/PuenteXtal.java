import java.util.Arrays;
import java.util.Scanner;

public class PuenteXtal {

    public static int[] generaSec(int size) {
        int[] camino = new int[size];
        camino[1] = 1;
        camino[3] = 1;
        camino[5] = 1;
        return camino;
    }
    
    public static boolean comprueba(int[] camino, int i, int value) {
        boolean retVal = false;
        if (camino[i] == value) retVal = true;
        return retVal;
    }
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca el numero de baldosas (8): ");
        //int size = s.nextInt();
        int[] camino = generaSec(8);
        System.out.println(Arrays.toString(camino));;
        int tries = 0;
        while (true) {
            int i = 0;
            int value;
            do {
                System.out.println("Cual es su decision para" + i + ": ");
                value = s.nextInt();
            } while (comprueba(camino, i, value) && (i<8));
            if (i<8) {
                System.out.println("Has fallado! Empieza de nuevo");
                tries++;
            }
            else {
                System.out.println("Lo has conseguido en " + tries + "intentos");
                break;
            }
        }
    }
}

import java.util.Arrays;

/**
 * Examen Section1 Flow Control
 */
public class ExamenSection1 {

    public static void nestedLoop() {
        for (int i = 0; i<6; i++) {
            for (int j=0; j<i; j++) {
                System.out.print(j+1);
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void vectores() {
        double[] temperatures = {22.5, 23.0, 21.8, 25.5, 24.0};
        System.out.println(Arrays.toString(temperatures));
        double average = 0;
        for (int i=0; i<temperatures.length; i++) {
            average += temperatures[i];
        }
        average /= temperatures.length;
        System.out.println("The average temperature is " + average);
    }

    public static void main(String[] args) {
        System.out.println("Enter a number");
        int n = 0;
        if (n%2 == 0)
            System.out.println(n + " is even");
        else
            System.out.println(n + " is odd");

        nestedLoop();
        vectores();
    }
}
import java.util.*; 

public class Multadd {

    public static double multadd(double a, double b, double c) {
        return a * b + c;
    }

    public static double expSum(double x) {
        double a = Math.exp(-x);
        // Math.sqrt(1 - a)
        return multadd(x, a, Math.sqrt(1 - a));
    }

    public static void main(String[] args) {
        double x = 1.0;
        double y = 2.0;
        double z = 3.0;
        System.out.println("Result of multadd(...) is: " + multadd(x,y,z));

        x = 0.5;
        y = Math.cos (Math.PI/4);
        z = Math.sin (Math.PI/4);
        System.out.printf("Result of sin + cos/2 is: %.2f\n", multadd(x,y,z));

        x = 1.0;
        y = Math.log(10);
        z = Math.log(20);
        System.out.printf("Result of log10 + log20 is: %.2f\n", multadd(x,y,z));

        x = 1.0;
        // 1/e + sqrt(1 - 1/e) = 1.16
        System.out.printf("Result of expSum(1.0) is: %.2f\n", expSum(x));
    }
}

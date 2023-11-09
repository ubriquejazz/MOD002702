public class Ex62 {

    final static double MIN = 0.0001;

    // x1 =(x0 + a/x0) / 2 
    public static double squareRoot(double a) {
        double x1 = 1.0;
        double x0 = a/2;
        while (Math.abs(x0-x1) > MIN) {
            x1 = x0;
            x0 = (x0 + a/x0) / 2;
        }
        return x0;
    }
    public static void main(String [] args) {
        double x[] = {4, 9, 16, 25, 36};
        for (double d : x) {
            System.out.printf("The sqrt(%.0f) is %.2f\n", d, squareRoot(d));
        }
    }
}
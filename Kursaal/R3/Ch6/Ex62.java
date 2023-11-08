public class Ex62 {

    final static double MIN = 0.0001;

    public static double squareRoot(double a) {
        double previous = 0;
        double current = a/2;

        while (Math.abs(previous - current) > MIN){
            previous = current; // para la siguiente iteracion
            current = (current + a/current) /2; // nueva iteraccion
        }
        return current;
    }
    public static void main(String [] args) {
        double x[] = {9, 16, 25, 49, 64};
        for (int i=0; i<5; i++) {
            System.out.printf("sqrt(%.2f) is %.2f\n", x[i], squareRoot(x[i]));
        }
    }
}
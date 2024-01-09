/* 
 * You can improve the efficiency of the power method by taking advantage of the 
 * fact that x^n can be expressed as x^(n/2) * x^(n/2) when n is even. H
 */
public class PowerCalculator {

    public static double power(double x, int n) {
        if (n == 0) {
            return 1; // base case
        }

        // If n is even, use the formula x^n = (x^(n/2))^2
        if (n % 2 == 0) {
            double halfPower = power(x, n / 2);
            return halfPower * halfPower;
        } else 
            return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        // Example usage:
        double result = power(2, 3);
        System.out.println(result);  // Output: 8.0
    }
}

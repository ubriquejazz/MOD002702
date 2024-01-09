/* 
Write a recursive method called power that takes a double x and an integer n and returns x^n.
*/
public class Power {

    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        // Recursive case: calculate x^n as x times x^(n-1)
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        double result = power(2, 3);
        System.out.println(result);  // Output: 8.0
    }
    
}

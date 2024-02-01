/*
 * 
 *     
 * 1. Display a table of the integers from 0 to 30 along with their factorials. At some point around 15, you will probably see that the answers are not correct anymore. Why not?
 * 
 * 2. Convert factorial so that it performs its calculation using BigIntegers and returns a BigInteger as a result. You can leave the parameter alone; it will still be an integer.
 *  
 * 3. Try displaying the table again with your modified factorial method. Is it correct up to 30? How high can you make it go?
 *          I've tried upto 10000 and it´s still looking good, the problem is that my computer doesnt go very fast so I couldn´t test it with higher numbers
 */
import java.math.BigInteger;

public class Victor {
    
    public static void printRow(int n) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(n + "! = " + result);
    }

    
    public static void printTable(int rows) {
        for (int i = 1; i <= rows; i++) {     // generalized rows
            printRow(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("\nprintTable(" + args[0] + ")");
        printTable(Integer.parseInt(args[0]));
    }

}

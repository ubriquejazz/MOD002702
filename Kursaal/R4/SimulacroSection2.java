import java.util.Scanner;

public class SimulacroSection2 {
    
    // 2.1 Using a loop, print the first 5 multiples of 3.
    public static void multiples(int n) {
        for (int i=1; i<6; i++) {
            System.out.print(" " + n*i);
        }
    }
    // 2.2 Program that prompts the user to enter an integer. 
    // If the number is positive, print "Positive"; if negative, print "Negative"; if zero, print "Zero."
    public static void readNumber() {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce a number: ");
        int n = s.nextInt();
        if (n>0) 
            System.out.println(n + " is positive");
        else if (n<0)
            System.out.println(n + " is negative");
        else 
            System.out.println(n + " is zero");
    }

    public static int sum(int[] num ) {
        int sum = 0;
        for (int i=0; i<num.length; i++) {
            sum += num[i];
        }
        return sum;
    }

    public static void main (String[] args) {
        System.out.print("Ex01: ");
        multiples(3);
        System.out.print("\nEx02: ");
        readNumber();
        // 3.1 Declare an array of integers named numbers with the values 2, 4, 6, 8
        int[] num = {2, 4, 6, 8, 10};
        // 3.2 Write a loop to calculate the sum of all elements in the numbers array
        System.out.println("Ex03: The sum of all elements is " + sum(num));
    }
}

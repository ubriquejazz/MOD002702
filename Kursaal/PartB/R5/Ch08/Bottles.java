/* 
https://www.youtube.com/watch?v=FITjBet3dio
Write a program that displays the entire lyrics of “99 Bottles of Beer”. 
Your program should include a recursive method that does the hard part, 
but you might want to write additional methods to separate other ...
*/

public class Bottles {

    public static void song(int n) {
        if (n == 0) 
            System.out.println("No bottles of beer on the wall");
        else {
            System.out.println(n + " bottles of beer on the wall");
            song(n-1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Let's sing 99 Bottles of Beer!!!");
        song(10);
    }
}

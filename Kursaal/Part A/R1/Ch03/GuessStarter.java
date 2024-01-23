package Ch03;

import java.util.Random;
import java.util.Scanner;

public class GuessStarter {
    
    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);

        int aleatorio = random.nextInt(100) + 1;
        
        System.out.println("I'm thinking of a number between 1 and 100 ");
        System.out.println("(including). Can you guess what it is?");

        System.out.print("Type a number: ");
        int usuario = in.nextInt();

        System.out.println("Your guest is: " + usuario);
        System.out.println("The number I was thinking of is: " + aleatorio);
        System.out.println("You were off by: " + Math.abs(aleatorio - usuario));
    }
}

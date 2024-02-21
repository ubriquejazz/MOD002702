/*
 * Write a toString method for the Deck class. It should 
 * return a single string that represents the cards in the deck. 
 */

public class Ex1 {

    public static void main(String[] args) {
        Deck d1 = new Deck();
        d1.shuffle();
        Deck d2 = d1.subdeck(10, 20);

        System.out.println(d2);
        
    }
    
}

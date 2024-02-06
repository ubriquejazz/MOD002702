import java.util.Arrays;

public class Ex1 {

    // Encapsulate the deck-building code that takes no parameters
    // and returns a fully populated array of Cards.
    public static Card[] makeDeck() {
        Card[] cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        return cards;
    }
    
    public static void main(String[] args) {
        Card[] deck = makeDeck();
        System.out.println(Arrays.toString( deck ));
    }
    
}

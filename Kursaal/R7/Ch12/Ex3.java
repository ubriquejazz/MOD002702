import java.util.Arrays;

public class Ex3 {

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

    // method that takes an array of cards as a parameter and returns a histogram of the suits in the hand.
    public static int[] suitHist(Card[] cards) {
        int[] hist= new int[4];
        for (int i=0; i<cards.length; i++) {
            int index = cards[i].getSuit();
            hist[index]++;
        }
        return hist;
    }
    
    public static void main(String[] args) {
        int[] histogram;
        
        Card[] cards = new Card[4];
        cards[0] = new Card(1,0);
        cards[3] = new Card(11,0);
        cards[1] = new Card(1,1);
        cards[2] = new Card(11,1);

        histogram = suitHist(cards);
        System.out.println("Hola " + Arrays.toString(histogram));

        Card[] deck = makeDeck();
        histogram = suitHist(deck);
        System.out.println("Deck " + Arrays.toString(histogram));
    }
}

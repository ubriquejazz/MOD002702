import java.util.Arrays;
import java.util.Random;

/**
 * A deck of playing cards (of fixed length).
 */
public class Deck {

    // This is a class variable so we don't have to create
    // a new Random object every time we call randomInt.
    private static Random random = new Random();
    private Card[] cards;

    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    /**
     * Constructs a deck of n cards (all null).
     */
    public Deck(int n) {
        this.cards = new Card[n];
    }

    /**
     * Gets the internal cards array.
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Displays each of the cards in the deck.
     */
    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    /**
     * Returns a string representation of the deck.
     */
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Card card : this.cards) {
            text.append(card);
            text.append('\n');
        }
        return text.toString();
    }

    /**
     * Randomly permutes the array of cards.
     */
    public void shuffle() {
        int len = this.cards.length;
        for (int i = 1; i<len; i++) {
            // choose a random number between i and length - 1
            int j = randomInt(i, len-1);
            // swap the ith card and the randomly-chosen card
            swapCards(i, j);
        }
    }

    /**
     * Chooses a random number between low and high, including both.
     */
    private static int randomInt(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    /**
     * Swaps the cards at indexes i and j in a sorted deck of 52 cards.
     */
    private void swapCards(int i, int j) {
        Card tmp = this.cards[i];
        this.cards[i] = this.cards[j];
        this.cards[j] = tmp;
    }

    /**
     * Sorts the cards (in place) using selection sort. No efficient!
     */
    public void selectionSort() {
        int len = this.cards.length;
        for (int i = 1; i<len; i++) {
            // find the lowest card at or to the right of i
            int j = indexLowest(i, len-1);
            // swap the ith card and the lowest card found
            swapCards(i, j);
        }
    }

    /**
     * Finds the index of the lowest card
     * between low and high inclusive.
     */
    private int indexLowest(int low, int high) {
        int lowestIndex = -1;
        int lowestValue = Integer.MAX_VALUE; // Set to maximum possible integer value

        for (int i = low; i <= high; i++) {
            // Get the rank value of the card
            // rankValue = getRankValue(deck[i].rank);
            int rankValue = this.cards[i].position();
            
            // Update lowestIndex if the current card's value is lower
            if (rankValue < lowestValue) {
                lowestIndex = i;
                lowestValue = rankValue;
            }
        }
        return lowestIndex;
    }

    /**
     * Returns a subset of the cards in the deck.
     */
    public Deck subdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    /**
     * Returns the histogram by suit
     */
    public static int[] suitHist(Deck hand) {
        int[] hist= new int[4];
        int len = hand.cards.length;
        for (int i=0; i<len; i++) {
            int index = hand.cards[i].getSuit();
            hist[index]++;
        }
        return hist;
    }

    private static int[] royalHist(Deck hand) {
        int[] hist= new int[4];
        int len = hand.cards.length;
        for (int i=0; i<len; i++) {
            if (hand.cards[i].getRank() >= 10) {
                int index = hand.cards[i].getSuit();
                hist[index] ++;
            }
        }
        return hist;
    }

    /**
     * hand that contains five or more cards of the same suit
     * @param hand
     * @return
     */
    public static boolean hasFlush(Deck hand) {
        int[] hist = suitHist(hand);
        for (int h : hist) {
            if (h >= 5) return true;
        }
        return true;
    }    

    /**
     * royal flush
     * determines whether an array of cards contains a royal flush.
     */
    public static boolean hasRoyal(Deck hand) {
        int[] hist = royalHist(hand);
        for (int h : hist) {
            if (h >= 5) return true;
        }
        return false;
    }

    
}

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
        return Arrays.toString(this.cards[0]));
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
     * Combines two previously sorted subdecks.
     */
    private static Deck merge(Deck d1, Deck d2) {
        // create a new deck, d3, big enough for all the cards
        Deck d3 = new Deck(d1.cards.length + d2.cards.length);
        int i = 0;  // to keep track of where we are at in d1
        int j = 0;  // to keep track of where we are at in d2

        // the index k traverses the result deck
        for (int k = 0; k < d3.cards.length; k++) {
            // if d1 is empty, use top card from d2
            // if d2 is empty, use top card from d1
            

            // otherwise, compare the top two cards
            if (d1.cards[i].compareTo(d2.cards[j]) > 0) {
                d3.cards[k] = d1.cards[i];
                k++;
                i++;
            }
            else {
                d3.cards[k] = d2.cards[j];
                k++;
                j++;
            }
        }
        // return the new deck
        return d3;
    }

    /**
     * Returns a sorted copy of the deck using selection sort.
     */
    public Deck almostMergeSort() {
        // divide the deck into two subdecks
        // sort the subdecks using selectionSort
        // merge the subdecks, return the result
        return this;
    }

    /**
     * Returns a sorted copy of the deck using merge sort. Efficient!
     */
    public Deck mergeSort() {
        // if the deck has 0 or 1 cards, return it
        // otherwise, divide the deck into two subdecks
        // sort the subdecks using mergeSort
        // merge the subdecks
        // return the result
        return this;
    }

}

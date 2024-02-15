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
    
    // flush is a hand that contains five or more cards of the same suit.
    // method that takes an array of cards and returns true if the hand contains a flush (and false otherwise).
    public static boolean hasFlush(Card[] cards) {
        int suit = cards[0].getSuit();
        for (int i=0; i<cards.length; i++) {
            if (suit != cards[i].getSuit())
                return false;
        }
        return true;
    }

    // method iterates through the array and checks if each element is equal to the target value. 
    public static boolean contains(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    // method that determines whether an array of cards contains a royal flush.
    public static boolean hasRoyal(Card[] cards) {
        int[] mult = {2, 3, 5, 7}; // ten, jack, queen, king
        int[] hist = {1, 1, 1, 1};
        
        for (int i=0; i<cards.length; i++) {
            Card card = cards[i];
            if (card.getRank() == 1) 
                hist[card.getSuit()] *= 11; // ace
              
            for (int j=10; j<=13; j++) {
                if (card.getRank() == j) 
                    hist[card.getSuit()] *= mult[j-10];   
            } 
        }
        for (int h : hist) {
            if ((h%11==0) && (h%mult[0]==0) && (h%mult[1]==0) && (h%mult[2]==0) && (h%mult[3]==0))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] histogram;
        
        Card[] myHand = new Card[6];
        myHand[0] = new Card(1,0);
        myHand[1] = new Card(10,0);
        myHand[2] = new Card(11,0);
        myHand[3] = new Card(12,0);
        myHand[4] = new Card(13,0);
        myHand[5] = new Card(7,1);

        if (hasRoyal(myHand))
            System.out.println("Tienes escalera de color");
        if (hasFlush(myHand))
            System.out.println("Tienes escalera normal");

        Card[] deck = makeDeck();
        histogram = suitHist(deck);
        System.out.println("Deck " + Arrays.toString(histogram));
    }
}

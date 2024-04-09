/* Find and open the file War.java in the repository
 * The program is incomplete. When there’s a tie, 
 * draw three cards from each pile ...
 */

public class Ex5 {

    final static int N = 5;

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Pile p1 = new Pile();
        Pile p2 = new Pile();

        p1.addDeck(deck.subdeck(0, 25));
        p2.addDeck(deck.subdeck(26, 51));
        boolean continuePlay = true;
        
        while (!p1.isEmpty() && !p2.isEmpty() && continuePlay) {
            Card c1 = p1.popCard();
            Card c2 = p2.popCard();
            int diff = c1.getRank() - c2.getRank();
            if (diff > 0) {
                p1.addCard(c1);
                p1.addCard(c2);
            } else if (diff < 0) {
                p2.addCard(c1);
                p2.addCard(c2);
            } else {
                System.out.print("It's a tie. ");
                Pile warCards = new Pile();
                boolean continueWar = true;
                while (continueWar) {
        
                    // Check if players have enough cards for war
                    if (p1.size() < N || p2.size() < N) {
                        System.out.println("One player does not have enough cards for war. Game over.");
                        continuePlay = false;
                        break;
                    }
                    for (int j = 1; j < N; j++) {
                        warCards.addCard(p1.popCard());
                        warCards.addCard(p2.popCard());
                    }
        
                    c1 = p1.popCard();
                    c2 = p2.popCard();
                    diff = c1.getRank() - c2.getRank();
                  
                    if (diff > 0) {
                        System.out.println("Player 1 wins the war!");
                        System.out.println(c1 + " > " + c2);
                        // player1Wins += warCards.size();
                        p1.merge(warCards);
                        p1.addCard(c1);
                        p1.addCard(c2);
                        continueWar = false;
                    } else if (diff < 0) {
                        System.out.println("Player 2 wins the war!");
                        System.out.println(c2 + " > " + c1);
                        //player2Wins += warCards.size();
                        p2.merge(warCards);
                        p2.addCard(c1);
                        p2.addCard(c2);
                        continueWar = false;
                    } else {
                        System.out.println("Another tie in the war! Proceeding to another round of war.");
                        warCards.addCard(c1);
                        warCards.addCard(c2);
                    }
                }
                System.out.println();
            }
        }
        if (p2.isEmpty()) {
            System.out.println("\nPlayer 1 wins!");
        } else {
            System.out.println("\nPlayer 2 wins!");
        }
    }
}
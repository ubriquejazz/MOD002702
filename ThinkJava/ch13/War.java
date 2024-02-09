/**
 * Simulates a simple card game.
 */
public class War {

    public static void main(String[] args) {

        // create and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();

        // divide the deck into piles
        Pile p1 = new Pile();
        p1.addDeck(deck.subdeck(0, 25));
        Pile p2 = new Pile();
        p2.addDeck(deck.subdeck(26, 51));

        // while both piles are not empty
        while (!p1.isEmpty() && !p2.isEmpty()) {
            Card c1 = p1.popCard();
            Card c2 = p2.popCard();

            // compare the cards
            int diff = c1.getRank() - c2.getRank();
            if (diff > 0) {
                p1.addCard(c1);
                p1.addCard(c2);
            } else if (diff < 0) {
                p2.addCard(c1);
                p2.addCard(c2);
            } else {

                boolean continueWar = true;
                Pile war = new Pile();
                while (continueWar) {
                    // Check if players have enough cards for war
                    if (p1.size() < 4 || p2.size() < 4) {
                        System.out.println("One player does not have enough cards for war. Game over.");
                        continueWar = false;
                        break;
                    }

                    for (int j = 0; j < 2; j++) {
                        war.addCard(p1.popCard());
                        war.addCard(p1.popCard());
                    }
                    c1 = p1.popCard();
                    c2 = p2.popCard();
                    diff = c1.getRank() - c2.getRank();

                    // don't forget
                    war.addCard(c1);
                    war.addCard(c2);
                         
                    if (diff > 0) {
                        System.out.println("Player 1 wins the war!");
                        p1.merge(war);
                        continueWar = false;
                    } else if (diff < 0) {
                        System.out.println("Player 2 wins the war!");
                        p2.merge(war);
                        continueWar = false;
                    } else {
                        System.out.println("Another tie in the war! Proceeding to another round of war.");
                        // Add war cards back to the warCards list for the next round of war
                    }
                }
            }
        }

        // display the winner
        if (p2.isEmpty()) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }

}

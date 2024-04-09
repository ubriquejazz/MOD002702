import java.util.Scanner;

/**
 * Simulates a game of Crazy Eights.
 * See https://en.wikipedia.org/wiki/Crazy_Eights.
 */
public class Eights {

    private PlayerHighest one;
    private PlayerEight two;
    private Hand drawPile;
    private Hand discardPile;

    /**
     * Initializes the state of the game.
     */
    public Eights() {
        Deck deck = new Deck("Deck");
        deck.shuffle();

        // deal cards to each player
        one = new PlayerHighest("Alto");
        deck.deal(one.getHand(), 5);

        // playing eitght first
        two = new PlayerEight("Ocho");
        deck.deal(two.getHand(), 5);

        // turn one card face up
        discardPile = new Hand("Discards");
        deck.deal(discardPile, 1);

        // put the rest of the deck face down
        drawPile = new Hand("Draw pile");
        deck.dealAll(drawPile);
    }

    /**
     * Returns true if either hand is empty.
     */
    public boolean isDone() {
        return one.getHand().isEmpty() || two.getHand().isEmpty();
    }

    /**
     * Moves cards from the discard pile to the draw pile and shuffles.
     */
    public void reshuffle() {
        // save the top card
        Card prev = discardPile.popCard();

        // move the rest of the cards
        discardPile.dealAll(drawPile);

        // put the top card back
        discardPile.addCard(prev);

        // shuffle the draw pile
        drawPile.shuffle();
    }

    /**
     * Returns a card from the draw pile.
     */
    public Card drawCard() {
        if (drawPile.isEmpty()) {
            reshuffle();
        }
        return drawPile.popCard();
    }

    /**
     * Switches players.
     */
    public Player nextPlayer(Player current) {
        if (current == one) {
            return two;
        } else {
            return one;
        }
    }

    /**
     * Displays the state of the game.
     */
    public void displayState() {
        //one.display();
        //two.display();
        discardPile.display();
        System.out.print("Draw pile: ");
        System.out.println(drawPile.size() + " cards");
        //in.nextLine();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * One player takes a turn.
     */
    public void takeTurn(Player player) {
        Card prev = discardPile.lastCard();
        Card next = player.play(this, prev);
        discardPile.addCard(next);

        System.out.println(player.getName() + " plays " + next);
        System.out.println();
    }

    /**
     * Plays the game.
     */
    public void playGame() {
        Player player = one;

        // keep playing until there's a winner
        while (!isDone()) {
            displayState();
            takeTurn(player);
            player = nextPlayer(player);
        }

        // display the final score
        one.displayScore();
        two.displayScore();
    }

    /**
     * Creates the game and runs it.
     */
    public static void main(String[] args) {
        Eights game = new Eights();
        game.playGame();
    }

}

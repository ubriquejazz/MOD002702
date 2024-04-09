import java.util.ArrayList;

/**
 * A pile of playing cards (of variable size).
 */
 public class Pile {
    private ArrayList<Card> cards;

    public Pile() {
        this.cards = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card popCard() {
        return this.cards.remove(0);
    }

    public void addDeck(Deck deck) {
        for (Card card : deck.getCards()) {
            this.cards.add(card);
        }
    }

    public void merge(Pile that) {
        this.cards.addAll(that.cards);
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    public int size() {
        return this.cards.size();
    }

}

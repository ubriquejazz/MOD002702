public class PlayerEight extends Player {

    public PlayerEight(String name) {
        super(name);
    }

    public Card play(Eights eights, Card prev) {
        Card card = searchForMatch(prev);
        if (card == null) {
            card = drawForMatch(eights, prev);
        }
        return card;
    }

    public Card searchForMatch(Card prev) {
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            if (card.getRank() == 8) {
                // you might want to play first
                return hand.popCard(i);
            }
            else if (cardMatches(card, prev)) {
                return hand.popCard(i);
            }
        }
        return null;
    }
}

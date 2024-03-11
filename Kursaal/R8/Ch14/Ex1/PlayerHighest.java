public class PlayerHighest extends Player {

    public PlayerHighest(String name) {
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
        // Assume first element is the maximum
        int maxValue = hand.getCard(0).getRank();
        int maxIndex = -1;
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            if (card.getSuit() == prev.getSuit()) {
                if (card.getRank() > maxValue) {
                    maxValue = card.getRank(); // Update max if current element is greater
                    maxIndex = i; // Update maxIndex to the index of the current element
                }   
            }
        }
        if (maxIndex < 0)
            return null;
        else
            return hand.popCard(maxIndex);
    }
}

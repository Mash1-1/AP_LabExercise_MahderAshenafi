import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards;
    public Deck() {
        cards = new ArrayList<Card>();
        for (int i = 1; i < 14; i++) {
            cards.add(new Card(getCardValue(i), "clubs"));
            cards.add(new Card(getCardValue(i), "diamonds"));
            cards.add(new Card(getCardValue(i), "hearts"));
            cards.add(new Card(getCardValue(i), "spades"));
        }

        // Shuffle the deck of cards
        Collections.shuffle(cards);
    }

    String getCardValue(int nm) {
        if (nm < 11 && nm > 1) {
            if (nm != 10) return "0" + nm;
            return "10";
        }

        if (nm == 11) return "J";
        if (nm == 12) return "K";
        if (nm == 13) return "Q";
        return "A";
    }

    public Card getCard() {
        return cards.removeLast();
    }
}

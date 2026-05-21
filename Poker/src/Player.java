import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Player extends HBox {
    // Outside environment
    GameScreen mainScreen;
    Text cashDisplay;
    Text betDisplay;

    // Player props
    public ArrayList<Slot> slots;
    int betAmt = 0;
    int cash = 120;
    boolean folded = false;
    int freeSlotIndex = 0;
    Text name;

    public Player(GameScreen mainScreen, int slotSize, String nameStr) {
        // Create dependencies
        this.mainScreen = mainScreen;
        cashDisplay = new Text("Cash : " + cash);
        betDisplay = new Text("Bet Amount : " + betAmt);
        name = new Text(nameStr);
        name.setStyle("-fx-font-weight: bold; -fx-font-size: 24px");
        slots = new ArrayList<Slot>();
        for (int i = 0; i < slotSize; i++) slots.add(new Slot());

        // Add elements to children
        this.getChildren().add(name);
        this.getChildren().addAll(slots);
        if (slotSize == 2) this.getChildren().addAll(cashDisplay, betDisplay);

        // Some styling
        setAlignment(Pos.CENTER);
        setSpacing(10);
    }

    public void flipCards() {
        for (Slot s : slots) {
            s.flipCard();
        }
    }

    public void call(int amount) {
        if (amount > cash) {
            mainScreen.messageDisplayer.sendMessage("Can not call more than current amount!\n Availabe amount : " + cash);
            return;
        }

        // update actual amounts
        cash -= amount;
        betAmt += amount;

        // update display
        cashDisplay.setText("Cash : " + cash);
        betDisplay.setText("Bet Amount : " + betAmt);
    }

    public void addCard(Card card) {
        slots.get(freeSlotIndex).setCard(card);
        freeSlotIndex++;
    }

    public ArrayList<Card> getCards() {
        ArrayList<Card> cards = new ArrayList<Card>();
        for (Slot s : slots) {
            if (s.slotCard != null) {
                cards.add(s.slotCard);
            }
        }

        return cards;
    }
}

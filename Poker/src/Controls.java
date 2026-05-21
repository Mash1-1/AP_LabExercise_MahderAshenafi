import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Controls extends HBox {
    public Controls(GameScreen mainScreen) {
        // Create control buttons
        Button call = new Button("Call");
        Button fold = new Button("Fold");

        TextField amountInput = new TextField();

        // Set event listeners for the buttons
        call.setOnAction(e -> {
            if (mainScreen.judge.freeSlotIndex == 5 || mainScreen.player.folded || mainScreen.computer.folded) return;
//            try {
                int amt = Integer.parseInt(amountInput.getText());
                if (amt > mainScreen.player.cash) {
                    mainScreen.messageDisplayer.sendMessage("Can not call more than current amount!");
                    return;
                }
                mainScreen.player.call(amt);
                
                if (mainScreen.computer.cash >= amt) {
                    mainScreen.computer.call(amt);
                    
                    if (mainScreen.judge.freeSlotIndex < 5) {
                        mainScreen.judge.addCard(mainScreen.deck.getCard());
                        mainScreen.judge.slots.get(mainScreen.judge.freeSlotIndex - 1).flipCard();
                    }
                    
                    if (mainScreen.judge.freeSlotIndex == 5) {
                        mainScreen.computer.flipCards();
                        mainScreen.gameOver("normal");
                    }
                } else {
                    mainScreen.computer.folded = true;
                    mainScreen.computer.flipCards();
                    mainScreen.gameOver("fold");
                }
//            }
        });

        fold.setOnAction(e -> {
            if (mainScreen.judge.freeSlotIndex == 5 || mainScreen.player.folded || mainScreen.computer.folded) return;
            mainScreen.player.folded = true;
            mainScreen.gameOver("fold");
        });

        // Add fields to HBox
        this.getChildren().addAll(call, fold, amountInput);

        // Some styling
        setAlignment(Pos.CENTER);
    }
}

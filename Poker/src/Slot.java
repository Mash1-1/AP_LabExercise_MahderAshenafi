import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class Slot extends HBox {
    Card slotCard = null;
    int width = 150;
    int height = 170;

    public Slot() {
        this.setDisplay();
    }

    public void setCard(Card card) {
        this.slotCard = card;
        this.slotCard.setFitWidth(this.width - 10);
        this.slotCard.setFitHeight(this.height - 10);
        this.getChildren().add(card);
    }

    public void setDisplay() {
        setMinSize(width, height);
        setPrefSize(width, height);
        setMaxSize(width, height);
        setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #e3dddc;");
//        this.setStyle("-fx-border-color: red; -fx-border-width: 2; -fx-border-style: solid;-fx-background-color: transparent;");

    }

    public void flipCard() {
        if (slotCard != null) {
            slotCard.flip();
        }
    }
}

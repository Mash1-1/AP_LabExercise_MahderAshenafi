import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class MessageDisplayer extends HBox {
    Label message;

    public MessageDisplayer() {
        message = new Label("Hello! Please place a starting bid.");
        message.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        this.getChildren().add(message);
        setAlignment(Pos.CENTER);
    }

    public void sendMessage(String msg) {
        message.setText(msg);
    }
}

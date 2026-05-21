package ClientUI;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Conversation extends VBox {
    public Conversation(String msg) {
        Text message = new Text(msg);
        this.getChildren().add(message);
    }

    public Conversation(String msg, String from) {
        Text frm = new Text(from + ": ");
        Text message = new Text(msg);
        
        this.getChildren().addAll(new HBox(frm, message));
    }
}

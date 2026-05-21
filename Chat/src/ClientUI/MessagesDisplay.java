package ClientUI;

import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MessagesDisplay extends VBox {
    ArrayList<Conversation> conversations;

    public MessagesDisplay() {
        conversations = new ArrayList<Conversation>();
    }

    public void addConversation(Conversation convo) {
        conversations.add(convo);
        this.getChildren().add(convo);
    }
}

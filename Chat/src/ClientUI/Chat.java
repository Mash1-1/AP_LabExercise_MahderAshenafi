package ClientUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Chat extends VBox {
    MessagesDisplay messages;
    TextField userInput;
    Button send;
    Client client;
    TextField targetUser;
    public Chat(Client myClient) {
        messages  = new MessagesDisplay();
        userInput = new TextField();
        send = new Button("send");
        targetUser = new TextField();
        client = myClient;

        send.setOnAction(e -> {sendMessage();});

        this.getChildren().addAll(new Text(myClient.username),  messages, new HBox(new Label("Enter taget user : "), targetUser), new HBox(userInput, send));
    }

    public void sendMessage() {
        // Add message to UI
        String msg = userInput.getText();
        String to = targetUser.getText();
        messages.addConversation(new Conversation(msg));
        client.sendMessage(msg, to);
    }

    public void addMessageToUI(String msg, String from) {
        // Add received message to UI
        messages.addConversation(new Conversation(msg, from));
    }
}

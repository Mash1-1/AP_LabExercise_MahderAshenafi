package ClientUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class UsernameInput extends HBox {
    public UsernameInput(Client mainApp) {
        // Create input controls
        TextField username = new TextField();
        Button submit = new Button("Create");
        Label usernameLabel = new Label("Username : ");

        submit.setOnAction(e -> {
            mainApp.setUsername(username.getText());
            mainApp.goToChat();
        });

        this.getChildren().addAll(usernameLabel, username, submit);
    }
}

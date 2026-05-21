package UIComponents;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Header extends HBox {
    public Header(MainUI mainUI) {
        // Create the buttons
        Button save = new Button("Save");
        Button openFile = new Button("Open");

        // Implement buttons functionality
        save.setOnAction(mainUI::saveFile);

        openFile.setOnAction(mainUI::handleOpen);

        // Add buttons to the header
        this.getChildren().addAll(save, openFile);

        // Create some styling for the header
        this.setPadding(new javafx.geometry.Insets(3, 3, 3, 3));
        this.setSpacing(10);
    }
}

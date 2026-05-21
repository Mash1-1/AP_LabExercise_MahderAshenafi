import UIComponents.MainUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class NotePadApp extends Application {
    public Stage primaryStage;
    TabPane tabPane;
    BorderPane root;
    boolean isLightMode = false;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;

        // 1. Setup Buttons
        Button newTabBtn = new Button("+ New Tab");
        newTabBtn.setOnAction(e -> createTab());

        Button toggleThemeBtn = new Button("Mode: GLITCH");

        // 2. Add a Spacer so the toggle button gets pushed to the far right
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // 3. Create ToolBar
        ToolBar toolBar = new ToolBar(newTabBtn, spacer, toggleThemeBtn);

        // Set up the tab pane
        tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);

        // Set up the main stage
        root = new BorderPane();
        root.setTop(toolBar);
        root.setCenter(tabPane);

        // 4. Create Scene and attach CSS
        Scene mainScene = new Scene(root, 700, 500);
        mainScene.getStylesheets().add(getClass().getResource("./Styling/style.css").toExternalForm());

        // 5. Theme Toggle Logic
        toggleThemeBtn.setOnAction(e -> {
            isLightMode = !isLightMode;
            if (isLightMode) {
                // Add the light-mode class to the BorderPane
                root.getStyleClass().add("light-mode");
                toggleThemeBtn.setText("Mode: LIGHT");
            } else {
                // Remove the light-mode class to revert to default (Dark/Glitch)
                root.getStyleClass().remove("light-mode");
                toggleThemeBtn.setText("Mode: GLITCH");
            }
        });

        createTab();
        stage.setScene(mainScene);
        stage.setTitle("GlitchPad");
        stage.show();
    }

    public void createTab() {
        Tab tab = new Tab("unnamed");
        MainUI mainUI = new MainUI(this, primaryStage, tab);
        tab.setContent(mainUI);
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
    }
}
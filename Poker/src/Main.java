import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    GameScreen gameScreen;
    Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        gameScreen = new GameScreen(this);
        this.primaryStage = stage;

        // Create the game-screen scene
        Scene gameScene = new Scene(gameScreen, 1000, 700);
        stage.setScene(gameScene);
        stage.show();
    }

    public void reStart() {
        // Create new game scene
        gameScreen = new GameScreen(this);
        Scene gameScene = new Scene(gameScreen, 1000, 700);
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }
}

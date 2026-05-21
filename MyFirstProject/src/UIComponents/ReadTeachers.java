package UIComponents;

import Myapp.Mainapp;
import University.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ReadTeachers extends VBox {
    public ReadTeachers(Mainapp mainapp) {
        ListView<Teacher> listView = new ListView<Teacher>();

        ArrayList<Teacher> teachers = mainapp.db.readTeachers(mainapp.con);
        ObservableList<Teacher> observableData = FXCollections.observableArrayList(teachers);
        listView.setItems(observableData);

        Button backToMenu = new Button("Back to Main Menu");
        backToMenu.setOnAction(event -> {
            mainapp.showMainMenu();
        });
        this.getChildren().addAll(listView, backToMenu);
    }
}

package UIComponents;

import Myapp.Mainapp;
import University.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ReadStudents extends VBox {
    public ReadStudents(Mainapp mainapp) {
        ListView<Student> listView = new ListView<Student>();

        ArrayList<Student> students = mainapp.db.readStudents(mainapp.con);
        ObservableList<Student> observableData = FXCollections.observableArrayList(students);
        listView.setItems(observableData);

        Button backToMenu = new Button("Back to Main Menu");
        backToMenu.setOnAction(event -> {
            mainapp.showMainMenu();
        });
        this.getChildren().addAll(listView, backToMenu);
    }
}

package UIComponents;

import Myapp.Mainapp;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainMenu extends VBox {
    public MainMenu(Mainapp mainapp) {
        Button addStud = new Button("Add Student");
        Button addTeacher = new Button("Add Teacher");
        Button readStud = new Button("List Students");
        Button readTeach = new Button("List Teachers");


        addStud.setOnAction((event) -> {
            mainapp.showCreateStudent();
        });

        addTeacher.setOnAction((event) -> {
            mainapp.showCreateTeacher();
        });

        readTeach.setOnAction(event -> {
            mainapp.showReadTeacher();
        });

        readStud.setOnAction(event -> {
            mainapp.showReadStudents();
        });

        this.getChildren().addAll(addStud, addTeacher, readStud, readTeach);
        this.setAlignment(Pos.CENTER);
    }
}

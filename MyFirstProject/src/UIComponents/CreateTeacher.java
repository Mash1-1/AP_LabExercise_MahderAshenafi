package UIComponents;

import Myapp.Mainapp;
import University.Teacher;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class CreateTeacher extends VBox {
    public CreateTeacher(Mainapp mainapp) {
        Label id = new Label("ID");
        Label name = new Label("Name");
        Label department = new Label("Department");

        TextField idInp = new TextField();
        idInp.setMaxWidth(100);
        idInp.setAlignment(Pos.CENTER);

        TextField nameInp = new TextField();
        nameInp.setMaxWidth(100);

        TextField departmentInp = new TextField();
        departmentInp.setMaxWidth(100);


        Button submit = new Button("Submit");
        Button backToMenu = new Button("Back to Main Menu");
        backToMenu.setOnAction(event -> {
            mainapp.showMainMenu();
        });
        this.getChildren().addAll(id, idInp, name,nameInp, department,departmentInp, submit, backToMenu);
        this.setAlignment(Pos.CENTER);

        submit.setOnAction(event -> {
            Teacher teach = new Teacher(nameInp.getText(), departmentInp.getText(), idInp.getText());
            ArrayList<Teacher> teachers = new ArrayList<Teacher>();
            teachers.add(teach);
            mainapp.db.insertTeacher(teachers, mainapp.con);
        });
    }
}

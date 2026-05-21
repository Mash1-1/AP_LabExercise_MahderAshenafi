package UIComponents;

import Myapp.Mainapp;
import University.Student;
import University.Teacher;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class CreateStudent extends VBox {
    public CreateStudent(Mainapp mainapp) {
        Label id = new Label("ID");
        Label name = new Label("Name");
        Label year = new Label("Year");
        Label department = new Label("Department");
        Label section = new Label("Section");

        TextField idInp = new TextField();
        idInp.setMaxWidth(100);
        idInp.setAlignment(Pos.CENTER);

        TextField nameInp = new TextField();
        nameInp.setMaxWidth(100);

        TextField yearInp = new TextField();
        yearInp.setMaxWidth(100);

        TextField departmentInp = new TextField();
        departmentInp.setMaxWidth(100);

        TextField sectionInp = new TextField();
        sectionInp.setMaxWidth(100);


        Button submit = new Button("Submit");
        Button backToMenu = new Button("Back to Main Menu");
        backToMenu.setOnAction(event -> {
            mainapp.showMainMenu();
        });
        this.getChildren().addAll(id, idInp, name,nameInp, year,yearInp, department,departmentInp,  section,sectionInp, submit, backToMenu);
        this.setAlignment(Pos.CENTER);
        submit.setOnAction(event -> {
            ArrayList<Student> students = new ArrayList<Student>();
            mainapp.db.insertStudent(students, mainapp.con);
        });
    }
}

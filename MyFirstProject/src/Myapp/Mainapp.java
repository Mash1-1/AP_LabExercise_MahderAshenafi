package Myapp;
import UIComponents.*;
import University.*;

import java.sql.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mainapp extends Application{
    MainMenu menu;
    CreateStudent createStudent;
    CreateTeacher createTeacher;
    ReadTeachers readTeachers;
    ReadStudents readStudents;
    Stage primaryStage;
    public Database db;
    public Connection con;

    // Scenes
    Scene createStudentScene ;
    Scene createTeacherScene;
    Scene readTeachScene;
    Scene readStudScene;
    Scene menuScene;

    static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        System.out.println("Initializing app");
        menu = new MainMenu(this);
        createStudent = new CreateStudent(this);
        createTeacher = new CreateTeacher(this);

        this.db = new Database();
        System.out.println("Creating a database connection");
        con = this.db.createConnection();
        if (con == null) {
            System.out.println("Error when connecting to database");
            return;
        }

        readTeachers = new ReadTeachers(this);
        readStudents = new ReadStudents(this);

        // Initialize scenes
        createStudentScene = new Scene(this.createStudent, 500, 500);
        createTeacherScene = new Scene(this.createTeacher, 500, 500);
        readTeachScene = new Scene(this.readTeachers, 500, 500);
        readStudScene = new Scene(this.readStudents, 500, 500);
        menuScene = new Scene(this.menu, 500, 500);
        System.out.println("Database Connection created successfully");
    }

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        stage.setTitle("University Management");

        stage.setScene(menuScene);
        stage.show();
    }

    public void showCreateStudent() {
        primaryStage.setScene(createStudentScene);
        primaryStage.show();
    }

    public void showCreateTeacher() {
        primaryStage.setScene(createTeacherScene);
        primaryStage.show();
    }
    public void showReadTeacher() {
        primaryStage.setScene(readTeachScene);
        primaryStage.show();
    }

    public void showReadStudents() {
        primaryStage.setScene(readStudScene);
        primaryStage.show();
    }

    public void showMainMenu() {
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }
}

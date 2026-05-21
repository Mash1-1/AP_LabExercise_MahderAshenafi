package UIComponents;

import FileControl.ReadWrite;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainUI extends VBox {
    Header header;
    Notepad notePad;
    ReadWrite fileControl;
    public Stage primaryStage;
    public File currentFile = null;
    Tab myTab;

    public MainUI(Application mainApp, Stage primaryStage, Tab myTab) {
        this.notePad = new Notepad(this);
        this.header = new Header(this);
        this.fileControl = new ReadWrite();
        this.getChildren().addAll(header, notePad);
        this.primaryStage = primaryStage;
        this.myTab = myTab;
    }

    public void saveFile(ActionEvent e) {
        String content = this.notePad.getInp();
        if (currentFile == null) {
            // Create a file chooser and make the user select where to put the file
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

            File file = fileChooser.showSaveDialog(primaryStage);

            if (file == null) {
                System.out.println("Error when getting file from 'save as' file chooser!");
                return;
            }
            currentFile = file;
        }

        int err = fileControl.writeToFile(content, currentFile);
        if (err == -1) {
            System.out.println("error when writing to file!");
            return;
        }
        myTab.setText(currentFile.getName());
        System.out.println("Successfully wrote to file.");
    }

    public void handleOpen(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            String content = fileControl.readFromFile(selectedFile);
            notePad.note.setText(content);
            currentFile = selectedFile;
            myTab.setText(currentFile.getName());
        } else {
            System.out.println("Error when getting file from 'open file' file chooser!");
        }
    }
}

package UIComponents;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class Notepad extends VBox{
    public TextArea note;
    public Notepad(MainUI mainUI) {
        TextArea ta = new TextArea("Hello World!");
        this.note = ta;
        ta.setMinHeight(500);
        this.getChildren().addAll(ta);
    }

    public String getInp() {
        return note.getText();
    }
}

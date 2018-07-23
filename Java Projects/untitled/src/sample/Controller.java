package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller {
    public TextField string1;

    public void printText(ActionEvent actionEvent) {
        this.string1.setText(String.valueOf("Hello World!"));
    }
    public void clearText(ActionEvent actionEvent) {
        this.string1.setText(String.valueOf(""));
    }
}

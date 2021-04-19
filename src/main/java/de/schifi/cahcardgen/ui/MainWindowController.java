package de.schifi.cahcardgen.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainWindowController {

    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private void changeText() {
        label.setText("This text changed!");
    }

}

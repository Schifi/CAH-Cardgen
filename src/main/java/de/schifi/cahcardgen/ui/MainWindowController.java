package de.schifi.cahcardgen.ui;

import de.schifi.cahcardgen.main.CardGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;

public class MainWindowController {

    private CardGenerator cardGenerator;

    @FXML
    private Button buttonFileChooser;

    @FXML
    private Button buttonStartGenerating;

    @FXML
    private void openFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose the file with the card-text ...");
        File file = fileChooser.showOpenDialog(buttonFileChooser.getScene().getWindow());
        cardGenerator = new CardGenerator(file);
        buttonStartGenerating.setDisable(false);
    }

    @FXML
    private void generateImages() {
        cardGenerator.generateCards();
    }

}

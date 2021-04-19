package de.schifi.cahcardgen.ui;

import de.schifi.cahcardgen.main.CardGenerator;
import de.schifi.cahcardgen.main.CardType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;

import java.io.File;

public class MainWindowController {

    private CardGenerator cardGenerator;

    @FXML
    private Button buttonFileChooser;

    @FXML
    private Button buttonStartGenerating;

    @FXML
    private RadioButton toggleWhite;

    @FXML
    private RadioButton toggleBlack;

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
        if (toggleWhite.isSelected()) {
            cardGenerator.setCardType(CardType.WHITE);
        } else if (toggleBlack.isSelected()) {
            cardGenerator.setCardType(CardType.BLACK);
        }

        cardGenerator.generateCards();
    }

}

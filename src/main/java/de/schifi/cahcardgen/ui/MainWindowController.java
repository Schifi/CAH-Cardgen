package de.schifi.cahcardgen.ui;

import de.schifi.cahcardgen.main.CardGenerator;
import de.schifi.cahcardgen.main.CardType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;

public class MainWindowController {

    private CardGenerator cardGenerator;

    @FXML
    private Label labelInfo;

    @FXML
    private Button buttonFileChooser;

    @FXML
    private Button buttonStartGenerating;

    @FXML
    private RadioButton toggleWhite;

    @FXML
    private RadioButton toggleBlack;

    @FXML
    private CheckBox checkBoxDeckname;

    @FXML
    private TextField textFieldDeckname;

    @FXML
    private Spinner<Integer> spinnerWidth;

    @FXML
    private Spinner<Integer> spinnerHeight;

    @FXML
    public void initialize() {
        spinnerWidth.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(300, 3000, 1000));
        spinnerHeight.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(300, 3000, 1000));
    }

    @FXML
    private void openFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select the textfile ...");
        File file = fileChooser.showOpenDialog(buttonFileChooser.getScene().getWindow());
        cardGenerator = new CardGenerator(file);
        buttonStartGenerating.setDisable(false);
        labelInfo.setText("File found. Ready to generate.");
    }

    @FXML
    private void toggleDeckname() {
        if (checkBoxDeckname.isSelected()) {
            textFieldDeckname.setDisable(false);
        } else {
            textFieldDeckname.setDisable(true);
        }
    }

    @FXML
    private void generateImages() {
        cardGenerator.setWidth(spinnerWidth.getValue());
        cardGenerator.setHeight(spinnerHeight.getValue());

        if (toggleWhite.isSelected()) {
            cardGenerator.setCardType(CardType.WHITE);
        } else if (toggleBlack.isSelected()) {
            cardGenerator.setCardType(CardType.BLACK);
        }

        if (checkBoxDeckname.isSelected()) {
            cardGenerator.setDeckname(textFieldDeckname.getText());
        } else {
            cardGenerator.setDeckname("");
        }

        int generatedCards = cardGenerator.generateCards();
        labelInfo.setText("Successfully generated " + generatedCards + " cards!");
    }

}
